package UI.recommendation;

import UI.account.ViewProfilePage;
import interface_adapters.recommendation.RecController;
import interface_adapters.recommendation.RecPresenter;
import interface_adapters.recommendation.RecShowRecBoundary;
import use_case.recommendation.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
    RecInputBoundary recUseCase = new Recommendation(recPresenter);
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

    JButton back = new JButton("Back");

    // currUser username
    String username;

    // Declare an instance attribute which stores the list of recommendation buttons
    ArrayList<JButton> recBtnList;

    /**
     * Construct a RecBtnManager and in doing so, create a new window.
     */
    public RecBtnManager(String username){
        this.username = username;

        // Make settings for frame
        recommendFrame.add(generateBtn);
        recommendFrame.setSize(600,400);
        recommendFrame.setLayout(null);
        recommendFrame.setVisible(true);

        // Set labels of how the algo works
        JLabel title = new JLabel();
        String text = "Click on the button to get random recommendations of users (5 max). If you have less than 5, then there are less people compatible with you due to you blocking them or not having compatible sexualities.";
        title.setText(text);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(10, 400, 180, 300);
        title.setFont(new Font("Lucida Calligraphy", Font.BOLD, 12));
        title.setFocusable(false);
        recommendFrame.add(title);

        // Make settings for the recommendation button, including the addition of an action listener
        generateBtn.setBounds(0,0,200,30);
        generateBtn.addActionListener(this);

        // Update settings for recommendation buttons
        recBtn1.setBounds(0,50,350,30);
        recBtn2.setBounds(0,100,350,30);
        recBtn3.setBounds(0,150,350,30);
        recBtn4.setBounds(0,200,350,30);
        recBtn5.setBounds(0,250,350,30);

        // Pack the buttons into a list
        ArrayList<JButton> recBtnList = new ArrayList<>();
        recBtnList.add(recBtn1);
        recBtnList.add(recBtn2);
        recBtnList.add(recBtn3);
        recBtnList.add(recBtn4);
        recBtnList.add(recBtn5);
        this.recBtnList = recBtnList;

        // Add buttons to frame, hide and disable buttons, and add action listeners
        for (JButton recBtn : recBtnList) {
            hideDisable(recBtn, false);
            recBtn.addActionListener(this);
            recommendFrame.add(recBtn);
        }

        back.setBounds(30,300,100,30);
        back.addActionListener(this);
        recommendFrame.add(back);
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
        if (actSrc == back) {
            ViewProfilePage viewProfilePage = null;
            try {
                viewProfilePage = new ViewProfilePage(username);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            viewProfilePage.buildPage();
            recommendFrame.dispose();
        } else if (actSrc == generateBtn) {

            // Hide and disable every button for recommendations
            for (JButton recBtn : this.recBtnList) {
                hideDisable(recBtn, false);
            }

            // Call on the controller to handle input
            recController.handleInput();

            // Otherwise, handle for the buttons and recommended profile viewing; entry
            // in this branch implies recommendations have already been shown; this is a precondition
        } else {
            if (actSrc == recBtn1) {
                recController.formLBControl(0);
            } else if (actSrc == recBtn2) {
                recController.formLBControl(1);
            } else if (actSrc == recBtn3) {
                recController.formLBControl(2);
            } else if (actSrc == recBtn4) {
                recController.formLBControl(3);
            } else if (actSrc == recBtn5) {
                recController.formLBControl(4);
            }
            recommendFrame.dispose();
        }

    }

    /**
     * Show recommendations and give some data to the controller.
     *
     * @param suggestedProfiles    A list of profiles to output
     */
    public void showRec(RecommendedProfiles suggestedProfiles){

        // Unpack profiles to show and update the controller
        List<RecOutProfile> profilesToShow = suggestedProfiles.getRecProfileList();
        recController.setRecProfiles(suggestedProfiles);

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
}