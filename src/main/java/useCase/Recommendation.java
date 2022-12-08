// by Arist Alfred Bravo

package useCase;

import entities.ComparingProfile;
import entities.UserAccount;

import java.util.*;

public class Recommendation implements RecInputBoundary {

    private RecOutputBoundary outputManager;
    private HashMap<String, ComparingProfile> nameToComp;
    private DatabaseManager databaseRef;


    /**
     * Construct a Recommendation use case object with
     * the given output boundary and data access interface objects.
     *
     * @param outputManager     An output boundary, usually a presenter
     */
    public Recommendation(RecOutputBoundary outputManager){
        this.outputManager = outputManager;
        this.nameToComp = new HashMap<>();
        this.databaseRef = DatabaseManager.getDatabaseManager();
    }

    /**
     * Make recommendations with information already stored
     * in the program, calling an OutputBoundary object
     * to do such processing.
     */
    public RecommendedProfiles makeRecommendations(){

        // Get the current user of the program
        UserAccount currentUser = this.getCurrentUser();

        // Get possible users
        ArrayList<UserAccount> filteredUsers =
                this.getPossibleMatches(currentUser.getGender(), currentUser.getSexuality(), currentUser);

        // Start by getting the final users
        ArrayList<UserAccount> finalUsers = this.chooseRandomUsers(filteredUsers);
        ArrayList<ComparingProfile> compList = new ArrayList<>();

        // Go through each profile to compute compatibility and update the list of ComparingProfiles if needed
        for (UserAccount chosenUser : finalUsers) {
            String chosenUsername = calculateCompatibility(currentUser, chosenUser);
            compList.add(this.nameToComp.get(chosenUsername));
        }

        // Sort the list of profiles based on compatibility
        // A future alternative would be to introduce a custom sorting function that sorts
        // the compList and finalUsers lists simultaneously
        Collections.sort(compList);

        // TODO put stuff into a separate Builder class that the RecUC does
        // Create a sorted final users' list
        ArrayList<String> sortedFinalUsers = new ArrayList<>();

        // Go through each ComparingProfile
        for (ComparingProfile compProfile : compList) {

            // For each user in finalUsers: if the usernames match, then we found the user, and add the
            // UserAccount to the sortedFinalUsers
            for (UserAccount maybeUser : finalUsers) {
                if (Objects.equals(compProfile.getName(), maybeUser.getUsername())) {
                    sortedFinalUsers.add(maybeUser.getUsername());
                }
            }
        }

        // Create recommended profiles in an object
        RecommendedProfiles profilesToShow = createRecOutput(currentUser, compList, sortedFinalUsers);

        // Send recommended profiles to the adapter layer through the output boundary
        this.outputManager.showRecommendations(profilesToShow);

        // For testing, return the recommended profiles
        return profilesToShow;
    }

    private String calculateCompatibility(UserAccount currentUser, UserAccount chosenUser) {

        // Compute compatibility of this user and the new user
        double likeScore = computeCompatibility(currentUser, chosenUser);

        // Check if the user exists in the stored mapping
        String chosenUsername = chosenUser.getUsername();
        ComparingProfile possibleProfile = this.nameToComp.get(chosenUsername);

        // If it exists, then update its compatibility score
        if (possibleProfile != null) {
            possibleProfile.setCompatibility(likeScore);

        // Else, create a new ComparingProfile for the user and add it to the mapping
        } else {
            String userCountry = chosenUser.getCountry();
            String userSexuality = chosenUser.getSexuality();
            ComparingProfile newProfile = new ComparingProfile(chosenUser.getUsername(),
                    chosenUser.getInterest(), userCountry, userSexuality, likeScore);
            this.nameToComp.put(chosenUsername, newProfile);
        }

        // Return the chosen username
        return chosenUsername;
    }

    /**
     * Get current user which is logged in.
     * This presumes that there is already a current user to get.
     */
    private UserAccount getCurrentUser(){

        // Get and return the current user, presuming login is already done
        CurrUserManager singletonUserManager = CurrUserManager.getCurrUserManager();
        return singletonUserManager.getCurrUser();
    }

