package use_case.recommendation;

public interface RecInputBoundary {

    /**
     * Make recommendations with information already stored
     * in the program, calling an OutputBoundary object
     * to do such processing.
     */
    default RecommendedProfiles makeRecommendations(){
        return null;
    };
}
