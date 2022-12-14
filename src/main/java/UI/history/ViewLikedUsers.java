package UI.history;

import entities.account.UserAccount;
import interface_adapters.history.UserHistoryController;
import use_case.history.GenerateUserHistory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * UI for the liked users page.
 */
public class ViewLikedUsers extends JFrame implements ActionListener {

    // New instance of JFrame
    JFrame frame = new JFrame();

    // Buttons
    JButton backButton = new JButton("Return");
    JButton blockButton = new JButton("Block");
    JButton unlikeButton = new JButton("Unlike");

    JButton statsButton = new JButton("View Stats");

    // Labels
    JLabel likedTitle = new JLabel("LIKED USERS");

    // Statistics Labels
    JLabel totalLikedUsersTitle = new JLabel("Total Number of Liked Users: ");
    JLabel likedAgeTitle = new JLabel("Most Common Age of Liked Users: ");
    JLabel likedCityTitle = new JLabel("Most Common City of Liked Users: ");
    JLabel likedCountryTitle = new JLabel("Most Common Country: ");
    JLabel likedGenderTitle = new JLabel("Most common Gender of Liked Users: ");
    JLabel likedInterestTitle = new JLabel("Most common Interests: ");

    String user1;

    int selectedUserIndex;


    public ViewLikedUsers(String currUsername){

        UserHistoryController userHistoryController = new UserHistoryController();
        ArrayList<String> stats = userHistoryController.callGetUserStats(currUsername);

        this.user1 = currUsername;

        GenerateUserHistory generateHistory = new GenerateUserHistory();

        // Get the UserAccount entity info from the given username and store it
        UserAccount user1Acc = generateHistory.getCurrUserAccount(user1);

        // Get the total number of likes this user has
        String likedAge = stats.get(0);
        String likedCity = stats.get(1);
        String likedCountry = stats.get(2);
        String likedGender = stats.get(3);
        String likedInterest = stats.get(4);
        String totalLikes = stats.get(5);

        JLabel totalLikesUsersNumber = new JLabel(totalLikes);
        JLabel likedAgeNumber = new JLabel(likedAge);
        JLabel likedCityString = new JLabel(likedCity);
        JLabel likedCountryString = new JLabel(likedCountry);
        JLabel likedGenderString = new JLabel(likedGender);
        JLabel likedInterestString = new JLabel(likedInterest);

        // List of users they have liked
        String[] likedUsers = generateHistory.likedUsernames(user1Acc);
        JComboBox<String> likedBox = new JComboBox<>(likedUsers);

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
        frame.add(statsButton);

        // Set size of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410, 550);
        frame.setLayout(null);
        frame.setVisible(true);
        Color LIGHT_PINK = new Color(255, 175, 175, 255);
        frame.getContentPane().setBackground(LIGHT_PINK);

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

        likedAgeTitle.setVisible(false);
        likedCityTitle.setVisible(false);
        likedCountryTitle.setVisible(false);
        likedGenderTitle.setVisible(false);
        likedInterestTitle.setVisible(false);
        likedAgeNumber.setVisible(false);
        likedCityString.setVisible(false);
        likedCountryString.setVisible(false);
        likedGenderString.setVisible(false);
        likedInterestString.setVisible(false);

        // Set the position and size of the buttons
        backButton.setBounds(15,475,370,35);
        backButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // User clicks back button
                new UserHistoryUI(user1);
                frame.dispose();
            }
        });

        blockButton.setBounds(200,130,185,75);
        blockButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        blockButton.setFocusable(false);
        blockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // User clicks Block Button
                user1Acc.getBlockedUsers().add(user1Acc.getLikedUsers().get(selectedUserIndex));
                user1Acc.getLikedUsers().remove(selectedUserIndex);
                new ViewLikedUsers(user1);
                frame.dispose();
            }
        });

        unlikeButton.setBounds(15,130,185,75);
        unlikeButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        unlikeButton.setFocusable(false);
        unlikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // User clicks Unlike Button
                user1Acc.getLikedUsers().remove(selectedUserIndex);
                new ViewLikedUsers(user1);
                frame.dispose();
            }
        });

        statsButton.setBounds(15,250,370,35);
        statsButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        statsButton.setFocusable(false);
        statsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // User clicks Unlike Button
                statsButton.setVisible(false);
                likedAgeTitle.setVisible(true);
                likedCityTitle.setVisible(true);
                likedCountryTitle.setVisible(true);
                likedGenderTitle.setVisible(true);
                likedInterestTitle.setVisible(true);
                likedAgeNumber.setVisible(true);
                likedCityString.setVisible(true);
                likedCountryString.setVisible(true);
                likedGenderString.setVisible(true);
                likedInterestString.setVisible(true);
            }
        });

        // Set the position and size of box
        likedBox.setBounds(10, 80, 385, 30);
        likedBox.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        likedBox.setVisible(true);
        likedBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // User clicks Liked users drop down box
                JComboBox cb = (JComboBox)e.getSource();
                cb.getSelectedIndex();
                selectedUserIndex = cb.getSelectedIndex();
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public static void main(String[] args) {
        new ViewLikedUsers("lov789");
    }
}
