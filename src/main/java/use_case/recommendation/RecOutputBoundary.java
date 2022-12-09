package use_case.recommendation;

public interface RecOutputBoundary {
    /**
     * Show recommended profiles.
     */
    default void showRecommendations(RecommendedProfiles showedProfiles){}
}
