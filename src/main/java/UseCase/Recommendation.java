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

        // Choose random users from the information and create ComparingProfiles tailored
        // to the system's current user, if these profiles do not yet exist; otherwise,
        // update the profile's compatibility score; at the end, put them into a list
        ArrayList<ComparingProfile> compList = new ArrayList<>();
        // TODO the process of going through each profile in filteredUsers,
        //  updating the related ComparingProfile,
        //  and adding the profile to compList

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
