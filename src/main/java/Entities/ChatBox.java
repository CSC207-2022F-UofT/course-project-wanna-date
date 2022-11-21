package Entities;

import Entities.UserAccount;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChatBox implements ActionListener {

    JFrame frame = new JFrame();
    JButton send = new JButton("Send Message");
//    JLabel message = new JLabel("Hello!");
    JLabel message = new JLabel();
    JLabel hi = new JLabel("hi");

    // drop down menu, list of users they have liked (can't talk with all of them)
    UserAccount user;
    UserAccount[] likedUsers = new UserAccount[user.get_liked_users().size()];
    ArrayList<String> usersa = new ArrayList<String>();
    ArrayList<String> users;
    JComboBox mutuallyLiked;
    public UserAccount receiver;
    JTextField text = new JTextField();
    public String textMessage;

    public ChatBox(){
        likedUsers = user.get_liked_users().toArray(likedUsers);
        mutuallyLiked = new JComboBox(likedUsers);

        // position of button and size of button
        send.setBounds(700, 460, 200, 40);
        send.setFocusable(false);
        send.addActionListener(this);

        // show message
        message.setBounds(100,100,300,50);
        message.setFont(new Font(null, Font.PLAIN, 12));
        message.setVisible(false);

        hi.setBounds(100,100,300,50);
        hi.setFont(new Font(null, Font.PLAIN, 12));
        hi.setVisible(false);

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

        // making the rectangles to make it more organized
        // NOT WORKING!!!
        JPanel panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                // one rectangle for border, one for username, draw line for chat
                g.drawRect(200, 200, 100, 100);
            }
        };
        frame.add(panel);
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
        new ChatBox();
    }
}
