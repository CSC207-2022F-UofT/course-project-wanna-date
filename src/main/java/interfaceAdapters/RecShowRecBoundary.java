package interfaceAdapters;

import useCase.RecommendedProfiles;

public interface RecShowRecBoundary {

    /**
     * Show recommendations and give some data to the controller.
     *
     * @param suggestedProfiles A list of profiles to output
     */
    public default void showRec(RecommendedProfiles suggestedProfiles) {}
}