package UI;
import entities.UserAccount;
import useCase.GenerateUserHistory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * UI for the matched users page.
 */
public class ViewMatchedUsers extends JFrame implements ActionListener {

    // Get current user // Test user for now
    UserAccount user1 = new UserAccount("johnd", "John Doe", 20, "her", "USA",
            "ILL", "CHI", "M", "H","Watching", "123");
    UserAccount currentUser;

    GenerateUserHistory generateHistory = new GenerateUserHistory();

    // Get the total number of matches this user has
    String totalMatched = Integer.toString(generateHistory.getTotalMatches(user1));

    // New instance of JFrame
    JFrame frame = new JFrame();

    // Buttons
    JButton backButton = new JButton("Return ⏎");
    JButton blockButton = new JButton("Block ✖");
    JButton unlikeButton = new JButton("Unlike");

    // Labels
    JLabel matchedTitle = new JLabel("MATCHED USERS");

    // Statistics labels
    JLabel totalMatchedUsersTitle = new JLabel("Total Number of Matched Users: ");
    JLabel totalMatchedUsersNumber = new JLabel(totalMatched);

    // List of users they have Blocked
    String[] matchedUsers = generateHistory.matchedUsernames(user1);
    JComboBox<String> matchedBox = new JComboBox<>(matchedUsers);


    public ViewMatchedUsers(){

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
        frame.setSize(400, 550);
        frame.setLayout(null);
        frame.setVisible(true);

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
        matchedBox.setBounds(10, 80, 385, 30);
        matchedBox.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        matchedBox.setVisible(true);
        matchedBox.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // Get the user's selection from the dropdown box (combobox)
        Object selection = matchedBox.getSelectedItem();

        // User clicks Back button
        if(e.getSource() == backButton){
            new UserHistoryUI();
            frame.dispose();
        }
        // User clicks Unlike Button
        else if(e.getSource() == unlikeButton){
            new ViewMatchedUsers();
            frame.dispose();
        }
        // User clicks Block Button
        else if(e.getSource() == blockButton){
            new ViewMatchedUsers();
            frame.dispose();
        }
    }


    public static void main(String[] args) {
        new ViewMatchedUsers();
    }
}



