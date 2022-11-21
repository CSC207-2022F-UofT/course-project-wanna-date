package UseCase;

import Entities.ComparingProfile;
import Entities.UserAccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Recommendation implements RecInputBoundary {

    private RecOutputBoundary outputManager;
    private HashMap<String, ComparingProfile> nameToComp;

    /**
     * Construct a Recommendation use case object with
     * the given output boundary object.
     *
     * @param outputManager     An output boundary, usually a presenter
     */
    public Recommendation(RecOutputBoundary outputManager){
        this.outputManager = outputManager;
        this.nameToComp = new HashMap<>();
    }

    /**
     * Make recommendations with information already stored
     * in the program, calling an OutputBoundary object
     * to do such processing.
     */
    public void MakeRecommendations(){
        // TODO

        // Get the current user of the program
        UserAccount currentUser = this.getCurrentUser();
        String currentUsername = currentUser.get_username();

        // Get a list of user account information which satisfies mutual interests or locations
        ArrayList<UserAccount> possibleUsers = this.getPossibleMatches();

        // Get information of blocked users
        ArrayList<UserAccount> blockedUsers = new ArrayList<>(); // TODO update

        // Using information of blocked users, take out any users who are blocked; note that
        // this might lead there to being less recommendations
        ArrayList<UserAccount> filteredUsers = this.takeOutBlocked(currentUsername, possibleUsers);

        // In this next part, choose random users from the information and create ComparingProfiles tailored
        // to the system's current user, if these profiles do not yet exist; otherwise,
        // update the profile's compatibility score; at the end, put them into a list

        // Start by randomly excluding users from the filtered users
        this.popRandomUsers(filteredUsers);

        // Create a list to store the finalized ComparingProfiles
        ArrayList<ComparingProfile> compList = new ArrayList<>();

        // Go through each profile
        for (UserAccount chosenUser : filteredUsers) {

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
        RecommendedProfiles profilesToShow = createRecOutput(compList);

        // Send recommended profiles to the adapter layer through the output boundary
        this.outputManager.ShowRecommendations(profilesToShow);
    }

    /**
     * Get current user which is logged in.
     * This presumes that there is already a current user to get.
     */
    private UserAccount getCurrentUser(){
        return new UserAccount(); // TODO update
    }

    /**
     * Get a list of possible matches based on
     * mutual interests and locations for the current user.
     */
    private ArrayList<UserAccount> getPossibleMatches(){
        ArrayList<UserAccount> potentialUsers = new ArrayList<>();
        return potentialUsers; // TODO update
    }

    /**
     * Return a list of UserAccounts without the users blocked by
     * the current user, given the current user's username
     * and a list of UserAccounts to filter through.
     */
    private ArrayList<UserAccount> takeOutBlocked(String username, ArrayList<UserAccount> oldPossibleUsers) {
        return oldPossibleUsers; // TODO update
    }

    /**
     * Randomly take out users from the inputted list, up until the limit is reached and we have
     * 5 users or less to recommend.
     * Note that this does not yet handle a case where the inputted list is empty.
     *
     * @param popList       An ArrayList of UserAccounts to mutate
     */
    private void popRandomUsers(ArrayList<UserAccount> popList) {
        // TODO
    }

    /**
     * Given 2 user accounts, return their compatibility score.
     *
     * @param user1         First UserAccount
     * @param user2         Second UserAccount
     */
    private double computeCompatibility(UserAccount user1, UserAccount user2) {
        return 0.0; // TODO
    }

    /**
     * Return a RecommendedProfiles object, given an ordered
     * ArrayList of user profiles to go recommend in that order.
     *
     * @param newCompList   List of ComparingProfiles to recommend
     */
    private RecommendedProfiles createRecOutput(ArrayList<ComparingProfile> newCompList) {
        RecommendedProfiles recProfileObj = new RecommendedProfiles(); // TODO finish method
        return recProfileObj;
    }
}
