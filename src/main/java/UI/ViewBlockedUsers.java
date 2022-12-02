package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * UI for the blocked users page.
 */
public class ViewBlockedUsers extends JFrame implements ActionListener {

    // New instance of JFrame
    JFrame frame = new JFrame();

    // Buttons
    JButton backButton = new JButton("Return ⏎");
    JButton unblockButton = new JButton("Unblock ↺");
    JButton likeButton = new JButton("Like ♥");

    // Labels
    JLabel blockedTitle = new JLabel("BLOCKED USERS");

    //Statistics Labels
    JLabel totalBlockedUsersTitle = new JLabel("Total Number of Blocked Users: ");

    // List of users they have Blocked
    String[] blockedUsers = {"Blocked1", "Blocked2"};
    JComboBox<String>  blockedBox = new JComboBox<>(blockedUsers);


    public ViewBlockedUsers(){

        // Add frames
        frame.add(blockedTitle);
        frame.add(backButton);
        frame.add(unblockButton);
        frame.add(likeButton);
        frame.add(blockedBox);
        frame.add(totalBlockedUsersTitle);

        //Set size of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);
        frame.setVisible(true);

        // Set the position and size of the labels
        blockedTitle.setBounds(20,15,500,50);
        blockedTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 45));

        totalBlockedUsersTitle.setBounds(20, 220, 500, 50);
        totalBlockedUsersTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));

        // Set the position and size of the buttons
        backButton.setBounds(15,475,370,35);
        backButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        unblockButton.setBounds(205,130,190,75);
        unblockButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        unblockButton.setFocusable(false);
        unblockButton.addActionListener(this);

        likeButton.setBounds(15,130,190,75);
        likeButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        likeButton.setFocusable(false);
        likeButton.addActionListener(this);

        // Set the position and size of box
        blockedBox.setBounds(15, 80, 385, 30);
        blockedBox.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        blockedBox.setVisible(true);
        blockedBox.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // Get the user's selection from the dropdown box (combobox)
        Object selection = blockedBox.getSelectedItem();

        // User clicks Back button
        if(e.getSource() == backButton){
            new UserHistoryUI();
            frame.dispose();
        }
        // User clicks Like Button
        else if(e.getSource() == likeButton){
            new ViewBlockedUsers();
            frame.dispose();
        }
        // User clicks Unblock Button
        else if(e.getSource() == unblockButton){
            new ViewBlockedUsers();
            frame.dispose();
        }
    }


    public static void main(String[] args) {
        new ViewBlockedUsers();
    }

}