    /**
     * Return whether there is a match of gender and sexuality
     * between information for two users.
     *
     * @param u1Gender      User 1's gender as given in UserAccount
     * @param u1Sex         User 1's sexuality as given in UserAccount
     * @param u2Gender      User 2's gender as given in UserAccount
     * @param u2Sex         User 2's sexuality as given in UserAccount
     *
     * @return              Whether the users match
     */
    private boolean genderSexMatches(String u1Gender, String u1Sex, String u2Gender, String u2Sex){

        // Create a mapping of sexuality and/or gender codes to the corresponding desired gender codes
        HashMap<String, String> desiredGender = new HashMap<>();

        // For bisexual, lesbian, gay: map to the corresponding genders accepted
        desiredGender.put("B", "MFN");
        desiredGender.put("L", "F");
        desiredGender.put("G", "M");

        // For heterosexual (coded as Hetero+Gender): map to the "opposite" gender
        desiredGender.put("HM", "F");
        desiredGender.put("HF", "M");
        desiredGender.put("HN", "N");

        // See what gender each user desires, depending on their sexuality; different logic is for straight people

        // For user 1: if they are hetero, then who they want depends on user 1's gender too; else,
        // it does not, so merely consider sexuality
        String u1Wants = "";
        if (Objects.equals(u1Sex, "H")) {
            u1Wants = desiredGender.get("H" + u1Gender);
        } else {
            u1Wants = desiredGender.get(u1Sex);
        }

        // For user 2: if they are hetero, then who they want depends on user 1's gender too; else,
        // it does not, so merely consider sexuality
        String u2Wants = "";
        if (Objects.equals(u2Sex, "H")) {
            u2Wants = desiredGender.get("H" + u2Gender);
        } else {
            u2Wants = desiredGender.get(u2Sex);
        }

        // Return whether the users would want each other
        return (u2Wants.contains(u1Gender) && u1Wants.contains(u2Gender));
    }

    /**
     * Get a list of possible (valid gender-sexuality) matches.
     * Given are the gender and sexuality of the current user.
     * Blocked people are not included.
     *
     * @param userGender    User's gender
     * @param userSex       User's sexuality
     * @param currentUser   Current user
     *
     * @return              A list of matches as ComparingProfiles
     */
    private ArrayList<UserAccount> getPossibleMatches(String userGender, String userSex, UserAccount currentUser){

        // Define a list of possible users
        ArrayList<UserAccount> potentialUsers = new ArrayList<>();

        // Go through the current user's blocked users and fetch a list of usernames for blocked people
        ArrayList<String> blockedUsernames = new ArrayList<>();
        for (UserAccount blockedUser : currentUser.getBlockedUsers()) {
            blockedUsernames.add(blockedUser.getUsername());
        }

        // Using the database, go through each contained member to determine if they ought to be brought
        // into the use case as a valid user

        // To start, get the database and its data, presuming login is already done
        HashMap<String, UserAccount> userDataMap = this.databaseRef.getDatabase().getData();

        // Iterate through each account
        for (UserAccount maybeValidUser : userDataMap.values()) {

            // If the possible user does not have the same username as the current user,
            // and the users have compatible gender-sexuality,
            // and the possible user is not being blocked,
            // then add the possible user to the array
            if ( (!Objects.equals(maybeValidUser.getUsername(), currentUser.getUsername()))
                    && genderSexMatches(currentUser.getGender(), currentUser.getSexuality(),
                    maybeValidUser.getGender(), maybeValidUser.getSexuality())
                    && (!blockedUsernames.contains(maybeValidUser.getUsername())) ) {
                potentialUsers.add(maybeValidUser);
            }
        }

        // Return the possible users
        return potentialUsers;
    }

