package UI.message;

import entities.*;
import frameworks_drivers.MessageFileUser;
import interface_adapters.*;
import use_case.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class MessageUI implements ActionListener, ItemListener {
    JFrame frame = new JFrame("Aphrodite");

    public String username;

    public String currUsername;
    JButton send = new JButton("Send Message");

    JButton back = new JButton("Back");
    JLabel to = new JLabel("To: ");
    JLabel from;

    public MessageDSGateway gateway = new MessageFileUser("./messages.csv");
    public ReceiveMessageOB messagePresenter = new SendMessagePresenter();
    public MessageFactory messageFactory = new MessageFormat();
    public SendMessageIB interact = new SendMessage(gateway, messagePresenter, messageFactory);
    public SendMessageController sendMessageController = new SendMessageController(interact);

    // drop down menu, list of users they have liked (can't talk with all of them)
    public String[] liked;
    String[] pickUser = {"Select a user."};
    JComboBox<String> mutuallyLiked = new JComboBox<>(pickUser);
    public String receiver;
    JTextField text = new JTextField();
    public String textMessage = "";

    JLabel text1 = new JLabel("");
    JLabel text2 = new JLabel("");
    JLabel text3 = new JLabel("");
    JLabel text4 = new JLabel("");
    JLabel text5 = new JLabel("");

    JLabel[] textMessages = {text1, text2, text3, text4, text5};

    public MessageUI(String currUsername, String user, String[] likedUsers) throws IOException {
        this.currUsername = currUsername;
        username = user;
        liked = likedUsers;
        from = new JLabel("From: " + user);

        // position of button and size of button
        send.setBounds(700, 460, 200, 40);
        send.setFocusable(false);
        send.addActionListener(this);

        to.setBounds(550,100,50,50);
        to.setFont(new Font(null, Font.PLAIN, 18));
        to.setVisible(true);

        from.setBounds(100,100,1000,50);
        from.setFont(new Font(null, Font.PLAIN, 18));
        from.setVisible(true);

        mutuallyLiked.setBounds(600, 100, 300, 50);
        mutuallyLiked.setFont(new Font(null, Font.PLAIN, 25));
        mutuallyLiked.addItemListener(this);

        for (String liked : likedUsers){
            mutuallyLiked.addItem(liked);
        }

        text.setBounds(100, 460, 600,40);
        text.setFont(new Font(null, Font.PLAIN, 25));
        text.setEnabled(false);

        // past texts
        for (JLabel textInfo : textMessages){
            textInfo.setFont(new Font(null, Font.PLAIN, 18));
            textInfo.setVisible(false);
        }

        text1.setBounds(100,150,300,50);
        text2.setBounds(100,200,300,50);
        text3.setBounds(100,250,300,50);
        text4.setBounds(100,300,300,50);
        text5.setBounds(100,350,300,50);

        back.setBounds(50,50,100,30);
        back.addActionListener(this);

        // how to close the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        Color LIGHT_PINK = new Color(255, 200, 175, 250);
        frame.getContentPane().setBackground(LIGHT_PINK);

        frame.add(send);
        frame.add(mutuallyLiked);
        frame.add(text);
        frame.add(to);
        frame.add(from);

        // past texts
        frame.add(text1);
        frame.add(text2);
        frame.add(text3);
        frame.add(text4);
        frame.add(text5);

        // back button
        frame.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // what happens when send button is clicked
        if(e.getSource() == send){
            textMessage = text.getText();

            displayMessages(Objects.requireNonNull(mutuallyLiked.getSelectedItem()).toString(), username, textMessage);
        } else if (e.getSource() == back) {
            ViewProfilePage viewProfilePage = null;
            try {
                viewProfilePage = new ViewProfilePage(currUsername);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            viewProfilePage.buildPage();
            frame.dispose();
        }
    }

    public void itemStateChanged(ItemEvent e)
    {
        boolean areLiked = false;

        // if the state combobox is changed
        if (e.getSource() == mutuallyLiked) {
            receiver = Objects.requireNonNull(mutuallyLiked.getSelectedItem()).toString();
            for (String s : liked) {
                if (receiver.equals(s)) {
                    areLiked = true;
                    break;
                }
            }

            if (!areLiked){
                JOptionPane.showMessageDialog(null,"Can't talk just yet!");
                for (JLabel msg : textMessages){
                    msg.setVisible(false);
                }
                text.setEnabled(false);
            }
            else{
                text.setEnabled(true);
                for (JLabel msg : textMessages){
                    msg.setVisible(true);
                }
            }

            displayMessages(mutuallyLiked.getSelectedItem().toString(), username, "");
        }
    }

    public void displayMessages(String receiver, String user, String msg){
        SendMessageID input = new SendMessageID(receiver, user, msg);
        ReceiveMessageOD pastMessages = sendMessageController.saveMessage(input);
        Map<LocalDateTime, SendMessageDS> texts = pastMessages.getSent();
        Map<String, String> usersText = new HashMap<>();

        for (SendMessageDS messageDS : texts.values()){
            usersText.put(messageDS.getMessage(), messageDS.getSender());
        }

        Set<String> keys = usersText.keySet();
        String[] fiveTexts = keys.toArray(new String[5]);

        // if time figure out how to text more than one text at a time
        text1.setText(fiveTexts[0]);
        text2.setText(fiveTexts[1]);
        text3.setText(fiveTexts[2]);
        text4.setText(fiveTexts[3]);
        text5.setText(fiveTexts[4]);
        text.setText("");

        // change colour of text
        for (JLabel text : textMessages){
            if (!usersText.get(text.getText()).equals(username)){
                text.setForeground(Color.BLUE);
            }
        }
    }
}