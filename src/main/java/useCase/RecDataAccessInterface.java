package useCase;

import entities.ComparingProfile;

import java.util.ArrayList;
import java.util.Set;

public interface RecDataAccessInterface {

    /**
     * Fetch valid users as ComparingProfiles up to a certain maximum limit, where a valid
     * user is any user who satisfies the gender and sexuality requirements given.
     *
     * @param keyGenders        The accepted genders
     * @param keySexes          The accepted sexualities
     * @return A list of valid users
     */
    public default ArrayList<ComparingProfile> getValidUsers(Set<String> keyGenders, Set<String> keySexes) {
        return null;
    }
}
