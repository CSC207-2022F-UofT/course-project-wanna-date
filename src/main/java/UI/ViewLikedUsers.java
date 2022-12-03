package UI;

import entities.UserAccount;
import interfaceAdapters.UserHistoryController;
import useCase.GenerateUserHistory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * UI for the liked users page.
 */
public class ViewLikedUsers extends JFrame implements ActionListener {

    GenerateUserHistory generateHistory = new GenerateUserHistory();

    // New instance of JFrame
    JFrame frame = new JFrame();

    // Buttons
    JButton backButton = new JButton("Return ⏎");
    JButton blockButton = new JButton("Block ✖");
    JButton unlikeButton = new JButton("Unlike ☹");

    // Labels
    JLabel likedTitle = new JLabel("LIKED USERS");

    // Statistics Labels
    JLabel totalLikedUsersTitle = new JLabel("Total Number of Liked Users: ");
    JLabel likedAgeTitle = new JLabel("Most Common Age of Liked Users: ");
    JLabel likedCityTitle = new JLabel("Most Common City of Liked Users: ");
    JLabel likedCountryTitle = new JLabel("Most Common Country: ");
    JLabel likedGenderTitle = new JLabel("Most common Gender of Liked Users: ");
    JLabel likedInterestTitle = new JLabel("Most common Interests: ");
    JLabel totalLikesUsersNumber = new JLabel(totalLikes);
    JLabel likedAgeNumber = new JLabel(likedAge);
    JLabel likedCityString = new JLabel(likedCity);
    JLabel likedCountryString = new JLabel(likedCountry);
    JLabel likedGenderString = new JLabel(likedGender);
    JLabel likedInterestString = new JLabel(likedInterest);

    // List of users they have liked
    String[] likedUsers = generateHistory.likedUsernames(user1);
    JComboBox<String> likedBox = new JComboBox<>(likedUsers);

    UserAccount user1;
    UserHistoryController controller;


    public ViewLikedUsers(UserAccount currUser, UserHistoryController controller){

        //Initiate the variables so that we can use it for the actionPerformed function
        this.user1 = currUser;
        this.controller = controller;

        // Add frames
        frame.add(likedTitle);
        frame.add(backButton);
        frame.add(likedBox);
        frame.add(blockButton);
        frame.add(unlikeButton);
        frame.add(totalLikedUsersTitle);
        frame.add(likedAgeTitle);
        frame.add(likedCityTitle);
        frame.add(likedCountryTitle);
        frame.add(likedGenderTitle);
        frame.add(likedInterestTitle);
        frame.add(totalLikesUsersNumber);
        frame.add(likedAgeNumber);
        frame.add(likedCityString);
        frame.add(likedCountryString);
        frame.add(likedGenderString);
        frame.add(likedInterestString);

        // Set size of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);
        frame.setVisible(true);

        // Set the position and size of the labels
        likedTitle.setBounds(30,15,500,50);
        likedTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));

        totalLikedUsersTitle.setBounds(20, 210, 500, 50);
        totalLikedUsersTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));

        likedAgeTitle.setBounds(20, 250, 500, 50);
        likedAgeTitle.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));

        likedCityTitle.setBounds(20, 290, 500, 50);
        likedCityTitle.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));

        likedCountryTitle.setBounds(20, 330, 500, 50);
        likedCountryTitle.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));

        likedGenderTitle.setBounds(20, 370, 500, 50);
        likedGenderTitle.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));

        likedInterestTitle.setBounds(20, 410, 500, 50);
        likedInterestTitle.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));

        totalLikesUsersNumber.setBounds(300, 210, 500, 50);
        totalLikesUsersNumber.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));

        likedAgeNumber.setBounds(320, 250, 500, 50);
        likedAgeNumber.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));

        likedCityString.setBounds(320, 290, 500, 50);
        likedCityString.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

        likedCountryString.setBounds(210, 330, 500, 50);
        likedCountryString.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

        likedGenderString.setBounds(350, 370, 500, 50);
        likedGenderString.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

        likedInterestString.setBounds(230, 410, 500, 50);
        likedInterestString.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

        // Set the position and size of the buttons
        backButton.setBounds(15,475,370,35);
        backButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        blockButton.setBounds(205,130,190,75);
        blockButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        blockButton.setFocusable(false);
        blockButton.addActionListener(this);

        unlikeButton.setBounds(15,130,190,75);
        unlikeButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        unlikeButton.setFocusable(false);
        unlikeButton.addActionListener(this);

        // Set the position and size of box
        likedBox.setBounds(10, 80, 385, 30);
        likedBox.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        likedBox.setVisible(true);
        likedBox.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // Get the user's selection from the dropdown box (combobox)
        Object selection = likedBox.getSelectedItem();

        // User clicks Back button
        if(e.getSource() == backButton){
            new UserHistoryUI();
            frame.dispose();
        }
        // User clicks Unlike Button
        else if(e.getSource() == unlikeButton){
            new ViewLikedUsers(user1, controller);
            frame.dispose();
        }
        // User clicks Block Button
        else if(e.getSource() == blockButton){
            new ViewLikedUsers(user1, controller);
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        UserAccount user1 = new UserAccount("johnd", "John Doe", 20, "her", "USA",
                "ILL", "CHI", "M", "H","Watching", "123");

        UserHistoryController control = new UserHistoryController();
        new ViewLikedUsers(user1, control);
    }
}
