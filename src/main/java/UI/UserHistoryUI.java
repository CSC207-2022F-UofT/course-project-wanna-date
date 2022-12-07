package UI;

import entities.UserAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * UI for the main user history page.
 */
public class UserHistoryUI implements ActionListener {

    // New instance of JFrame
    JFrame frame = new JFrame();

    // Buttons
    JButton likedButton = new JButton("✦ Liked Users ✦");
    JButton blockedButton = new JButton("✖ Blocked Users ✖");
    JButton matchedButton = new JButton("♥ Matched Users ♥");
    JButton backButton = new JButton("Back ⏎");

    // Labels
    JLabel title = new JLabel("USER HISTORY");

    UserAccount user1;

    public UserHistoryUI(UserAccount currUser){

        this.user1 = currUser;

        // Add frames
        frame.add(likedButton);
        frame.add(blockedButton);
        frame.add(title);
        frame.add(backButton);
        frame.add(matchedButton);

        //Set size of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);
        frame.setVisible(true);
        Color LIGHT_PINK = new Color(255, 175, 175, 150);
        frame.getContentPane().setBackground(LIGHT_PINK);

        // Set the positions and sizes of the buttons
        likedButton.setBounds(25,80,350,120);
        likedButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        likedButton.setFocusable(false);
        likedButton.addActionListener(this);

        blockedButton.setBounds(25,210,350,120);
        blockedButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        blockedButton.setFocusable(false);
        blockedButton.addActionListener(this);

        matchedButton.setBounds(25,340,350,120);
        matchedButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        matchedButton.setFocusable(false);
        matchedButton.addActionListener(this);

        backButton.setBounds(15,475,370,35);
        backButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        // Set the position and size of the labels
        title.setBounds(20,15,500,50);
        title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
        title.setVisible(true);
    }


    // Actions when the buttons are pressed
    @Override
    public void actionPerformed(ActionEvent e){
        // User clicks Liked button
        if(e.getSource() == likedButton){
            new ViewLikedUsers(user1);
            frame.dispose();
        }
        // User clicks Blocked button
        else if(e.getSource() == blockedButton){
            new ViewBlockedUsers(user1);
            frame.dispose();
        }
        // User clicks Matched button
        else if(e.getSource() == matchedButton){
            new ViewMatchedUsers(user1);
            frame.dispose();
        }
        // User clicks Back button
        else if(e.getSource() == backButton){
            // Return to main app
            frame.dispose();
        }
    }

    /** CurrUserManager userManager = CurrUserManager.getCurrUserManager();
     UserAccount account = userManager.getCurrUser();*/
    public static void main(String[] args) {

        UserAccount user1 = new UserAccount("johnd", "John Doe", 20, "him", "USA",
                "ILL", "CHI", "M", "H","Watching", "123");
        UserAccount user2 = new UserAccount("JSmith", "Jessica Smith", 18, "her", "CAN",
                "ON", "TOR", "F", "G","Music", "124");
        UserAccount user3 = new UserAccount("janed", "Jane Doe", 18, "her", "CAN",
                "ON", "TOR", "F", "H","Music", "124");
        UserAccount user4 = new UserAccount("jenndoe", "Jennifer Doe", 18, "her", "CAN",
                "ON", "OTT", "F", "H","Music", "124");
        UserAccount user5 = new UserAccount("nicksm", "Nick Smith", 20, "him", "CAN",
                "ON", "OTT", "F", "H","Watching", "124");
        UserAccount user6 = new UserAccount("michel9", "Michelle", 18, "her", "CAN",
                "ON", "OTT", "F", "H","Music", "124");
        UserAccount user7 = new UserAccount("jane65", "Jane Doee", 20, "her", "CAN",
                "ON", "OTT", "F", "H","Watching", "124");

        user1.setLikedUsers(user2);
        user1.setLikedUsers(user4);
        user1.setBlockedUsers(user3);
        user1.setBlockedUsers(user5);
        user1.setLikedUsers(user6);
        user1.setLikedUsers(user7);

        user1.setLikedByUsers(user2);
        user1.setLikedByUsers(user4);
        user1.setLikedByUsers(user5);

        new UserHistoryUI(user1);
    }
}