    /**
     * Return a list of UserAccounts without the users blocked by
     * the current user, given a list of UserAccounts to filter through
     * and a list of blocked users.
     * As of now, this method can be deprecated, but it is kept in
     * the code in case it is of use in the future.
     *
     * @param oldPossibleUsers      A list of UserAccounts to filter through
     * @param blockedUsers          A list of blocked UserAccounts
     */
    private ArrayList<UserAccount> takeOutBlocked(ArrayList<UserAccount> oldPossibleUsers,
                                                     ArrayList<UserAccount> blockedUsers) {
        // Define an array of filtered users
        ArrayList<UserAccount> filteredList = new ArrayList<>();

        // Go through each user to check
        for (UserAccount checkedUser : oldPossibleUsers) {

            // If the blocked user list does not contain the checked user, then add the
            // checked user to the filtered list
            // Note that this might have a chance of failing if UserAccount objects
            // have different memory addresses
            if (!(blockedUsers.contains(checkedUser))) {
                filteredList.add(checkedUser);
            }
        }

        // Returned the filtered array
        return filteredList;
    }

    /**
     * Randomly pick users from the inputted list and return the list with the choices.
     * Note that this does not yet handle a case where the inputted list is empty.
     * In this case, we pick at most 5 users randomly.
     *
     * @param pickerList       An ArrayList of UserAccounts to pick from
     */
    private ArrayList<UserAccount> chooseRandomUsers(ArrayList<UserAccount> pickerList) {

        // If there is at most 5 users, return them
        if (pickerList.size() <= 5) {
            return pickerList;

        // Else, do random picking of 5 users
        } else {

            // Create a Random object
            Random randomizer = new Random();

            // Create a randomized list and a shallow copy of the pickerList
            ArrayList<UserAccount> randomList = new ArrayList<>();
            ArrayList<UserAccount> pickerCopy = (ArrayList<UserAccount>) pickerList.clone();

            // Loop 5 times
            for (int i = 1; i <= 5; i++) {

                // Randomly pop from the copy and add the referred-to user to the final randomized list
                int currentSize = pickerCopy.size();
                int randomInt = randomizer.nextInt(currentSize);
                randomList.add(pickerCopy.get(randomInt));
                pickerCopy.remove(randomInt);
            }

            // Return the random list
            return randomList;
        }
    }

    /**
     * Given 2 user accounts, return their compatibility score
     * relative to user1 recommendations.
     *
     * @param user1         First UserAccount
     * @param user2         Second UserAccount
     */
    private double computeCompatibility(UserAccount user1, UserAccount user2) {

        // Define an accumulator to store the score sum
        double scoreSum = 0.0;

        // If the top interests are shared, then bump score sum
        if (Objects.equals(user1.getInterest(), user2.getInterest())) {
            scoreSum = scoreSum + 1;
        }

        // Add a point for whether the country of both users is equivalent
        if (Objects.equals(user1.getCountry(), user2.getCountry())) {
            scoreSum = scoreSum + 1;
        }

        // Add a point for whether user2 likes user1
        if (user1.getLikedByUsers().contains(user2)) {
            scoreSum = scoreSum + 1;
        }

        // Return the compatibility as a weighted average out of the maximum points
        return scoreSum / 3.0;
    }

    /**
     * Return a RecommendedProfiles object, given an ordered
     * ArrayList of user profiles to go recommend in that order.
     *
     * @param currentUserObj    The UserAccount for the current user
     * @param newCompList       List of ComparingProfiles to recommend
     * @param parallelList      A UserAccount version of newCompList
     *
     * @return                  A RecommendedProfiles object as output data
     */
    private RecommendedProfiles createRecOutput(UserAccount currentUserObj,
                                                ArrayList<ComparingProfile> newCompList,
                                                ArrayList<String> parallelList) {

        // Create an ArrayList for all the recommended users
        ArrayList<RecOutProfile> recommendationList = new ArrayList<>();

        // Iterate through each profile
        for (ComparingProfile sortedProfile : newCompList) {

            // Create an output profile for the profile and add it to the ArrayList
            RecOutProfile outProfile = new RecOutProfile(sortedProfile.getName());
            recommendationList.add(outProfile);
        }

        // Create the RecommendedProfiles object and return it
        return new RecommendedProfiles(currentUserObj, recommendationList, parallelList);
    }
}
