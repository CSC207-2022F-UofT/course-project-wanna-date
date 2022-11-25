package UI;

import Entities.UserAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChatBoxUI implements ActionListener {
    JFrame frame = new JFrame();
    JButton send = new JButton("Send Message");
    // texts
    String m1 = "hi";
    String m2 = "hello";
    String m3 = "how are you";
    String m4 = "good";
    JLabel message = new JLabel();
    JLabel message1 = new JLabel(m1);
    JLabel message2 = new JLabel(m2);
    JLabel message3 = new JLabel(m3);
    JLabel message4 = new JLabel(m4);
    // drop down menu, list of users they have liked (can't talk with all of them)
    UserAccount user;

    // in order to have get liked users to work, I need it to be a list
    //String[] likedUsers = new String[user.get_liked_users().size()];
    ArrayList<String> usersa = new ArrayList<String>();
    JComboBox mutuallyLiked;
    public UserAccount receiver;
    JTextField text = new JTextField();
    public String textMessage;

    public ChatBoxUI(){
            // proper implementation with code
//        for (int i = 0; i < user.get_liked_users().size(); i++){
//            likedUsers[i] = user.get_liked_users().get(i).get_full_name();
//        }
//        mutuallyLiked = new JComboBox(likedUsers);

        //test out combo box issue
        usersa.add("Mark");
        usersa.add("Paul");
        usersa.add("Kim");

        String[] users = new String[usersa.size()];
        for (int i = 0; i < usersa.size(); i++){
            users[i] = usersa.get(i);
        }
        mutuallyLiked = new JComboBox(users);

        // position of button and size of button
        send.setBounds(700, 460, 200, 40);
        send.setFocusable(false);
        send.addActionListener(this);

        // show message
        message.setBounds(100,180,300,50);
        message.setFont(new Font(null, Font.PLAIN, 12));
        message.setVisible(false);

        message1.setBounds(100,100,300,50);
        message1.setFont(new Font(null, Font.PLAIN, 12));
        message1.setVisible(true);

        message2.setBounds(100,120,300,50);
        message2.setFont(new Font(null, Font.PLAIN, 12));
        message2.setVisible(true);

        message3.setBounds(100,140,300,50);
        message3.setFont(new Font(null, Font.PLAIN, 12));
        message3.setVisible(true);

        message4.setBounds(100,160,300,50);
        message4.setFont(new Font(null, Font.PLAIN, 12));
        message4.setVisible(true);

        // ComboBox
        mutuallyLiked.setBounds(800, 100, 100, 50);
        mutuallyLiked.setFont(new Font(null, Font.PLAIN, 25));

        text.setBounds(100, 460, 600,40);
        text.setFont(new Font(null, Font.PLAIN, 25));

        // how to close the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(send);
        frame.add(mutuallyLiked);
        frame.add(text);

        frame.add(message1);
        frame.add(message2);
        frame.add(message3);
        frame.add(message4);

        frame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // what happens when send button is clicked
        if(e.getSource() == send){
            textMessage = text.getText();
            message.setText(textMessage);
            frame.add(message);
            message.setVisible(true);
        }
        else if (e.getSource() == mutuallyLiked) {
            // show previous messages is they have
            // if message history is empty then show a label that say start a conversation with said user
            receiver = (UserAccount) mutuallyLiked.getSelectedItem();
        }
    }

    public static void main(String[] args) {
        new ChatBoxUI();
    }
}

