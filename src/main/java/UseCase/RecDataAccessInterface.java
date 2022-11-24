package UseCase;

import Entities.ComparingProfile;

import java.util.ArrayList;

public interface RecDataAccessInterface {

    /**
     * Fetch valid users as ComparingProfiles up to a certain maximum limit, where a valid
     * user is any user who satisfies the gender and sexuality requirements given.
     *
     * @param keyGender The accepted gender
     * @param keySex    The accepted sex
     * @return A list of valid users
     */
    public default ArrayList<ComparingProfile> getValidUsers(String keyGender, String keySex) {
        return null;
    }
}
