package interface_adapters.recommendation;

import UI.like.UserLikeBlock;
import use_case.recommendation.RecInputBoundary;
import use_case.recommendation.RecommendedProfiles;

public class RecController {

    public RecInputBoundary useInteractor;
    private RecommendedProfiles recProfiles;

    /**
     * Construct a controller object for the recommendation
     * use case, given a particular use case interactor.
     *
     * @param useInteractor     A recommendation use case interactor
     */
    public RecController(RecInputBoundary useInteractor){
        this.useInteractor = useInteractor;
        this.recProfiles = null;
    }

    /**
     * Handle input when the user wants to generate recommendations.
     * This is a mutating method which will update the controller's
     * stored data.
     */
    public void handleInput(){
        useInteractor.makeRecommendations();
    }

    /**
     * Presuming that there have already been recommendations made,
     * create new objects that would be used to start up the controller
     * for a new object to present.
     *
     * @param index     Index of the RecommendedProfiles' profiles to reference
     */
    public void formLBControl(int index) {

        // Create the UI for the display of profiles by fetching the current user and
        // user to view, and then start the UI
        String userToView = this.recProfiles.getRecUserAcc().get(index);
        UserLikeBlock likeBlockUI = new UserLikeBlock(this.recProfiles.getRecProfileUser(), userToView);
    }

    /**
     * Set the RecommendedProfiles object contained within the controller,
     * for future use in determining which user profile may be clicked.
     *
     * @param recProfiles     A RecommendedProfiles object
     */
    public void setRecProfiles(RecommendedProfiles recProfiles) {
        this.recProfiles = recProfiles;
    }

    //    @Override
//    public void actionPerformed(ActionEvent e) {
//        // Note: this functionality was moved into a UI class for integration
//        // Call on the use case interactor to make recommendations
//        useInteractor.MakeRecommendations();
//    }

}
