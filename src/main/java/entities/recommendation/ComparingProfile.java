package entities.recommendation;

public class ComparingProfile implements Comparable<ComparingProfile> {
    private final String name;
    private String interests;
    private String location;
    private String sexuality;
    private double compatibility;

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
    public ComparingProfile(String name, String interests, String location,
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
    public ComparingProfile(String name, String interests, String location, String sexuality) {
        this.name = name;
        this.interests = interests;
        this.location = location;
        this.sexuality = sexuality;
        this.compatibility = 0;
    }

    /**
     * Get name of user.
     *
     * @return      User's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get interests of user.
     * Note this is usually used for documentation/testing and also leaves
     * the program open for extension.
     *
     * @return      User's interest
     */
    public String getInterests() {
        return this.interests;
    }

    /**
     * Get location of user.
     * Note this is usually used for documentation/testing and also leaves
     * the program open for extension.
     *
     * @return      User's location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Get compatibility score.
     *
     * @return      Compared user's compatibility to current user
     */
    public double getCompatibility() {
        return this.compatibility;
    }

    /**
     * Update interests of user with a valid interest.
     * Note this is usually used for documentation/testing and also leaves
     * the program open for extension.
     */
    public void setInterests(String interests) {
        this.interests = interests;
    }

    /**
     * Update location of user.
     * Note this is usually used for documentation/testing and also leaves
     * the program open for extension.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Update sexuality of user with a valid sexuality value.
     * Note this is usually used for documentation/testing and also leaves
     * the program open for extension.
     */
    public void setSexuality(String sexuality) {
        this.sexuality = sexuality;
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
