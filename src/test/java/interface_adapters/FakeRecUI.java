package interface_adapters;

import interfaceAdapters.RecShowRecBoundary;
import useCase.*;

public class FakeRecUI implements RecShowRecBoundary {

    /**
     * Show recommendations and give some data to the controller.
     *
     * @param suggestedProfiles    A list of profiles to output
     */
    public void showRec(RecommendedProfiles suggestedProfiles){}
}
