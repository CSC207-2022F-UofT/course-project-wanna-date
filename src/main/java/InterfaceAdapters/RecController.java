package InterfaceAdapters;

import UseCase.RecInputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecController implements ActionListener {

    RecInputBoundary useInteractor;

    /**
     * Construct a controller object for the recommendation
     * use case, given a particular use case interactor.
     *
     * @param useInteractor     A recommendation use case interactor
     */
    public RecController(RecInputBoundary useInteractor){
        this.useInteractor = useInteractor;
    }

    /**
     * Handle input when the user wants to generate recommendations.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: move this functionality into a UI class for integration later on
        // Call on the use case interactor to make recommendations
        useInteractor.MakeRecommendations();
    }

    /**
     * SYNTAX FOR THE GOING TO ANOTHER USER
     * Create this (In UI folder.ActionListener for a user's profile) object...
     * x = UserLikeBlock(UserAccount user1=current user,
     *               UserAccount user2=user on the list to click,
     *               ControllerLikeBlock control=controller to import from Adeline's code)
     *
     * after that, call x.functionToCall() inside the ActionListener code
     *
     * the general idea is this:
     * Lovina is going to create the code for startup and all, and what's going to happen from the home page is
     * there is a Recommendation button
     * this sends you to the getRecommendations webpage which I created in my TestRecUC, and then this
     * is my area to handle from there
     */
}
