package UI;

import interfaceAdapters.RegistrationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** A UI class for Registration feature.
 * */
public class RegistrationPage extends JFrame implements ActionListener{

    // === Class Variables ===

    // Frame
    JFrame frame;

    // Labels
    JLabel username_label, name_label, age_label, pronouns_label, country_label, province_label, city_label,
            gender_label, sexuality_label, interest_label, pass_label;

    // Text fields
    final JTextField username_textField, name_textField, age_textField, country_textField,
            province_textField, city_textField, pass_textField;

    // Drop-down options
    JComboBox<String> pronouns_comboBox, gender_comboBox, sexuality_comboBox, interest_comboBox;

    // Buttons
    JButton register_button2, back_button;

    /** Constructor function that builds the Registration page.
     * */
    public RegistrationPage() {

        frame = new JFrame();

        username_label = new JLabel();
        username_label.setText("Username:");
        username_label.setBounds(200,100,200,40);
        username_label.setFocusable(false);
        username_textField = new JTextField(50);
        username_textField.setBounds(400,100,200,40);

        name_label = new JLabel();
        name_label.setText("Full name:");
        name_label.setBounds(200,150,200,40);
        name_label.setFocusable(false);
        name_textField = new JTextField(50);
        name_textField.setBounds(400,150,200,40);

        age_label = new JLabel();
        age_label.setText("Age:");
        age_label.setBounds(200,200,200,40);
        age_label.setFocusable(false);
        age_textField = new JTextField(50);
        age_textField.setBounds(400,200,200,40);

        pronouns_label = new JLabel();
        pronouns_label.setText("Pronouns:");
        pronouns_label.setBounds(200,250,200,40);
        pronouns_label.setFocusable(false);
        String[] list_pronouns = {"He/Him", "She/Her", "They/Them"};
        pronouns_comboBox = new JComboBox<>(list_pronouns);
        pronouns_comboBox.setBounds(400,250,200,40);
        pronouns_comboBox.setBackground(Color.WHITE);

        country_label = new JLabel();
        country_label.setText("Country:");
        country_label.setBounds(200,300,200,40);
        country_label.setFocusable(false);
        country_textField = new JTextField(50);
        country_textField.setBounds(400,300,200,40);

        province_label = new JLabel();
        province_label.setText("Province:");
        province_label.setBounds(200,350,200,40);
        province_label.setFocusable(false);
        province_textField = new JTextField(50);
        province_textField.setBounds(400,350,200,40);

        city_label = new JLabel();
        city_label.setText("City:");
        city_label.setBounds(200,400,200,40);
        city_label.setFocusable(false);
        city_textField = new JTextField(50);
        city_textField.setBounds(400,400,200,40);

        gender_label = new JLabel();
        gender_label.setText("Gender:");
        gender_label.setBounds(200,450,200,40);
        gender_label.setFocusable(false);
        String[] list_gender = {"M: Male", "F: Female", "N: Non-binary"};
        gender_comboBox = new JComboBox<>(list_gender);
        gender_comboBox.setBounds(400,450,200,40);
        gender_comboBox.setBackground(Color.WHITE);

        sexuality_label = new JLabel();
        sexuality_label.setText("Sexuality:");
        sexuality_label.setBounds(200,500,200,40);
        sexuality_label.setFocusable(false);
        String[] list_sexuality = {"G: Gay", "L: Lesbian", "H: Heterosexual", "B: Binary"};
        sexuality_comboBox = new JComboBox<>(list_sexuality);
        sexuality_comboBox.setBounds(400,500,200,40);
        sexuality_comboBox.setBackground(Color.WHITE);

        interest_label = new JLabel();
        interest_label.setText("Interest:");
        interest_label.setBounds(200,550,200,40);
        interest_label.setFocusable(false);
        String[] list_interest = {"Culinary", "Sports", "Watching", "Photography", "Travelling",
                "Fashion", "Music", "Exercise", "Games", "Socializing", "Others"};
        interest_comboBox = new JComboBox<>(list_interest);
        interest_comboBox.setBounds(400,550,200,40);
        interest_comboBox.setBackground(Color.WHITE);

        pass_label = new JLabel();
        pass_label.setText("Password:");
        pass_label.setBounds(200,600,200,40);
        pass_label.setFocusable(false);
        pass_textField = new JTextField(50);
        pass_textField.setBounds(400,600,200,40);

        // Create buttons
        register_button2 = new JButton("Register new account");
        register_button2.setBounds(500,700,200,40);
        register_button2.setFocusable(false);
        register_button2.addActionListener(this);

        back_button = new JButton("BACK");
        back_button.setBounds(300,700,200,40);
        back_button.setFocusable(false);
        back_button.addActionListener(this);

        // Add elements to frame
        frame.add(username_label);
        frame.add(username_textField);
        frame.add(name_label);
        frame.add(name_textField);
        frame.add(age_label);
        frame.add(age_textField);
        frame.add(pronouns_label);
        frame.add(pronouns_comboBox);
        frame.add(country_label);
        frame.add(country_textField);
        frame.add(province_label);
        frame.add(province_textField);
        frame.add(city_label);
        frame.add(city_textField);
        frame.add(gender_label);
        frame.add(gender_comboBox);
        frame.add(sexuality_label);
        frame.add(sexuality_comboBox);
        frame.add(interest_label);
        frame.add(interest_comboBox);
        frame.add(pass_label);
        frame.add(pass_textField);

        frame.add(register_button2);
        frame.add(back_button);

        // Set layout for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        setTitle("REGISTRATION FORM");
    }

