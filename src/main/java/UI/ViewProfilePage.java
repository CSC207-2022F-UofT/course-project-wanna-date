package UI;

import Entities.UserDatabase;
import InterfaceAdapters.LogoutController;
import InterfaceAdapters.ViewProfileController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewProfilePage extends JFrame implements ActionListener {

    JFrame frame;

    JLabel username_label, name_label, age_label, pronouns_label, country_label, province_label, city_label,
            gender_label, sexuality_label, interest_label, pass_label;

    JButton recommend_button, search_button, message_button, edit_button, logout_button;

    public ViewProfilePage(UserDatabase database, String username) {
        ViewProfileController viewProfileController = new ViewProfileController();
        ArrayList info = viewProfileController.callSearchInfo(database, username);

        frame = new JFrame();

        // Set labels of user information to display
        username_label = new JLabel();
        username_label.setText("Username: " + info.get(0));
        username_label.setBounds(200,100,200,40);
        username_label.setFocusable(false);


        name_label = new JLabel();
        name_label.setText("Full name: " + info.get(1));
        name_label.setBounds(200,150,200,40);
        name_label.setFocusable(false);


        age_label = new JLabel();
        age_label.setText("Age: " + info.get(2));
        age_label.setBounds(200,200,200,40);
        age_label.setFocusable(false);


        pronouns_label = new JLabel();
        pronouns_label.setText("Pronouns: " + info.get(3));
        pronouns_label.setBounds(200,250,200,40);
        pronouns_label.setFocusable(false);

        country_label = new JLabel();
        country_label.setText("Country: " + info.get(4));
        country_label.setBounds(200,300,200,40);
        country_label.setFocusable(false);

        province_label = new JLabel();
        province_label.setText("Province: " + info.get(5));
        province_label.setBounds(200,350,200,40);
        province_label.setFocusable(false);


        city_label = new JLabel();
        city_label.setText("City: " + info.get(6));
        city_label.setBounds(200,400,200,40);
        city_label.setFocusable(false);


        gender_label = new JLabel();
        gender_label.setText("Gender: " + info.get(7));
        gender_label.setBounds(200,450,200,40);
        gender_label.setFocusable(false);


        sexuality_label = new JLabel();
        sexuality_label.setText("Sexuality: " + info.get(8));
        sexuality_label.setBounds(200,500,200,40);
        sexuality_label.setFocusable(false);


        interest_label = new JLabel();
        interest_label.setText("Interest: " + info.get(9));
        interest_label.setBounds(200,550,200,40);
        interest_label.setFocusable(false);


        pass_label = new JLabel();
        pass_label.setText("Password: " + info.get(10));
        pass_label.setBounds(200,600,200,40);
        pass_label.setFocusable(false);


        // Set buttons for different functionality
        recommend_button = new JButton("Recommendation");
        recommend_button.setBounds(100,700,150,40);
        recommend_button.setFocusable(false);
        recommend_button.addActionListener(this);

        search_button = new JButton("Search Users");
        search_button.setBounds(250,700,150,40);
        search_button.setFocusable(false);
        search_button.addActionListener(this);

        message_button = new JButton("Message");
        message_button.setBounds(400,700,150,40);
        message_button.setFocusable(false);
        message_button.addActionListener(this);

        edit_button = new JButton("Edit Profile");
        edit_button.setBounds(550,700,150,40);
        edit_button.setFocusable(false);
        edit_button.addActionListener(this);

        logout_button = new JButton("Log out");
        logout_button.setBounds(700,700,150,40);
        logout_button.setFocusable(false);
        logout_button.addActionListener(this);

        // Set layout for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setVisible(true);

        // Add elements to the frame
        frame.add(username_label);
        frame.add(name_label);
        frame.add(age_label);
        frame.add(pronouns_label);
        frame.add(country_label);
        frame.add(province_label);
        frame.add(city_label);
        frame.add(gender_label);
        frame.add(sexuality_label);
        frame.add(interest_label);
        frame.add(pass_label);

        frame.add(recommend_button);
        frame.add(search_button);
        frame.add(message_button);
        frame.add(edit_button);
        frame.add(logout_button);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == recommend_button) {

        } else if (ae.getSource() == search_button) {

        } else if (ae.getSource() == message_button) {

        } else if (ae.getSource() == edit_button) {
            frame.dispose();

        } else if (ae.getSource() == logout_button) {
            // Create LogoutController
            LogoutController logoutController = new LogoutController();
            try {
                logoutController.helpWriteDatabase();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            LoginPage loginPage = new LoginPage();
            frame.dispose();
        }
    }
}
