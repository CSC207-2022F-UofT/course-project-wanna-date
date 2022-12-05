package UI;
import entities.UserAccount;
import frameworksDrivers.DataAccess;
import interfaceAdapters.ControllerLikeBlock;
import interfaceAdapters.ViewProfileController;
import useCase.DatabaseManager;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserLikeBlock implements ActionListener {
    //user giving the like or block
    String username1;
    //user being view
    String username2;
    ControllerLikeBlock controller;
    //Initiate buttons, frame and label
    JFrame profile = new JFrame();
    JLabel title = new JLabel("Aphrodite");
    JLabel pageTitle = new JLabel("User Profile");

    JLabel fullName = new JLabel("Full Name: ");
    JLabel age = new JLabel();
    JLabel pronoun = new JLabel();
    JLabel country = new JLabel();
    JLabel province = new JLabel();
    JLabel city = new JLabel();
    JLabel gender = new JLabel();
    JLabel sexuality = new JLabel();
    JLabel interests = new JLabel();

    JButton like = new JButton("Like♥");
    JButton block = new JButton("Block");

    JLabel likedString = new JLabel();
    JLabel blockedString = new JLabel();



    public UserLikeBlock(String username1, String username2){
        /* Create new frame to view user after we click on user from recommendation or search. This class is
         * the User Interface class. When like button is clicked a String "Liked" will appear on the frame to
         * indicate the action. Similarly, for block button, String "Blocked" will appear on the frame.
         */
        //Initiate the variables so that we can use it for the actionPerformed function
        ViewProfileController view1 = new ViewProfileController(); //create ViewProfileController to get UserAcc obj
        this.username1= username1;
        this.username2= username2;
        UserAccount user1 = view1.callSearchUser(username1);
        UserAccount user2 = view1.callSearchUser(username2);
        this.controller = new ControllerLikeBlock();

        //Create frame
        profile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //THE CLOSE BUTTON
        profile.setSize(800, 800); //size of the frame
        profile.setLayout(null); //customize where u want everything to go
        profile.setVisible(true); //make the frame visible

        title.setBounds(30, 40, 100, 100);
        title.setFont(new Font(null, Font.BOLD, 18));
        title.setVisible(true);

        pageTitle.setBounds(310, 80, 100, 100);
        pageTitle.setFont(new Font("Arial", Font.BOLD, 16));
        title.setVisible(true);

        //create full name text and set text to include the user's full name
        fullName.setBounds(20,150, 300, 100); //coordinate and size of the label
        fullName.setFont(new Font(null, Font.PLAIN, 14));
        fullName.setText("Full Name: " + user2.getFullName());
        fullName.setFocusable(false);
        fullName.setVisible(true);

        //create age text and set text to include the user's age
        age.setBounds(20,200, 300, 100); //coordinate and size of the label
        age.setFont(new Font(null, Font.PLAIN, 14));
        age.setText("Age: " + user2.getAge());
        age.setVisible(true);

        //create pronoun text
        pronoun.setBounds(20,250, 300, 100); //coordinate and size of the label
        pronoun.setFont(new Font(null, Font.PLAIN, 14));
        pronoun.setText("Pronouns: " + user2.getPronouns());
        pronoun.setVisible(true);

        //create country text
        country.setBounds(20,300, 400, 100); //coordinate and size of the label
        country.setFont(new Font(null, Font.PLAIN, 14));
        country.setText("Country of Origin: " + user2.getLocation().get("country"));
        country.setVisible(true);

        //create province text
        province.setBounds(20,350, 300, 100); //coordinate and size of the label
        province.setFont(new Font(null, Font.PLAIN, 14));
        province.setText("Province: " + user2.getLocation().get("province"));
        province.setVisible(true);

        //create city text
        city.setBounds(20,400, 300, 100); //coordinate and size of the label
        city.setFont(new Font(null, Font.PLAIN, 14));
        city.setText("City: " + user2.getLocation().get("city"));
        city.setVisible(true);

        //create gender text
        gender.setBounds(20,450, 300, 100); //coordinate and size of the label
        gender.setFont(new Font(null, Font.PLAIN, 14));
        gender.setText("Gender: " + user2.getGender());
        gender.setVisible(true);

        //create sexuality text
        sexuality.setBounds(20,500, 300, 100); //coordinate and size of the label
        sexuality.setFont(new Font(null, Font.PLAIN, 14));
        sexuality.setText("Sexuality: " + user2.getSexuality());
        sexuality.setVisible(true);

        //create interests text
        interests.setBounds(20,550, 700, 100); //coordinate and size of the label
        interests.setFont(new Font(null, Font.PLAIN, 14));
        interests.setText("Interest: " + user2.getInterest());
        interests.setVisible(true);

        //create like button
        like.setBounds(100,700, 60, 40); //coordinate and size of the label
        like.setFocusable(false);
        like.addActionListener(this);
        like.setBackground(Color.red);
        like.setOpaque(true);

        //create block button
        block.setBounds(500,700, 60, 40); //coordinate and size of the label
        block.setFocusable(false);
        block.addActionListener(this);
        block.setBackground(Color.black);
        block.setOpaque(true);

        //create string that will appear after we finish with the like backend work
        likedString.setBounds(600,130, 100, 100); //coordinate and size of the label
        likedString.setFont(new Font("Arial", Font.ITALIC, 14));
        likedString.setForeground(Color.pink);
        likedString.setVisible(false);

        //create string that will appear after we finish with the block backend work
        blockedString.setBounds(600,150, 100, 100); //coordinate and size of the label
        blockedString.setFont(new Font("Arial", Font.ITALIC, 14));
        blockedString.setForeground(Color.red);
        blockedString.setVisible(false);

        //Add everything to the frame
        profile.add(title);
        profile.add(pageTitle);
        profile.add(fullName);
        profile.add(age);
        profile.add(pronoun);
        profile.add(country);
        profile.add(province);
        profile.add(city);
        profile.add(gender);
        profile.add(sexuality);
        profile.add(interests);
        profile.repaint();

        profile.add(block);
        profile.add(like);

        profile.add(blockedString);
        profile.add(likedString);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // if like button get clicked
        if (e.getSource()== like) {
            String textShow= controller.likeController(username1, username2);
            likedString.setText(textShow + "!");
            likedString.setVisible(true);
        }
        //if blocked button get clicked
        else if (e.getSource()==block) {
            String textShow2= controller.blockController(username1, username2);
            blockedString.setText(textShow2+ "!");
            blockedString.setVisible(true);
        }
    }

    public void functionToCall(){
        new UserLikeBlock(username1, username2);
    }

    public static void main (String[] args) {

        UserAccount user1 = new UserAccount("AL", "AML", 20, "her", "CAN",
                "ON", "TOR", "F", "H","Watching", "12356435");
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();
        DatabaseManager data = DatabaseManager.getDatabaseManager();
        data.saveNewUser(user1.getUsername(), user1);
        UserAccount user2 = new UserAccount("JSmith", "Jessica Smith", 20, "her", "CAN",
                "ON", "TOR", "F", "H","Music", "124564565");
        data.saveNewUser(user2.getUsername(), user2);
        new UserLikeBlock(user1.getUsername(), user2.getUsername());

    }
}