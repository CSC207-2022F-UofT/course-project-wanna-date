package use_case.recommendation;

import entities.ComparingProfile;
import entities.UserAccount;

import java.util.ArrayList;
import java.util.Objects;

public class RecOutputBuilder1 implements RecOutputBuilder {

    /**
     * Construct a concrete implementation of RecOutputBuilder.
     */
    public RecOutputBuilder1(){}

    /**
     * Construct the output data to the presenter.
     *
     * @param currentUser   The current user
     * @param finalUsers    A list of users to be recommended
     * @param compList      A corresponding list of ComparingProfiles
     */
    public RecommendedProfiles constructRecOutput(UserAccount currentUser, ArrayList<UserAccount> finalUsers,
                                                  ArrayList<ComparingProfile> compList){

        // Get a list of sorted final users where the users are strings
        ArrayList<String> sortedFinalUsers = getSortedFinalUsers(finalUsers, compList);

        // Create recommended profiles in an object and return it
        return createRecOutput(currentUser, compList, sortedFinalUsers);
    }

    /**
     * Return a string of sorted final users' list which is parallel to a list of ComparingProfiles,
     * given a list of users and their related ComparingProfiles.
     *
     * @param finalUsers    A list of users determined to be for the current user
     * @param compList      A list of ComparingProfiles for recommended users
     */
    private static ArrayList<String> getSortedFinalUsers(ArrayList<UserAccount> finalUsers,
                                                         ArrayList<ComparingProfile> compList) {

        // Create a sorted final users' list which is parallel to compList, by going through each ComparingProfile
        ArrayList<String> sortedFinalUsers = new ArrayList<>();

        // Go through each ComparingProfile to gradually create the sorted final users' list
        for (ComparingProfile compProfile : compList) {

            // For each user in finalUsers: if the usernames match, then we found the user, and add the
            // UserAccount to the sortedFinalUsers
            for (UserAccount maybeUser : finalUsers) {
                if (Objects.equals(compProfile.getName(), maybeUser.getUsername())) {
                    sortedFinalUsers.add(maybeUser.getUsername());
                }
            }
        }
        return sortedFinalUsers;
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
