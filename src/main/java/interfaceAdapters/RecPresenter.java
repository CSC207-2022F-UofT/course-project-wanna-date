package interfaceAdapters;

import useCase.RecOutputBoundary;
import useCase.RecommendedProfiles;

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
    }

    /**
     * Show recommended profiles.
     */
    public void ShowRecommendations(RecommendedProfiles showedProfiles){

        // Enable and show buttons which have recommendations in them
        this.showRecBoundary.showRec(showedProfiles);

        // Change the button to "Re-Generate Recommendations"
        // Optional: negligible/minor change for Milestone 4, all it means is changing the text of the
        // recommendation button
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