    /** Function that implements actionPerformed function from ActionListener interface.
     * Contains the code for actions to the Register and Back buttons.
     * */
    @Override
    public void actionPerformed(ActionEvent ae) {

        String username_value = username_textField.getText();
        String name_value = name_textField.getText();
        String age_value = age_textField.getText();
        String pronouns_value = "";
        if (pronouns_comboBox.getSelectedIndex() == 0) {
            pronouns_value = "He/Him";
        } else if (pronouns_comboBox.getSelectedIndex() == 1) {
            pronouns_value = "She/Her";
        } else if (pronouns_comboBox.getSelectedIndex() == 2) {
            pronouns_value = "They/Them";
        }
        String country_value = country_textField.getText();
        String province_value = province_textField.getText();
        String city_value = city_textField.getText();
        String gender_value = "";
        if (gender_comboBox.getSelectedIndex() == 0) {
            gender_value = "M";
        } else if (gender_comboBox.getSelectedIndex() == 1) {
            gender_value = "F";
        } else if (gender_comboBox.getSelectedIndex() == 2) {
            gender_value = "N";
        }
        String sexuality_value = "";
        if (sexuality_comboBox.getSelectedIndex() == 0) {
            sexuality_value = "G";
        } else if (sexuality_comboBox.getSelectedIndex() == 1) {
            sexuality_value = "L";
        } else if (sexuality_comboBox.getSelectedIndex() == 2) {
            sexuality_value = "H";
        } else if (sexuality_comboBox.getSelectedIndex() == 3) {
            sexuality_value = "B";
        }
        String interest_value = "";
        if (interest_comboBox.getSelectedIndex() == 0) {
            interest_value = "Culinary";
        } else if (interest_comboBox.getSelectedIndex() == 1) {
            interest_value = "Sports";
        } else if (interest_comboBox.getSelectedIndex() == 2) {
            interest_value = "Watching";
        } else if (interest_comboBox.getSelectedIndex() == 3) {
            interest_value = "Photography";
        } else if (interest_comboBox.getSelectedIndex() == 4) {
            interest_value = "Travelling";
        } else if (interest_comboBox.getSelectedIndex() == 5) {
            interest_value = "Fashion";
        } else if (interest_comboBox.getSelectedIndex() == 6) {
            interest_value = "Music";
        } else if (interest_comboBox.getSelectedIndex() == 7) {
            interest_value = "Exercise";
        } else if (interest_comboBox.getSelectedIndex() == 8) {
            interest_value = "Games";
        } else if (interest_comboBox.getSelectedIndex() == 9) {
            interest_value = "Socializing";
        } else if (interest_comboBox.getSelectedIndex() == 10) {
            interest_value = "Others";
        }
        String pass_value = pass_textField.getText();

        if (ae.getSource() == register_button2) {
            RegistrationController registrationController = new RegistrationController();
            registrationController.callCreateDatabase();
            registrationController.helpSetCurrUsername(username_value);
            try
            {
                Integer.parseInt(age_value);
                if (registrationController.callIsValidRegistration(
                        username_value,
                        name_value,
                        Integer.valueOf(age_value),
                        pronouns_value,
                        country_value,
                        province_value,
                        city_value,
                        gender_value,
                        sexuality_value,
                        interest_value,
                        pass_value)) {
                    new ViewProfilePage(username_value);
                } else {
                    new RegistrationErrorPage();
                }
            }
            catch (NumberFormatException ex)
            {
                new RegistrationErrorPage();
            }
        }
        else if (ae.getSource() == back_button) {
            new LoginPage();
            frame.dispose();
        }
    }
}

