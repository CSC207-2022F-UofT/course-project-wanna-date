package UI;

import interfaceAdapters.LogoutController;
import interfaceAdapters.ViewProfileController;
import interfaceAdapters.ViewProfileInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

/** A UI class for ViewProfile feature.
 * */
public class ViewProfilePage extends JFrame implements ActionListener {

    // === Class Variables ===

    // Frame
    JFrame frame;

    // Labels
    JLabel username_label, name_label, age_label, pronouns_label, country_label, province_label, city_label,
            gender_label, sexuality_label, interest_label, pass_label, title;
//            username_value, name_value, age_value, pronouns_value, country_value, province_value, city_value,
//            gender_value, sexuality_value, interest_value, pass_value;

    // Buttons
    JButton recommend_button, search_button, message_button, logout_button;

//    public void retrieveInfo(ArrayList<String> info) {
//        username_value = new JLabel(info.get(0));
//    }

    /** Constructor function that builds the ViewProfile page.
     * */
    public ViewProfilePage(String username) {
        ViewProfileController viewProfileController = new ViewProfileController();
        ArrayList<String> info = viewProfileController.callSearchInfo(username);

        frame = new JFrame();

        // Set labels of user information to display
        title = new JLabel();
        title.setText("Your APHRODITE Profile");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0, 50, 1000, 40);
        title.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));
        title.setFocusable(false);


        username_label = new JLabel();
        username_label.setText("Username:" + "");
        username_label.setBounds(200,125,200,40);
        username_label.setFocusable(false);


        name_label = new JLabel();
        name_label.setText("Full name: " + info.get(1));
        name_label.setBounds(200,175,200,40);
        name_label.setFocusable(false);


        age_label = new JLabel();
        age_label.setText("Age: " + info.get(2));
        age_label.setBounds(200,225,200,40);
        age_label.setFocusable(false);


        pronouns_label = new JLabel();
        pronouns_label.setText("Pronouns: " + info.get(3));
        pronouns_label.setBounds(200,275,200,40);
        pronouns_label.setFocusable(false);

        country_label = new JLabel();
        country_label.setText("Country: " + info.get(4));
        country_label.setBounds(200,325,200,40);
        country_label.setFocusable(false);

        province_label = new JLabel();
        province_label.setText("Province: " + info.get(5));
        province_label.setBounds(200,375,200,40);
        province_label.setFocusable(false);


        city_label = new JLabel();
        city_label.setText("City: " + info.get(6));
        city_label.setBounds(200,425,200,40);
        city_label.setFocusable(false);


        gender_label = new JLabel();
        gender_label.setText("Gender: " + info.get(7));
        gender_label.setBounds(200,475,200,40);
        gender_label.setFocusable(false);


        sexuality_label = new JLabel();
        sexuality_label.setText("Sexuality: " + info.get(8));
        sexuality_label.setBounds(200,525,200,40);
        sexuality_label.setFocusable(false);


        interest_label = new JLabel();
        interest_label.setText("Interest: " + info.get(9));
        interest_label.setBounds(200,575,200,40);
        interest_label.setFocusable(false);


        pass_label = new JLabel();
        pass_label.setText("Password: " + info.get(10));
        pass_label.setBounds(200,625,200,40);
        pass_label.setFocusable(false);


        // Set buttons for different functionality
        recommend_button = new JButton("Recommendation");
        recommend_button.setBounds(200,700,150,40);
        recommend_button.setFocusable(false);
        recommend_button.addActionListener(this);

        search_button = new JButton("Search Users");
        search_button.setBounds(350,700,150,40);
        search_button.setFocusable(false);
        search_button.addActionListener(this);

        message_button = new JButton("Message");
        message_button.setBounds(500,700,150,40);
        message_button.setFocusable(false);
        message_button.addActionListener(this);

        logout_button = new JButton("Log out");
        logout_button.setBounds(650,700,150,40);
        logout_button.setFocusable(false);
        logout_button.addActionListener(this);

        // Add elements to the frame
        frame.add(title);

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
        frame.add(logout_button);

        // Set layout for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        Color LIGHT_PINK = new Color(255, 175, 175, 150);
        frame.getContentPane().setBackground(LIGHT_PINK);
    }

    /** Function that implements actionPerformed function from ActionListener interface.
     * Contains the code for actions to the Recommendation, Search, Message, and Logout buttons.
     * */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == recommend_button) {

        } else if (ae.getSource() == search_button) {

        } else if (ae.getSource() == message_button) {

        } else if (ae.getSource() == logout_button) {
            // Create LogoutController
            LogoutController logoutController = new LogoutController();
            try {
                logoutController.helpWriteDatabase();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            new LoginPage();
            frame.dispose();
        }
    }
}
