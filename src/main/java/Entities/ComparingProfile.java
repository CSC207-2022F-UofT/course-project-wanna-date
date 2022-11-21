package Entities;

import java.util.List;

public class ComparingProfile {
    public String name;
    public List<String> interests;
    public String location;
    public String sexuality;
    public double compatibility;

    /**
     * Construct a ComparingProfile, giving it the given
     * profile parameters if they are provided.
     *
     * @param name              Compared user's name
     * @param interests         Compared user's interests
     * @param location          Compared user's location
     * @param sexuality         Compared user's sexuality
     * @param compatibility     Compared user's compatibility to current user
     */
    public ComparingProfile(String name, List<String> interests, String location,
                            String sexuality, double compatibility) {
        this.name = name;
        this.interests = interests;
        this.location = location;
        this.sexuality = sexuality;
        this.compatibility = compatibility;
    }

    /**
     * Construct a ComparingProfile, giving it the given
     * profile parameters if compatibility is not provided.
     *
     * @param name              Compared user's name
     * @param interests         Compared user's interests
     * @param location          Compared user's location
     * @param sexuality         Compared user's sexuality
     */
    public ComparingProfile(String name, List<String> interests, String location, String sexuality) {
        this.name = name;
        this.interests = interests;
        this.location = location;
        this.sexuality = sexuality;
        this.compatibility = 0;
    }

    /**
     * Get compatibility score.
     *
     * @return      Compared user's compatibility to current user
     */
    public double getCompatibility() {
        return compatibility;
    }

    /**
     * Update compatibility score.
     *
     * @param compatibility     Compared user's compatibility to current user
     */
    public void setCompatibility(double compatibility) {
        this.compatibility = compatibility;
    }
}
