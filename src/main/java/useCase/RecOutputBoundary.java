package useCase;

public interface RecOutputBoundary {
    /**
     * Show recommended profiles.
     */
    public default void ShowRecommendations(RecommendedProfiles showedProfiles){}
}
