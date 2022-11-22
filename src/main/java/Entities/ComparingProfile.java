package Entities;

import java.util.List;

public class ComparingProfile implements Comparable<ComparingProfile> {
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

    /**
     * Define how ComparingProfiles ought to be compared.
     *
     * @param profile       The profile to compare to
     */
    @Override
    public int compareTo(ComparingProfile profile) {

        // If this profile has higher compatibility, then make this profile lesser
        // If profiles have the same compatibility, then make them equal
        // If this profile has less compatibility, then make this profile greater
        if (this.getCompatibility() > profile.getCompatibility()) {
            return -1;
        } else if (this.getCompatibility() == profile.getCompatibility()) {
            return 0;
        } else {
            return 1;
        }
    }
}
