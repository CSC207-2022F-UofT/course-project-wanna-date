package UI;
import Entities.UserAccount;
import InterfaceAdapters.ControllerLikeBlock;
import UseCase.ReceiveBlockInputBoundary;
import UseCase.ReceiveLike;
import UseCase.ReceiveLikeInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserLikeBlock implements ActionListener {
    UserAccount user1;
    UserAccount user2;
    ControllerLikeBlock controller;
    JFrame profile = new JFrame();
    JLabel fullName = new JLabel("Full Name: " );

    JButton like = new JButton("Like");

    JLabel likedString = new JLabel();



    public UserLikeBlock(UserAccount user1, UserAccount user2, ControllerLikeBlock controller){
        //Initiate the variables so that we can use it for the actionPerformed function
        this.user1 = user1;
        this.user2 = user2;
        this.controller = controller;

        profile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //THE CLOSE BUTTON
        profile.setSize(1000, 700); //size of the frame
        profile.setLayout(null); //customize where u want everything to go
        profile.setVisible(true);

        fullName.setBounds(10,10, 100, 100); //coordinate and size of the label
        fullName.setFont(new Font(null, Font.PLAIN, 14));
        fullName.setVisible(true);

        like.setBounds(10,500, 60, 40); //coordinate and size of the label
        like.setFocusable(false);
        like.addActionListener(this);
        like.setBackground(Color.red);
        like.setOpaque(true);

        likedString.setBounds(500,50, 100, 100); //coordinate and size of the label
        likedString.setFont(new Font(null, Font.PLAIN, 14));
        likedString.setVisible(false);

        profile.add(fullName);
        profile.add(like);
        profile.add(likedString);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== like) {
            String textShow= controller.likeController(user1, user2);
            likedString.setText(textShow);
            likedString.setVisible(true);

        }
    }

    public static void main (String[] args) {

        ArrayList<String> interests1 = new ArrayList<>();
        interests1.add("watch");
        ArrayList<String>interest2 = new ArrayList<>();
        interest2.add("Eat");
        UserAccount user1 = new UserAccount("AL", "AML", 20, "her", "CAN",
                "ON", "TOR", 'F', 'H',interests1, "123", "num");
        UserAccount user2 = new UserAccount("EL", "EML", 20, "her", "CAN",
                "ON", "TOR", 'F', 'H',interest2, "124", "num");
        ControllerLikeBlock control = new ControllerLikeBlock();
        new UserLikeBlock(user1, user2, control);

    }
}