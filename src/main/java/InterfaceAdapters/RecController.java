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

        // Call on the use case interactor to make recommendations
        useInteractor.MakeRecommendations();
    }
}
