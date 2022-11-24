package FrameworksDrivers;

import Entities.ComparingProfile;
import UseCase.RecDataAccessInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecDataAccessor implements RecDataAccessInterface {

    /**
     * Construct a data access object to get and
     * manipulate user accounts from the database.
     */
    public RecDataAccessor() {
    }

    /**
     * Fetch valid users as ComparingProfiles up to a certain maximum limit of
     * attempted fetches. Here, we define a valid
     * user as any user who satisfies the gender and sexuality requirements given.
     * Also take in a mapping from username to ComparingProfile to mutate with
     * new ComparingProfiles if needed.
     *
     *
     * @param keyGender     The accepted gender
     * @param keySex        The accepted sex
     *
     * @return              A list of valid users
     */
    public ArrayList<ComparingProfile> getValidUsers(String keyGender, String keySex, HashMap<>){

        // --- Get the database and do initial set-up

        // Define an ArrayList to contain the valid users
        ArrayList<ComparingProfile> validUsers = new ArrayList<>();

        // TODO

        // --- Read the database to get valid users up to a certain maximum

        // --- Close the database and do other closing functionality
        // TODO
        return validUsers;
    }
}
