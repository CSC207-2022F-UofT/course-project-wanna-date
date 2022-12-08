package UI;

import entities.UserAccount;
import interfaceAdapters.UserHistoryController;
import useCase.GenerateUserHistory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * UI for the blocked users page.
 */
public class ViewBlockedUsers extends JFrame implements ActionListener {

    // New instance of JFrame
    JFrame frame = new JFrame();

    // Buttons
    JButton backButton = new JButton("Return");
    JButton unblockButton = new JButton("Unblock");
    JButton likeButton = new JButton("Like");

    // Labels
    JLabel blockedTitle = new JLabel("BLOCKED USERS");

    //Statistics Labels
    JLabel totalBlockedUsersTitle = new JLabel("Total Number of Blocked Users: ");

    String user1;

    int selectedUserIndex;

    public ViewBlockedUsers(String currUsername){

        UserHistoryController userHistoryController = new UserHistoryController();
        ArrayList<String> stats = userHistoryController.callGetUserStats(currUsername);

        this.user1 = currUsername;

        GenerateUserHistory generateHistory = new GenerateUserHistory();

        // Get the UserAccount entity info from the given username and store it
        UserAccount user1Acc = generateHistory.getCurrUserAccount(user1);

        // Get the total number of blocks this user has
        String totalBlocks = stats.get(6);
        JLabel totalBlockedUsersNumber = new JLabel(totalBlocks);

        // List of users they have Blocked
        String[] blockedUsers = generateHistory.blockedUsernames(user1Acc);
        JComboBox<String>  blockedBox = new JComboBox<>(blockedUsers);

        // Add frames
        frame.add(blockedTitle);
        frame.add(backButton);
        frame.add(unblockButton);
        frame.add(likeButton);
        frame.add(blockedBox);
        frame.add(totalBlockedUsersTitle);
        frame.add(totalBlockedUsersNumber);

        //Set size of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);
        frame.setVisible(true);
        Color LIGHT_PINK = new Color(255, 175, 175, 150);
        frame.getContentPane().setBackground(LIGHT_PINK);

        // Set the position and size of the labels
        blockedTitle.setBounds(20,15,500,50);
        blockedTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 45));

        totalBlockedUsersTitle.setBounds(20, 220, 500, 50);
        totalBlockedUsersTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));

        totalBlockedUsersNumber.setBounds(30, 270, 500, 50);
        totalBlockedUsersNumber.setFont(new Font(Font.MONOSPACED, Font.BOLD, 55));

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

        unblockButton.setBounds(205,130,190,75);
        unblockButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        unblockButton.setFocusable(false);
        unblockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // User clicks Unblock Button
                user1Acc.getBlockedUsers().remove(selectedUserIndex);
                new ViewBlockedUsers(user1);
                frame.dispose();
            }
        });

        likeButton.setBounds(15,130,190,75);
        likeButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        likeButton.setFocusable(false);
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use clicks like button
                user1Acc.getLikedUsers().add(user1Acc.getBlockedUsers().get(selectedUserIndex));
                user1Acc.getBlockedUsers().remove(selectedUserIndex);
                new ViewBlockedUsers(user1);
                frame.dispose();
            }
        });

        // Set the position and size of box
        blockedBox.setBounds(10, 80, 385, 30);
        blockedBox.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        blockedBox.setVisible(true);
        blockedBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // User clicks Blocked users drop down box
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
