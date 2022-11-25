package InterfaceAdapters;

import UseCase.RecInputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecController {

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
    public void handleInput(){
        useInteractor.MakeRecommendations();
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // Note: this functionality was moved into a UI class for integration
//        // Call on the use case interactor to make recommendations
//        useInteractor.MakeRecommendations();
//    }

}
