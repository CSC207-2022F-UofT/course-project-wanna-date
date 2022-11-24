// by Arist Alfred Bravo

package UseCase;

import Entities.ComparingProfile;
import Entities.OldUserAccount;
import Entities.UserAccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Recommendation implements RecInputBoundary {

    private RecOutputBoundary outputManager;
    private RecDataAccessInterface dataManager;
    private HashMap<String, ComparingProfile> nameToComp;

    /**
     * Construct a Recommendation use case object with
     * the given output boundary and data access interface objects.
     *
     * @param outputManager     An output boundary, usually a presenter
     * @param dataManager       A data access interface object
     */
    public Recommendation(RecOutputBoundary outputManager, RecDataAccessInterface dataManager){
        this.outputManager = outputManager;
        this.dataManager = dataManager;
        this.nameToComp = new HashMap<>();
    }

    /**
     * Make recommendations with information already stored
     * in the program, calling an OutputBoundary object
     * to do such processing.
     */
    public void MakeRecommendations(){

        // Get the current user of the program
        UserAccount currentUser = this.getCurrentUser();

        // Get possible users
        ArrayList<ComparingProfile> possibleUsers =
                this.getPossibleMatches(currentUser.get_gender(), currentUser.get_sexuality());

        // TODO: update the general recommendation algo outlined below

        // Get information of blocked users and users who liked the current user
        ArrayList<OldUserAccount> blockedUsers = currentUser.get_blocked_users();

        // Using information of blocked users, take out any users who are blocked; note that
        // this might lead there to being less recommendations
        ArrayList<OldUserAccount> filteredUsers = this.takeOutBlocked(possibleUsers, blockedUsers);

        // In this next part, choose random users from the information and create ComparingProfiles tailored
        // to the system's current user, if these profiles do not yet exist; otherwise,
        // update the profile's compatibility score; at the end, put them into a list

        // Start by getting the final users
        ArrayList<OldUserAccount> finalUsers = this.chooseRandomUsers(filteredUsers);

        // Create a list to store the finalized ComparingProfiles
        ArrayList<ComparingProfile> compList = new ArrayList<>();

        // Go through each profile
        for (OldUserAccount chosenUser : filteredUsers) {

            // Compute compatibility of this user and the new user
            double likeScore = computeCompatibility(currentUser, chosenUser);

            // Check if the user exists in the stored mapping
            String chosenUsername = chosenUser.get_username();
            ComparingProfile possibleProfile = this.nameToComp.get(chosenUsername);

            // If it exists, then update its compatibility score
            if (possibleProfile != null) {
                possibleProfile.setCompatibility(likeScore);

            // Else, create a new ComparingProfile for the user and add it to the mapping
            } else {
                String userCountry = (String) chosenUser.get_location().get("country");
                String sexuality = ((Character) chosenUser.get_sexuality()).toString();
                ComparingProfile newProfile = new ComparingProfile(chosenUser.get_full_name(),
                        chosenUser.get_interests(), userCountry, sexuality, likeScore);
                this.nameToComp.put(chosenUsername, newProfile);
            }

            // Lastly, update the list that stores ComparingProfiles
            compList.add(this.nameToComp.get(chosenUsername));
        }

        // Sort the list of profiles based on compatibility, in decreasing order (as defined by how
        // two profiles ought to be compared)
        Collections.sort(compList);

        // Create recommended profiles in an object
        RecommendedProfiles profilesToShow = createRecOutput(currentUser, compList);

        // Send recommended profiles to the adapter layer through the output boundary
        this.outputManager.ShowRecommendations(profilesToShow);
    }

    /**
     * Get current user which is logged in.
     * This presumes that there is already a current user to get.
     */
    private UserAccount getCurrentUser(){
        // TODO: update the method of getting the current user below, as it has changed from CRC
        //  that is, change OldUserAccount return type to UserAccount OR BETTER YET, change it
        //  into the ComparingProfile so that we can skip the affair of constructing from UserAccounts
        return (UserAccount) new Object();
    }

    /**
     * Get a list of possible (valid sexuality) matches.
     * Given are the gender and sexuality of the current user.
     *
     * @param userGender    User's gender
     * @param userSex       User's sexuality
     *
     * @return              A list of matches as ComparingProfiles
     */
    private ArrayList<ComparingProfile> getPossibleMatches(String userGender, String userSex){

        // Decide on what genders and sexualities to search for depending on the combination of user's
        // gender and sexuality; put these into sets
        // TODO

        // TODO: update from the database instead of getting common code from Chris, as
        //  Chris's implementation changed last-minute
        // Compute a list of possible users
        ArrayList<ComparingProfile> potentialUsers = dataManager.getValidUsers();

        // Return the possible users
        return potentialUsers;
    }

    /**
     * Return a list of UserAccounts without the users blocked by
     * the current user, given a list of UserAccounts to filter through
     * and a list of blocked users.
     *
     * @param oldPossibleUsers      A list of UserAccounts to filter through
     * @param blockedUsers          A list of blocked UserAccounts
     */
    private ArrayList<OldUserAccount> takeOutBlocked(ArrayList<OldUserAccount> oldPossibleUsers,
                                                     ArrayList<OldUserAccount> blockedUsers) {

        // Define an array of filtered users
        ArrayList<OldUserAccount> filteredList = new ArrayList<>();

        // Go through each user to check
        for (OldUserAccount checkedUser : oldPossibleUsers) {

            // If the blocked user list does not contain the checked user, then add the
            // checked user to the filtered list
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
     *
     * @param pickerList       An ArrayList of UserAccounts to pick from
     */
    private ArrayList<OldUserAccount> chooseRandomUsers(ArrayList<OldUserAccount> pickerList) {

        // If there is at most 5 users, return them
        if (pickerList.size() <= 5) {
            return pickerList;

        // Else, do random picking of 5 users
        } else {

            // Create a Random object
            Random randomizer = new Random();

            // Create a randomized list and a shallow copy of the pickerList
            ArrayList<OldUserAccount> randomList = new ArrayList<>();
            ArrayList<OldUserAccount> pickerCopy = (ArrayList<OldUserAccount>) pickerList.clone();

            // Loop 5 times
            for (int i = 1; i <= 5; i++) {

                // Randomly pop from the copy and add the referred-to user to the final randomized list
                int currentSize = pickerCopy.size();
                int randomInt = randomizer.nextInt(currentSize);
                randomList.add(pickerCopy.get(randomInt));
                randomList.remove(randomInt);
            }

            // Return the random list
            return randomList;
        }
    }

    /**
     * Given 2 user accounts, return their compatibility score.
     *
     * @param user1         First UserAccount
     * @param user2         Second UserAccount
     */
    private double computeCompatibility(OldUserAccount user1, OldUserAccount user2) {

        // Define an accumulator to store the score sum
        double scoreSum = 0.0;

        // Add the proportion of interests in user1's interests which are shared
        // This is an interim approach that might get optimized later on to account for the
        // method of storage for UserAccounts
        // TODO: update to account for Lovina's changes

        // Start by declaring variables to count the number of shared interests and interests overall
        double sharedInterests = 0;
        ArrayList<String> user1Interests = user1.get_interests();
        ArrayList<String> user2Interests = user2.get_interests();
        int interestCount = user1Interests.size();

        // Go through each interest to see if it is contained within user2's interests,
        // and if so, record that
        for (String interest : user1.get_interests()) {
            if (user2Interests.contains(interest)) {
                sharedInterests = sharedInterests + 1;
            }
        }

        // Bump score sum by the proportion of matching interests using a weight of 2
        scoreSum = scoreSum + (2.0 * sharedInterests / interestCount);

        // Add a point for whether the country of both users is equivalent
        if (user1.get_location().get("country") == user2.get_location().get("country")) {
            scoreSum = scoreSum + 1;
        }

        // Add a point for whether there is a liking to the user
        if (user1.get_liked_by_users().contains(user2)) {
            scoreSum = scoreSum + 1;
        }

        // Return the compatibility as a weighted average out of the 4.0 maximum
        return scoreSum / 4.0;
    }

    /**
     * Return a RecommendedProfiles object, given an ordered
     * ArrayList of user profiles to go recommend in that order.
     *
     * @param currentUserObj    The UserAccount for the current user
     * @param newCompList       List of ComparingProfiles to recommend
     */
    private RecommendedProfiles createRecOutput(OldUserAccount currentUserObj, ArrayList<ComparingProfile> newCompList) {

        // Create an ArrayList for all the recommended users
        ArrayList<RecOutProfile> recommendationList = new ArrayList<>();

        // Iterate through each profile
        for (ComparingProfile sortedProfile : newCompList) {

            // Create an output profile for the profile and add it to the ArrayList
            RecOutProfile outProfile = new RecOutProfile(sortedProfile.name);
            recommendationList.add(outProfile);
        }

        // Create the RecommendedProfiles object and return it
        return new RecommendedProfiles(new RecOutProfile(currentUserObj.get_full_name()), recommendationList);
    }
}
