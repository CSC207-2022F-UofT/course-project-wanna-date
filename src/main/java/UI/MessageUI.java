package UI;

import entities.MessageFactory;
import entities.MessageFormat;
import entities.UserAccount;
import frameworksDrivers.MessageFileUser;
import interfaceAdapters.*;
import useCase.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MessageUI implements ActionListener, ItemListener {

    JFrame frame = new JFrame("Aphrodite");

    public String username;
    JButton send = new JButton("Send Message");
    JLabel message = new JLabel();
    JLabel to = new JLabel("To: ");
    JLabel from;

    public MessageDSGateway gateway = new MessageFileUser("./messages.csv");;
    public ReceiveMessageOB messagePresenter = new SendMessagePresenter();
    public MessageFactory messageFactory = new MessageFormat();
    public SendMessageIB interact = new SendMessage(gateway, messagePresenter, messageFactory);
    public SendMessageController sendMessageController = new SendMessageController(interact);


    // drop down menu, list of users they have liked (can't talk with all of them)
//    JComboBox mutuallyLiked = new JComboBox(likedUsers());
    public String[] liked;
    JComboBox mutuallyLiked = new JComboBox(liked);
    public String receiver;
    JTextField text = new JTextField();
    public String textMessage = "";

    // past texts
    public String[] messages;
    JLabel text1, text2, text3, text4, text5;

    public MessageUI(String user, String[] likedUsers, String[] texts) throws IOException {
        username = user;
        liked = likedUsers;
        messages = texts;
        from = new JLabel("From: " + user);

        // position of button and size of button
        send.setBounds(700, 460, 200, 40);
        send.setFocusable(false);
        send.addActionListener(this);

        // show message
        message.setBounds(100,350,300,50);
        message.setFont(new Font(null, Font.PLAIN, 18));
        message.setVisible(false);

        to.setBounds(550,100,50,50);
        to.setFont(new Font(null, Font.PLAIN, 18));
        to.setVisible(true);

        from.setBounds(100,100,1000,50);
        from.setFont(new Font(null, Font.PLAIN, 18));
        from.setVisible(true);

        mutuallyLiked.setBounds(600, 100, 300, 50);
        mutuallyLiked.setFont(new Font(null, Font.PLAIN, 25));
        mutuallyLiked.addItemListener(this);

        text.setBounds(100, 460, 600,40);
        text.setFont(new Font(null, Font.PLAIN, 25));
        text.setEnabled(false);

        // past texts
        text1.setBounds(100,150,300,50);
        text1.setFont(new Font(null, Font.PLAIN, 18));
        text1.setVisible(false);
        text1.setForeground(Color.BLUE);

        text2.setBounds(100,200,300,50);
        text2.setFont(new Font(null, Font.PLAIN, 18));
        text2.setVisible(false);

        text3.setBounds(100,250,300,50);
        text3.setFont(new Font(null, Font.PLAIN, 18));
        text3.setVisible(false);
        text3.setForeground(Color.BLUE);

        text4.setBounds(100,300,300,50);
        text4.setFont(new Font(null, Font.PLAIN, 18));
        text4.setVisible(false);

        text5.setBounds(100,350,300,50);
        text5.setFont(new Font(null, Font.PLAIN, 18));
        text5.setVisible(false);
        text5.setForeground(Color.BLUE);

        // how to close the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(send);
        frame.add(mutuallyLiked);
        frame.add(text);
        frame.add(message);
        frame.add(to);
        frame.add(from);

        // past texts
        frame.add(text1);
        frame.add(text2);
        frame.add(text3);
        frame.add(text4);
        frame.add(text5);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // what happens when send button is clicked
        if(e.getSource() == send){
            textMessage = text.getText();
            message.setText(textMessage);
            message.setVisible(true);

            // if time figure out how to text more than one text at a time
            text1.setVisible(false);
            text2.setBounds(100,150,300,50);
            text3.setBounds(100,200,300,50);
            text4.setBounds(100,250,300,50);
            text5.setBounds(100,300,300,50);
            text.setText("");

            SendMessageID input = new SendMessageID(mutuallyLiked.getSelectedItem().toString(), username, textMessage);
            ReceiveMessageOD pastMessages = sendMessageController.saveMessage(input);
            Map<LocalDateTime, SendMessageDS> texts = pastMessages.getSent();
            Map<String, String> usersText = new HashMap<String, String>();
            String[] fiveText = {"", "", "", "", ""};

            for (SendMessageDS messageDS : texts.values()){
                usersText.put(messageDS.getMessage(), messageDS.getSender());
//                fiveText[0] =
            }

        }
    }

    public void itemStateChanged(ItemEvent e)
    {
        boolean areLiked = false;
        // if the state combobox is changed
        if (e.getSource() == mutuallyLiked) {
            receiver = mutuallyLiked.getSelectedItem().toString();
            for (String s : liked) {
                if (receiver.equals(s)) {
                    areLiked = true;
                    break;
                }
            }

            if (!areLiked){
                JOptionPane.showMessageDialog(null,"Can't talk just yet!");
                text1.setVisible(false);
                text2.setVisible(false);
                text3.setVisible(false);
                text4.setVisible(false);
                text5.setVisible(false);
                message.setVisible(false);
                text.setEnabled(false);
            }
            else{
                text.setEnabled(true);
                text1.setVisible(true);
                text2.setVisible(true);
                text3.setVisible(true);
                text4.setVisible(true);
                text5.setVisible(true);
            }
        }
    }

    // example code
    public static String[] likedUsers(){
        // for testing
        UserAccount sender = new UserAccount("AL", "AML", 20, "her", "CAN",
                "ON", "TOR", "F", "H","Watching", "123");
        UserAccount receiver1 = new UserAccount("JSmith", "Jessica Smith", 20, "her", "CAN",
                "ON", "TOR", "F", "H","Music", "124");
        UserAccount receiver2 = new UserAccount("LW", "Lisa Wood", 32, "her", "CAN",
                "ON", "TOR", "F", "H","Sports", "125");
        sender.setLikedUsers(receiver1);
        sender.setLikedUsers(receiver2);
        String[] user = {receiver1.getFullName(), receiver2.getFullName()};

        receiver2.setLikedUsers(sender);
        return user;
    }

//    public static void main(String[] args) {
//        String[] copy = {"Hi", "Hello", "How are you?"};
//        new MessageUI("Harry", likedUsers(), copy);
//    }
}

