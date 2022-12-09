package use_case.recommendation;

import entities.recommendation.ComparingProfile;

public class CompProfileFactory {

    /**
     * This is a factory class to create ComparingProfiles.
     */
    public CompProfileFactory(){}

    /**
     * Construct a ComparingProfile with the given inputs.
     *
     * @param username      Valid username
     * @param interest      Valid interest
     * @param country       Country
     * @param sexuality     Valid sexuality
     * @param score         Valid compatibility score
     */
    public ComparingProfile makeCompProfile(String username, String interest, String country,
                                            String sexuality, double score){
        return new ComparingProfile(username,
                interest, country, sexuality, score);
    }
}
