// by Arist Alfred Bravo

package useCase;

import entities.ComparingProfile;
import entities.UserAccount;

import java.util.*;

public class Recommendation implements RecInputBoundary {

    private final RecOutputBoundary outputManager;
    private final HashMap<String, ComparingProfile> nameToComp;
    private final CompProfileFactory compProfileFactory;
    private final RecOutputBuilder recOutputBuilder;
    private final RecDataGetter dataGetter;

    /**
     * Construct a Recommendation use case object with
     * the given output boundary.
     * This is in the case where the developer does not
     * want to pass their own data getter in.
     *
     * @param outputManager     An output boundary, usually a presenter
     */
    public Recommendation(RecOutputBoundary outputManager){
        this.outputManager = outputManager;
        this.nameToComp = new HashMap<>();
        this.compProfileFactory = new CompProfileFactory();
        this.recOutputBuilder = new RecOutputBuilder1();
        this.dataGetter = new RecDataGetFacade();
    }

    /**
     * Construct a Recommendation use case object with
     * the given output boundary.
     * This is in the case where the developer does
     * want to pass their own data getter in.
     *
     * @param outputManager     An output boundary, usually a presenter
     * @param dataGetObject     An object with which you can get data (current user, database data)
     */
    public Recommendation(RecOutputBoundary outputManager, RecDataGetter dataGetObject){
        this.outputManager = outputManager;
        this.nameToComp = new HashMap<>();
        this.compProfileFactory = new CompProfileFactory();
        this.recOutputBuilder = new RecOutputBuilder1();
        this.dataGetter = dataGetObject;
    }

    /**
     * Construct a Recommendation use case object with
     * the given output boundary.
     * This is in the case where the developer does not
     * want to pass their own data getter and output builder in
     * (preserving open-closed principle).
     *
     * @param outputManager     An output boundary, usually a presenter
     * @param dataGetObject     An object with which you can get data (current user, database data)
     * @param newRecOutBuilder  An output builder object
     */
    public Recommendation(RecOutputBoundary outputManager, RecDataGetter dataGetObject,
                          RecOutputBuilder newRecOutBuilder){
        this.outputManager = outputManager;
        this.nameToComp = new HashMap<>();
        this.compProfileFactory = new CompProfileFactory();
        this.recOutputBuilder = newRecOutBuilder;
        this.dataGetter = dataGetObject;
    }

    /**
     * Make recommendations with information already stored
     * in the program, calling an OutputBoundary object
     * to do such processing.
     *
     * @return  RecommendedProfiles as a sort of output to the UI layer
     */
    public RecommendedProfiles makeRecommendations(){

        // Get the current user of the program
        UserAccount currentUser = this.dataGetter.getCurrentUser();

        // Get possible users
        ArrayList<UserAccount> filteredUsers =
                this.getPossibleMatches(currentUser);

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

        // Get a list of sorted final users where the users are strings
        //ArrayList<String> sortedFinalUsers = getSortedFinalUsers(finalUsers, compList);

        // Create recommended profiles in an object
        //RecommendedProfiles profilesToShow = createRecOutput(currentUser, compList, sortedFinalUsers);

        // Create recommended profiles in an object
        RecommendedProfiles profilesToShow = this.recOutputBuilder.constructRecOutput(currentUser,
                finalUsers, compList);

        // Send recommended profiles to the adapter layer through the output boundary
        this.outputManager.showRecommendations(profilesToShow);

        // For testing, return the recommended profiles
        return profilesToShow;
    }

    /**
     * Calculate the current user's compatibility score, given the chosen user for matchmaking.
     *
     * @param currentUser       The current user to which the score applies
     * @param chosenUser        The user chosen for matchmaking with the current user
     *
     * @return                  The current user's compatibility to the chosen user
     */
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
            ComparingProfile newProfile = this.compProfileFactory.makeCompProfile(chosenUser.getUsername(),
                    chosenUser.getInterest(), userCountry, userSexuality, likeScore);
            this.nameToComp.put(chosenUsername, newProfile);
        }

        // Return the chosen username
        return chosenUsername;
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
        String u1Wants;
        if (Objects.equals(u1Sex, "H")) {
            u1Wants = desiredGender.get("H" + u1Gender);
        } else {
            u1Wants = desiredGender.get(u1Sex);
        }

        // For user 2: if they are hetero, then who they want depends on user 1's gender too; else,
        // it does not, so merely consider sexuality
        String u2Wants;
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
     * @param currentUser   Current user
     *
     * @return              A list of matches as ComparingProfiles
     */
    private ArrayList<UserAccount> getPossibleMatches(UserAccount currentUser){

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
        HashMap<String, UserAccount> userDataMap = this.dataGetter.getDatabaseData();

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

            // Create a randomized list and a shallow copy of the pickerList, noting that
            // the casting is needed for the shallow copy to be manipulate-able
            ArrayList<UserAccount> randomList = new ArrayList<>();
            ArrayList<UserAccount> pickerCopy = (ArrayList<UserAccount>) pickerList.clone();

            // Loop to randomly pop from the copy and add the referred-to user to the final randomized list
            for (int i = 1; i <= 5; i++) {
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

}