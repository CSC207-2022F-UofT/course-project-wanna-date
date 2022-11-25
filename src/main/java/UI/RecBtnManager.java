package UI;

import FrameworksDrivers.RecDataAccessor;
import InterfaceAdapters.RecController;
import InterfaceAdapters.RecPresenter;
import InterfaceAdapters.RecShowRecBoundary;
import UseCase.RecDataAccessInterface;
import UseCase.RecInputBoundary;
import UseCase.RecOutputBoundary;
import UseCase.Recommendation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RecBtnManager implements RecShowRecBoundary {

    // TODO: this class will be referenced when the Recommendation button of the main screen is clicked, and from
    //  here, the controller ought to be referenced as well; this class will do the startup of the TestRecUC

    /**
     * Construct a RecBtnManager and in doing so, create a new window.
     */
    public RecBtnManager(){

        // --- SET UP CLEAN ARCHITECTURE OF THIS USE CASE
        // Set up the recommendation use case
        // Note: the data access may be deprecated if necessary; it is currently
        // kept inside here in case it's needed for future alterations
        RecOutputBoundary recPresenter = new RecPresenter(this);
        RecDataAccessInterface recDataAccess = new RecDataAccessor();
        RecInputBoundary recUseCase = new Recommendation(recPresenter, recDataAccess);
        ActionListener recController = new RecController(recUseCase);

        // --- SET UP GUI
        // Create a frame and a button for generation of recommendations
        JFrame recommendFrame = new JFrame("User's Profile Page");
        JButton generateBtn = new JButton("Generate Recommendations");

        // Make settings for frame
        recommendFrame.add(generateBtn);
        recommendFrame.setSize(400,400);
        recommendFrame.setLayout(null);
        recommendFrame.setVisible(true);

        // Make settings for button, including the addition of an action listener
        generateBtn.setBounds(0,0,200,30);
        generateBtn.addActionListener(recController);
    }
}
