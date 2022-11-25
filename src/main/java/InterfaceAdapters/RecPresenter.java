package InterfaceAdapters;

import UseCase.RecOutputBoundary;
import UseCase.RecommendedProfiles;

public class RecPresenter implements RecOutputBoundary {

    private RecShowRecBoundary showRecBoundary;

    /**
     * Construct a RecPresenter object using the given
     * object which refers to the UI.
     *
     * @param showRecBoundary   The object which builds the UI for this use case
     */
    public RecPresenter(RecShowRecBoundary showRecBoundary){
        this.showRecBoundary = showRecBoundary;
    } // TODO accept the UI to edit

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
