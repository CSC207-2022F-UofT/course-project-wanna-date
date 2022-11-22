package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserHistoryUI implements ActionListener {

    //New instance of JFrame
    JFrame frame = new JFrame();
    JButton likedButton = new JButton("Liked Users");
    JButton blockedButton = new JButton("Blocked Users");
    JLabel title = new JLabel("USER HISTORY");
    JLabel likedTitle = new JLabel("LIKED USERS");
    JLabel blockedTitle = new JLabel("BLOCKED USERS");
    JButton backButton = new JButton("Back");

    //List of users they have liked
    String[] likedUsers = {"Liked1", "Liked2"};
    JComboBox likedBox = new JComboBox(likedUsers);

    //List of users they have Blocked
    String[] blockedUsers = {"Blocked1", "Blocked2"};
    JComboBox blockedBox = new JComboBox(blockedUsers);

    public UserHistoryUI(){

        //Set the positions and sizes of the buttons
        likedButton.setBounds(195,220,300,50);
        likedButton.setFocusable(false);
        likedButton.addActionListener(this);

        blockedButton.setBounds(195,370,300,50);
        blockedButton.setFocusable(false);
        blockedButton.addActionListener(this);

        backButton.setBounds(15,700,70,60);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        //Set the position and size of the label
        title.setBounds(210,80,300,50);
        title.setFont(new Font(null, Font.PLAIN, 40));
        title.setVisible(true);

        likedTitle.setBounds(220,80,300,50);
        likedTitle.setFont(new Font(null, Font.PLAIN, 40));
        likedTitle.setVisible(false);

        blockedTitle.setBounds(190,80,500,50);
        blockedTitle.setFont(new Font(null, Font.PLAIN, 40));
        blockedTitle.setVisible(false);

        likedBox.setBounds(200, 250, 300, 50);
        likedBox.setFont(new Font(null, Font.PLAIN, 25));
        likedBox.setVisible(false);

        blockedBox.setBounds(200, 250, 300, 50);
        blockedBox.setFont(new Font(null, Font.PLAIN, 25));
        blockedBox.setVisible(false);

        //Set size of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 800);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(likedButton);
        frame.add(blockedButton);
        frame.add(title);
        frame.add(backButton);
        frame.add(likedBox);
        frame.add(blockedBox);
        frame.add(likedTitle);
        frame.add(blockedTitle);
    }


    //Actions when the buttons are pressed
    @Override
    public void actionPerformed(ActionEvent e){
        //User clicks Liked button
        if(e.getSource() == likedButton){
            likedButton.setVisible(false);
            likedButton.addActionListener(this);
            likedButton.setEnabled(false);
            blockedButton.setVisible(false);
            blockedButton.addActionListener(this);
            blockedButton.setEnabled(false);
            likedBox.setVisible(true);
            title.setVisible(false);
            likedTitle.setVisible(true);
        }
        //User clicks Blocked button
        else if(e.getSource() == blockedButton){
            likedButton.setVisible(false);
            likedButton.addActionListener(this);
            likedButton.setEnabled(false);
            blockedButton.setVisible(false);
            blockedButton.addActionListener(this);
            blockedButton.setEnabled(false);
            blockedBox.setVisible(true);
            title.setVisible(false);
            blockedTitle.setVisible(true);
        }
        //User clicks Back button
        else if(e.getSource() == backButton){
            title.setVisible(false);
            likedButton.setVisible(false);
            likedButton.addActionListener(this);
            likedButton.setEnabled(false);
            blockedButton.setVisible(false);
            blockedButton.addActionListener(this);
            blockedButton.setEnabled(false);
        }
    }


    public static void main(String[] args) {
        new UserHistoryUI();
    }
}