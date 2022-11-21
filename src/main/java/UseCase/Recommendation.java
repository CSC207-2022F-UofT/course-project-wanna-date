package UseCase;

import Entities.ComparingProfile;

import java.util.ArrayList;
import java.util.HashMap;

public class Recommendation implements RecInputBoundary {

    public RecOutputBoundary outputManager;
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

        // Get a list of user account information which satisfies mutual interests or locations

        // Get information of blocked users

        // Using information of blocked users, take out any users who are blocked; note that
        // this might lead there to being less recommendations

        // Choose random users from the information and create ComparingProfiles tailored
        // to the system's current user, if these profiles do not yet exist; otherwise,
        // update the profile's compatibility score; at the end, put them into a list
        ArrayList<ComparingProfile> CompList = new ArrayList<>();
        // TODO

        // Sort the list of profiles based on compatibility, in decreasing order

        // Create recommended profiles in an object

        // Send recommended profiles to the adapter layer through the output boundary

    }
}
