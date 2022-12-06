package useCase;

public interface RecOutputBoundary {
    /**
     * Show recommended profiles.
     */
    public default void showRecommendations(RecommendedProfiles showedProfiles){}
}
