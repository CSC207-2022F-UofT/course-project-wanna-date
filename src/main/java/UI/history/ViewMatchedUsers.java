package UI.history;

import entities.UserAccount;
import interface_adapters.UserHistoryController;
import use_case.GenerateUserHistory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * UI for the matched users page.
 */
public class ViewMatchedUsers extends JFrame implements ActionListener {

    // New instance of JFrame
    JFrame frame = new JFrame();

    // Buttons
    JButton backButton = new JButton("Return" );
    JButton blockButton = new JButton("Block");
    JButton unlikeButton = new JButton("Unlike");

    // Labels
    JLabel matchedTitle = new JLabel("MATCHED USERS");

    // Statistics labels
    JLabel totalMatchedUsersTitle = new JLabel("Total Number of Matched Users: ");

    String user1;

    int selectedUserIndex;


    public ViewMatchedUsers(String currUsername){

        UserHistoryController userHistoryController = new UserHistoryController();
        ArrayList<String> stats = userHistoryController.callGetUserStats(currUsername);

        this.user1 = currUsername;

        GenerateUserHistory generateHistory = new GenerateUserHistory();

        // Get the UserAccount entity info from the given username and store it
        UserAccount user1Acc = generateHistory.getCurrUserAccount(user1);

        // Get the total number of matches this user has
        String totalMatched = stats.get(7);
        JLabel totalMatchedUsersNumber = new JLabel(totalMatched);

        // List of users they have matched with
        String[] matchedUsers = generateHistory.matchedUsernames(user1Acc);
        JComboBox<String> matchedBox = new JComboBox<>(matchedUsers);

        // Add frames
        frame.add(matchedTitle);
        frame.add(backButton);
        frame.add(matchedBox);
        frame.add(blockButton);
        frame.add(unlikeButton);
        frame.add(totalMatchedUsersTitle);
        frame.add(totalMatchedUsersNumber);

        //Set size of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410, 550);
        frame.setLayout(null);
        frame.setVisible(true);
        Color LIGHT_PINK = new Color(255, 175, 175, 150);
        frame.getContentPane().setBackground(LIGHT_PINK);

        // Set the position and size of the labels
        matchedTitle.setBounds(25,15,500,50);
        matchedTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 45));

        totalMatchedUsersTitle.setBounds(20, 220, 500, 50);
        totalMatchedUsersTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));

        totalMatchedUsersNumber.setBounds(30, 270, 500, 50);
        totalMatchedUsersNumber.setFont(new Font(Font.MONOSPACED, Font.BOLD, 55));

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
                // Use clicks block button
                user1Acc.getBlockedUsers().add(user1Acc.getLikedUsers().get(selectedUserIndex));
                user1Acc.getLikedUsers().remove(selectedUserIndex);
                new ViewMatchedUsers(user1);
                frame.dispose();
            }
        });

        unlikeButton.setBounds(15,130,185,75);
        unlikeButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        unlikeButton.setFocusable(false);
        unlikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use clicks unlike button
                user1Acc.getLikedUsers().remove(selectedUserIndex);
                new ViewMatchedUsers(user1);
                frame.dispose();
            }
        });

        // Set the position and size of box
        matchedBox.setBounds(10, 80, 385, 30);
        matchedBox.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        matchedBox.setVisible(true);
        matchedBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // User clicks Matched users drop down box
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

    }
}

