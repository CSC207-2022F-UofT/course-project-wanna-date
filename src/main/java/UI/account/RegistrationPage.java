package UI.account;

import interface_adapters.RegistrationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/** A UI class for Registration feature.
 * */
public class RegistrationPage extends JFrame implements ActionListener{

    // === Class Variables ===

    // Frame
    JFrame frame;

    // Labels
    JLabel  title,
            username_label, name_label, age_label, pronouns_label, country_label, province_label, city_label,
            gender_label, sexuality_label, interest_label, pass_label,
            username_rule, ageRule, pass_rule;

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

        title = new JLabel();
        title.setText("Register new account to APHRODITE");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0,50,1000,45);
        title.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));
        title.setFocusable(false);

        username_label = new JLabel();
        username_label.setText("Username:");
        username_label.setBounds(200,125,200,40);
        username_label.setFocusable(false);
        username_textField = new JTextField(50);
        username_textField.setBounds(300,125,200,40);
        username_rule = new JLabel();
        username_rule.setText("Should be non-empty username");
        username_rule.setBounds(500,125,200,40);
        username_rule.setFocusable(false);
        username_rule.setFont(new Font(username_rule.getFont().getName(),Font.ITALIC,username_rule.getFont().getSize()));

        name_label = new JLabel();
        name_label.setText("Full name:");
        name_label.setBounds(200,175,200,40);
        name_label.setFocusable(false);
        name_textField = new JTextField(50);
        name_textField.setBounds(300,175,200,40);

        age_label = new JLabel();
        age_label.setText("Age:");
        age_label.setBounds(200,225,200,40);
        age_label.setFocusable(false);
        age_textField = new JTextField(50);
        age_textField.setBounds(300,225,200,40);
        ageRule = new JLabel();
        ageRule.setText("Should be a number");
        ageRule.setBounds(500, 225,200,40);
        ageRule.setFocusable(false);
        ageRule.setFont(new Font(ageRule.getFont().getName(),Font.ITALIC,ageRule.getFont().getSize()));

        pronouns_label = new JLabel();
        pronouns_label.setText("Pronouns:");
        pronouns_label.setBounds(200,275,200,40);
        pronouns_label.setFocusable(false);
        String[] list_pronouns = {"He/Him", "She/Her", "They/Them"};
        pronouns_comboBox = new JComboBox<>(list_pronouns);
        pronouns_comboBox.setBounds(300,275,200,40);
        pronouns_comboBox.setBackground(Color.WHITE);

        country_label = new JLabel();
        country_label.setText("Country:");
        country_label.setBounds(200,325,200,40);
        country_label.setFocusable(false);
        country_textField = new JTextField(50);
        country_textField.setBounds(300,325,200,40);

        province_label = new JLabel();
        province_label.setText("Province:");
        province_label.setBounds(200,375,200,40);
        province_label.setFocusable(false);
        province_textField = new JTextField(50);
        province_textField.setBounds(300,375,200,40);

        city_label = new JLabel();
        city_label.setText("City:");
        city_label.setBounds(200,425,200,40);
        city_label.setFocusable(false);
        city_textField = new JTextField(50);
        city_textField.setBounds(300,425,200,40);

        gender_label = new JLabel();
        gender_label.setText("Gender:");
        gender_label.setBounds(200,475,200,40);
        gender_label.setFocusable(false);
        String[] list_gender = {"M: Male", "F: Female", "N: Non-binary"};
        gender_comboBox = new JComboBox<>(list_gender);
        gender_comboBox.setBounds(300,475,200,40);
        gender_comboBox.setBackground(Color.WHITE);

        sexuality_label = new JLabel();
        sexuality_label.setText("Sexuality:");
        sexuality_label.setBounds(200,525,200,40);
        sexuality_label.setFocusable(false);
        String[] list_sexuality = {"G: Gay", "L: Lesbian", "H: Heterosexual", "B: Binary"};
        sexuality_comboBox = new JComboBox<>(list_sexuality);
        sexuality_comboBox.setBounds(300,525,200,40);
        sexuality_comboBox.setBackground(Color.WHITE);

        interest_label = new JLabel();
        interest_label.setText("Interest:");
        interest_label.setBounds(200,575,200,40);
        interest_label.setFocusable(false);
        String[] list_interest = {"Culinary", "Sports", "Watching", "Photography", "Travelling",
                "Fashion", "Music", "Exercise", "Games", "Socializing", "Others"};
        interest_comboBox = new JComboBox<>(list_interest);
        interest_comboBox.setBounds(300,575,200,40);
        interest_comboBox.setBackground(Color.WHITE);

        pass_label = new JLabel();
        pass_label.setText("Password:");
        pass_label.setBounds(200,625,200,40);
        pass_label.setFocusable(false);
        pass_textField = new JTextField(50);
        pass_textField.setBounds(300,625,200,40);
        pass_rule = new JLabel();
        pass_rule.setText("Should be at least 8 characters, no white space");
        pass_rule.setBounds(500,625,300,40);
        pass_rule.setFont(new Font(pass_rule.getFont().getName(),Font.ITALIC,pass_rule.getFont().getSize()));

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
        frame.add(title);

        frame.add(username_label);
        frame.add(username_textField);
        frame.add(username_rule);
        frame.add(name_label);
        frame.add(name_textField);
        frame.add(age_label);
        frame.add(age_textField);
        frame.add(ageRule);
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
        frame.add(pass_rule);

        frame.add(register_button2);
        frame.add(back_button);

        // Set layout for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        Color LIGHT_PINK = new Color(255, 175, 175, 100);
        frame.getContentPane().setBackground(LIGHT_PINK);

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
                        Integer.parseInt(age_value),
                        pronouns_value,
                        country_value,
                        province_value,
                        city_value,
                        gender_value,
                        sexuality_value,
                        interest_value,
                        pass_value)) {
                    ViewProfilePage viewProfilePage = new ViewProfilePage(username_value);
                    viewProfilePage.buildPage();
                    frame.dispose();
                } else {
                    new RegistrationErrorPage();
                }
            }
            catch (NumberFormatException ex)
            {
                new RegistrationErrorPage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else if (ae.getSource() == back_button) {
            new LoginPage();
            frame.dispose();
        }
    }

}

