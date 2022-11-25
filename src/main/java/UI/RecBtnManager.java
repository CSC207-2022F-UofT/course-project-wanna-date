package UI;

import FrameworksDrivers.RecDataAccessor;
import InterfaceAdapters.ControllerLikeBlock;
import InterfaceAdapters.RecController;
import InterfaceAdapters.RecPresenter;
import InterfaceAdapters.RecShowRecBoundary;
import UseCase.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RecBtnManager implements RecShowRecBoundary, ActionListener {

    // This class will be referenced when the Recommendation button of the main screen is clicked, and from
    //  here, the controller ought to be referenced as well; this class will do the startup of the TestRecUC

    // Here, we create a new window
    // --- SET UP CLEAN ARCHITECTURE OF THIS USE CASE
    // Set up the recommendation use case
    // Note: the data access may be deprecated if necessary; it is currently
    // kept inside here in case it's needed for future alterations
    RecOutputBoundary recPresenter = new RecPresenter(this);
    RecDataAccessInterface recDataAccess = new RecDataAccessor();
    RecInputBoundary recUseCase = new Recommendation(recPresenter, recDataAccess);
    RecController recController = new RecController(recUseCase);

    // --- SET UP GUI
    // Create a frame and a button for generation of recommendations
    JFrame recommendFrame = new JFrame("User's Profile Page");
    JButton generateBtn = new JButton("Generate Recommendations");

    // Create buttons for at most 5 recommendations
    JButton recBtn1 = new JButton("");
    JButton recBtn2 = new JButton("");
    JButton recBtn3 = new JButton("");
    JButton recBtn4 = new JButton("");
    JButton recBtn5 = new JButton("");


    // Declare an instance attribute which stores the list of recommendation buttons
    ArrayList<JButton> recBtnList;

    /**
     * Construct a RecBtnManager and in doing so, create a new window.
     */
    public RecBtnManager(){

        // Make settings for frame
        recommendFrame.add(generateBtn);
        recommendFrame.setSize(400,400);
        recommendFrame.setLayout(null);
        recommendFrame.setVisible(true);

        // Make settings for the recommendation button, including the addition of an action listener
        generateBtn.setBounds(0,0,200,30);
        generateBtn.addActionListener(this);

        // Update settings for recommendation buttons
        recBtn1.setBounds(50,0,350,30);
        recBtn2.setBounds(100,0,350,30);
        recBtn3.setBounds(150,0,350,30);
        recBtn4.setBounds(200,0,350,30);
        recBtn5.setBounds(250,0,350,30);

        // Pack the buttons into a list
        ArrayList<JButton> recBtnList = new ArrayList<>();
        recBtnList.add(recBtn1);
        recBtnList.add(recBtn2);
        recBtnList.add(recBtn3);
        recBtnList.add(recBtn4);
        recBtnList.add(recBtn5);
        this.recBtnList = recBtnList;

        // Hide and disable buttons
        for (JButton recBtn : recBtnList) {
            hideDisable(recBtn, false);
        }

        // TODO VALIDATE AND REPAINT AT THE END, and do anything else here?
    }

    /**
     * Toggle enabled and visibility of the given
     * button using the given status.
     *
     * @param recBtn    The button to change
     * @param status    Boolean to switch statuses to
     */
    private void hideDisable(JButton recBtn, boolean status) {
        recBtn.setEnabled(status);
        recBtn.setVisible(status);
    }

    /**
     * Handle input when the user wants to generate recommendations.
     */
    @Override
    public void actionPerformed(ActionEvent pressEvent) {

        // Get the event's source
        Object actSrc = pressEvent.getSource();

        // If the source of the action is pressing the recommendation button, generate recommendations
        if (actSrc == generateBtn) {

            // Hide and disable every button for recommendations
            for (JButton recBtn : this.recBtnList) {
                hideDisable(recBtn, false);
            }

            // Call on the controller to handle input
            recController.handleInput();

        // Otherwise, handle for the buttons and recommended profile viewing
        } else {

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

            // Create a controller for liking and blocking
            ControllerLikeBlock likeBlockControl = new ControllerLikeBlock();

            // Create a UserLikeBlock object
            UserLikeBlock profileDisplayer = new UserLikeBlock(x1, x2, likeBlockControl);

            if (actSrc == recBtn1) {
                profileDisplayer.functionToCall();
            } else if (actSrc == recBtn2) {

            } else if (actSrc == recBtn3) {

            } else if (actSrc == recBtn4) {

            } else if (actSrc == recBtn5) {

            }
        }

    }

    /**
     * Show recommendations.
     *
     * @param profilesToShow    A list of profiles to output
     */
    public void showRec(List<RecOutProfile> profilesToShow){

        // Go through each profile using an index
        for (int i = 0; i <= profilesToShow.size() - 1; i++) {

            // Update the corresponding button to connect to the recommended profile
            JButton rightBtn = this.recBtnList.get(i);
            rightBtn.setText("Profile: " + profilesToShow.get(i).name);

            // Enable and show the recommendation
            hideDisable(rightBtn, true);
        }

        // Lastly, validate and repaint
        recommendFrame.validate();
        recommendFrame.repaint();
    }

    /**
     * Do general set-up.
     */
    public static void main(String[] args) {
        new RecBtnManager();
    }
}
