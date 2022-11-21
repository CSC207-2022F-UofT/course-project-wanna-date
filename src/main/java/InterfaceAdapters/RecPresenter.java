package InterfaceAdapters;

import UseCase.RecOutputBoundary;
import UseCase.RecommendedProfiles;

public class RecPresenter implements RecOutputBoundary {

    /**
     * Construct a RecPresenter object.
     */
    public RecPresenter(){};

    /**
     * Show recommended profiles.
     */
    public void ShowRecommendations(RecommendedProfiles showedProfiles){
        // TODO
    }

    /**
     * Close the screen displaying recommended profiles.
     */
    public void CloseRecommendations(){
        // Note that this is left unimplemented; the group decided that for Milestone 4, we will leave
        // the issue of the one-window Swing implementation alone and instead, we will see if
        // it is necessary to put everything into one window
    }
}
