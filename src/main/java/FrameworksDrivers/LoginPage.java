package FrameworksDrivers;

import InterfaceAdapters.LoginController;
import InterfaceAdapters.RegistrationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class LoginPage extends JFrame implements ActionListener {

    JButton login_button, register_button1;
    JPanel new_panel;
    JLabel username_label, pass_label;
    final JTextField textField1, textField2;

    public LoginPage() {

        // Create label for username
        username_label = new JLabel();
        username_label.setText("Username:");

        // Create text field to get username from user
        textField1 = new JTextField(15);

        // Create label for password
        pass_label = new JLabel();
        pass_label.setText("Password:");

        // Create text field to get username from user
        textField2 = new JTextField(15);

        // Create login button
        login_button = new JButton("LOGIN");

        // Create register button
        register_button1 = new JButton("REGISTER");

        // Create panel to put elements
        new_panel = new JPanel(new GridLayout(3, 1));
        new_panel.add(username_label);
        new_panel.add(textField1);
        new_panel.add(pass_label);
        new_panel.add(textField2);
        new_panel.add(login_button);
        new_panel.add(register_button1);

        // Set border to panel
        add(new_panel, BorderLayout.CENTER);

        // Perform action on button click
        login_button.addActionListener(this);
        register_button1.addActionListener(this);
        setTitle("LOGIN FORM");
    }

    public void actionPerformed(ActionEvent ae) {
        String username_value = textField1.getText();
        String pass_value = textField2.getText();

        if (ae.getSource() == login_button) {
            LoginController loginController = new LoginController();
            if (loginController.call_valid_login(username_value, pass_value)) {
                NewPage page = new NewPage();
                page.setVisible(true);
                JLabel welcome_label = new JLabel("Welcome: " + username_value);
                page.getContentPane().add(welcome_label);
            } else {
                System.out.println("Please enter again");
            }
        } else if (ae.getSource() == register_button1) {
            RegistrationController registrationController = new RegistrationController();
        }
    }

}
