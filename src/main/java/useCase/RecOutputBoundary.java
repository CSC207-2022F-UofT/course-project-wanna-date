package useCase;

public interface RecOutputBoundary {
    /**
     * Show recommended profiles.
     */
    default void showRecommendations(RecommendedProfiles showedProfiles){}
}
