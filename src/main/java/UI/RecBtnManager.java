package UI;

import FrameworksDrivers.RecDataAccessor;
import InterfaceAdapters.RecController;
import InterfaceAdapters.RecPresenter;
import UseCase.RecDataAccessInterface;
import UseCase.RecInputBoundary;
import UseCase.RecOutputBoundary;
import UseCase.Recommendation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RecBtnManager {

    // TODO: this class will be referenced when the Recommendation button of the main screen is clicked, and from
    //  here, the controller ought to be referenced as well; this class will do the startup of the TestRecUC

    public static void main(String[] args) {

        // --- SET UP CLEAN ARCHITECTURE OF THIS USE CASE
        // Set up the recommendation use case
        RecOutputBoundary recPresenter = new RecPresenter();
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
