// by Arist Alfred Bravo
// note that this code is interim code; it is meant to model how the CLEAN architecture ought to be created
// outside of the CLEAN classes before other aspects are set up; this is a temporary set-up

package tutorial;

import InterfaceAdapters.RecController;
import InterfaceAdapters.RecPresenter;
import UseCase.RecInputBoundary;
import UseCase.RecOutputBoundary;
import UseCase.Recommendation;

import java.awt.event.*;
import javax.swing.*;

public class TestRecUC {

    // tutorial taken from https://www.javatpoint.com/java-swing
    // https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html

    public static void main(String[] args) {


        // --- SET UP CLEAN ARCHITECTURE
        // Set up the recommendation use case
        RecOutputBoundary recPresenter = new RecPresenter();
        RecInputBoundary recUseCase = new Recommendation(recPresenter);
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

    // Note: the code below was the former body of this class definition. It is kept here as a reference in
    // case it is necessary.
    //    public static void main(String[] args) {
    //        for (int i = 1; i <= 100; i++) {
    //            System.out.println(convert(i));
    //        }
    //    }
    //
    //    public static String convert(int decide) {
    //        if (decide % 15 == 0) {
    //            return "tutorial.HelloWorld";
    //        }
    //        if (decide % 3 == 0) {
    //            return "Hello";
    //        }
    //        if (decide % 5 == 0) {
    //            return "World";
    //        }
    //        return String.valueOf(decide);
    //    }
}
