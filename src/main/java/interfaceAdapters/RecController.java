package interfaceAdapters;

import UI.UserLikeBlock;
import useCase.RecInputBoundary;
import useCase.RecommendedProfiles;

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
        useInteractor.MakeRecommendations();
    }

    /**
     * Presuming that there have already been recommendations made,
     * create new objects that would be used to start up the controller
     * for a new object to present.
     *
     * @param index     Index of the RecommendedProfiles' profiles to reference
     */
    public void formLBControl(int index) {

        // Create a controller for liking and blocking
        ControllerLikeBlock likeBlockControl = new ControllerLikeBlock();

        // Create a UserLikeBlock object at the current user and picked user by index
        UserLikeBlock profileDisplayer = new UserLikeBlock(this.recProfiles.recProfileUser,
                this.recProfiles.getRecUserAcc().get(index), likeBlockControl);

        // Call the profile displayer so that the new controller's operations can run altogether
        profileDisplayer.functionToCall();
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
