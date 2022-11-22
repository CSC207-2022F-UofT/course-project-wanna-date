package UI;

import Entities.UserDatabase;
import InterfaceAdapters.LoginController;
import InterfaceAdapters.RegistrationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {

//    JButton login_button, register_button1;
//    JPanel panel;
//    JLabel username_label, pass_label;
//    final JTextField textField1, textField2;
//
//    public LoginPage() {
//
//        frame = new JFrame();
//
//        // Create labels & text fields
//        username_label = new JLabel();
//        username_label.setText("Username:");
//
//        textField1 = new JTextField(15);
//
//
//        pass_label = new JLabel();
//        pass_label.setText("Password:");
//
//        textField2 = new JTextField(15);
//
//
//        // Create buttons
//        login_button = new JButton("LOGIN");
//        login_button.addActionListener(this);
//        register_button1 = new JButton("REGISTER");
//        register_button1.addActionListener(this);
//
//        panel = new JPanel(new GridLayout(3, 3));
//        panel.add(username_label);
//        panel.add(textField1);
//        add(panel, BorderLayout.CENTER);
//
//        frame.add(panel);
//        setTitle("LOGIN FORM");
//    }

    JButton login_button, register_button1;
    JFrame frame;
    JLabel username_label, pass_label;
    final JTextField textField1, textField2;

    public LoginPage() {

        frame = new JFrame();

        // Create labels & text fields
        username_label = new JLabel();
        username_label.setText("Username:");
        username_label.setBounds(200,200,200,40);
        username_label.setFocusable(false);
        textField1 = new JTextField(15);
        textField1.setBounds(400,200,200,40);

        pass_label = new JLabel();
        pass_label.setText("Password:");
        pass_label.setBounds(200,300,200,40);
        pass_label.setFocusable(false);
        textField2 = new JTextField(15);
        textField2.setBounds(400,300,200,40);

        // Create buttons
        login_button = new JButton("LOGIN");
        login_button.setBounds(200,500,200,40);
        login_button.setFocusable(false);
        login_button.addActionListener(this);

        register_button1 = new JButton("REGISTER");
        register_button1.setBounds(400,500,200,40);
        register_button1.setFocusable(false);
        register_button1.addActionListener(this);

        // Create panel to put elements
        frame.add(username_label);
        frame.add(textField1);
        frame.add(pass_label);
        frame.add(textField2);
        frame.add(login_button);
        frame.add(register_button1);

        // Set layout for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setVisible(true);

        setTitle("LOGIN FORM");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String username_value = textField1.getText();
        String pass_value = textField2.getText();

        if (ae.getSource() == login_button) {
            LoginController loginController = new LoginController();
            // TODO: figure out where database goes!
            // Temporary solution --> Create Main UI/Class and then create Database there,
            // then call the UIs with database as input
            loginController.callCreateDatabase();
            UserDatabase database1 = loginController.getDatabase();
            ViewProfilePage viewProfilePage1 = new ViewProfilePage(database1, username_value);
//            if (loginController.call_valid_login(username_value, pass_value)) {
//                ViewProfilePage viewProfilePage = new ViewProfilePage(database, username_value);
//                frame.dispose();
//            } else {
//                System.out.println("Please enter again");
//            }
        } else if (ae.getSource() == register_button1) {
            RegistrationPage registrationPage = new RegistrationPage();
            frame.dispose();
        }
    }

}


