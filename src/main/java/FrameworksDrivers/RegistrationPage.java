package FrameworksDrivers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class RegistrationPage extends JFrame implements ActionListener{

    JButton register_button2;
    JPanel new_panel;
    JLabel username_label, name_label, age_label, pronouns_label, country_label, province_label, city_label,
            gender_label, sexuality_label, interest_label, pass_label;
    final JTextField username_textField, name_textField, age_textField, pronouns_textField, country_textField,
            province_textField, city_textField, gender_textField, sexuality_textField, interest_textField, pass_textField;

    public RegistrationPage() {
        username_label = new JLabel();
        username_label.setText("Username:");
        username_textField = new JTextField(50);

        name_label = new JLabel();
        name_label.setText("Full name:");
        name_textField = new JTextField(50);

        age_label = new JLabel();
        age_label.setText("Age:");
        age_textField = new JTextField(50);

        pronouns_label = new JLabel();
        pronouns_label.setText("Pronouns:");
        pronouns_textField = new JTextField(50);

        country_label = new JLabel();
        country_label.setText("Country:");
        country_textField = new JTextField(50);

        province_label = new JLabel();
        province_label.setText("Province:");
        province_textField = new JTextField(50);

        city_label = new JLabel();
        city_label.setText("City:");
        city_textField = new JTextField(50);

        gender_label = new JLabel();
        gender_label.setText("Gender:");
        gender_textField = new JTextField(50);

        sexuality_label = new JLabel();
        sexuality_label.setText("Sexuality:");
        sexuality_textField = new JTextField(50);

        interest_label = new JLabel();
        interest_label.setText("Interest:");
        interest_textField = new JTextField(50);

        pass_label = new JLabel();
        pass_label.setText("Password:");
        pass_textField = new JTextField(50);

        // Create register button
        register_button2 = new JButton("Register new account");

        // Create panel to put elements
        new_panel = new JPanel(new GridLayout(12, 2));
        new_panel.add(username_label);
        new_panel.add(username_textField);
        new_panel.add(name_label);
        new_panel.add(name_textField);
        new_panel.add(age_label);
        new_panel.add(age_textField);
        new_panel.add(pronouns_label);
        new_panel.add(pronouns_textField);
        new_panel.add(country_label);
        new_panel.add(country_textField);
        new_panel.add(province_label);
        new_panel.add(province_textField);
        new_panel.add(city_label);
        new_panel.add(city_textField);
        new_panel.add(gender_label);
        new_panel.add(gender_textField);
        new_panel.add(sexuality_label);
        new_panel.add(sexuality_textField);
        new_panel.add(interest_label);
        new_panel.add(interest_textField);
        new_panel.add(pass_label);
        new_panel.add(pass_textField);
        new_panel.add(register_button2);

        // Set border to panel
        add(new_panel, BorderLayout.CENTER);

        // Perform action on button click
        register_button2.addActionListener(this);
        setTitle("REGISTRATION FORM");
    }

    public void actionPerformed(ActionEvent ae) {
        String username_value = username_textField.getText();
//        String name_value = name_textField.getText();
//        String age_value = age_textField.getText();
//        String pronouns_value = pronouns_textField.getText();
//        String country_value = country_textField.getText();
//        String province_value = province_textField.getText();
//        String city_value = city_textField.getText();
//        String gender_value = gender_textField.getText();
//        String sexuality_value = sexuality_textField.getText();
//        String interest_value = interest_textField.getText();
//        String pass_value = pass_textField.getText();

        if (username_value == "lovina") {
            System.out.println("Welcome to Aphrodite");
        }
    }
}
