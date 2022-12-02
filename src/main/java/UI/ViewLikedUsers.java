package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * UI for the liked users page.
 */
public class ViewLikedUsers extends JFrame implements ActionListener {

    // New instance of JFrame
    JFrame frame = new JFrame();

    // Buttons
    JButton backButton = new JButton("Return ⏎");
    JButton blockButton = new JButton("Block ✖");
    JButton unlikeButton = new JButton("Unlike ☹");

    // Labels
    JLabel likedTitle = new JLabel("LIKED USERS");

    // Statistics Labels
    JLabel totalLikedUsers = new JLabel("");
    JLabel likedGender = new JLabel("LIKED USERS");
    JLabel likedCountry = new JLabel("");
    JLabel likedCity = new JLabel("");
    JLabel likedAge = new JLabel("");
    JLabel likedInterest = new JLabel("");

    // List of users they have liked
    String[] likedUsers = {"Liked1", "Liked2"};
    JComboBox likedBox = new JComboBox(likedUsers);


    public ViewLikedUsers(){

        // Add frames
        frame.add(likedTitle);
        frame.add(backButton);
        frame.add(likedBox);
        frame.add(blockButton);
        frame.add(unlikeButton);

        // Set size of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);
        frame.setVisible(true);

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

        // Set the position and size of the labels
        likedTitle.setBounds(30,15,500,50);
        likedTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
        likedTitle.setVisible(true);

        // Set the position and size of box
        likedBox.setBounds(15, 80, 385, 30);
        likedBox.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        likedBox.setVisible(true);
        likedBox.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // Get the user's selection from the dropdown box (combobox)
        Object selection = (String)likedBox.getSelectedItem();

        // User clicks Back button
        if(e.getSource() == backButton){
            new UserHistoryUI();
            frame.dispose();
        }
        // User clicks Unlike Button
        else if(e.getSource() == unlikeButton){
            new ViewLikedUsers();
            frame.dispose();
        }
        // User clicks Block Button
        else if(e.getSource() == blockButton){
            new ViewLikedUsers();
            frame.dispose();
        }
    }


    public static void main(String[] args) {
        new ViewLikedUsers();
    }


}
