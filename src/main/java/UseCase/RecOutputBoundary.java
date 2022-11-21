package UseCase;

public interface RecOutputBoundary {
    /**
     * Show recommended profiles.
     */
    public default void ShowRecommendations(RecommendedProfiles showedProfiles){}
}
