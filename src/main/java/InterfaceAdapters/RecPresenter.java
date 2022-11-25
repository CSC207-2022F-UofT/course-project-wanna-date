package InterfaceAdapters;

import UseCase.RecOutputBoundary;
import UseCase.RecommendedProfiles;

public class RecPresenter implements RecOutputBoundary {

    /**
     * Construct a RecPresenter object.
     */
    public RecPresenter(){}; // TODO accept the UI to edit

    /**
     * Show recommended profiles.
     */
    public void ShowRecommendations(RecommendedProfiles showedProfiles){
        // TODO: to be done with integration relative to the output buttons later on

        // Change the button to "Re-Generate Recommendations"

        // Take the profiles and create buttons that link to profile pages

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
