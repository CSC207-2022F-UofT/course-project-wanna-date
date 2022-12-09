package UI.account;

import interface_adapters.account.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/** A UI class for Login feature.
 * */
public class LoginPage extends JFrame implements ActionListener {

    // === Class variables ===

    // Frame
    JFrame frame;

    // Labels
    JLabel username_label, pass_label, title;

    // Text fields
    final JTextField username_textField;
    JPasswordField pass_textField;

    // Buttons
    JButton login_button, register_button1;

    // Checkbox
    JCheckBox showPassword;

    /** Constructor function that builds the Login page.
     * */
    public LoginPage() {

        frame = new JFrame();

        // Create labels & text fields

        title = new JLabel();
        title.setText("Login to your APHRODITE account");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0,200,1000,45);
        title.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));
        title.setFocusable(false);

        username_label = new JLabel();
        username_label.setText("Username:");
        username_label.setBounds(300,300,200,40);
        username_label.setFocusable(false);
        username_textField = new JTextField(15);
        username_textField.setBounds(500,300,200,40);

        pass_label = new JLabel();
        pass_label.setText("Password:");
        pass_label.setBounds(300,375,200,40);
        pass_label.setFocusable(false);
        pass_textField = new JPasswordField();
        pass_textField.setBounds(500,375,200,40);

        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(500,425,200,30);
        showPassword.addActionListener(this);
        showPassword.setBackground(Color.WHITE);

        // Create buttons
        login_button = new JButton("LOGIN");
        login_button.setBounds(300,500,200,40);
        login_button.setFocusable(false);
        login_button.addActionListener(this);

        register_button1 = new JButton("REGISTER");
        register_button1.setBounds(500,500,200,40);
        register_button1.setFocusable(false);
        register_button1.addActionListener(this);

        // Create panel to put elements
        frame.add(title);
        frame.add(username_label);
        frame.add(username_textField);
        frame.add(pass_label);
        frame.add(pass_textField);
        frame.add(showPassword);

        frame.add(login_button);
        frame.add(register_button1);

        // Set layout for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        Color LIGHT_PINK = new Color(255, 175, 175, 50);
        frame.getContentPane().setBackground(LIGHT_PINK);

        setTitle("LOGIN FORM");
    }

    /** Function that implements actionPerformed function from ActionListener interface.
     * Contains the code for actions to the Login and Register buttons.
     * */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String username_value = username_textField.getText();
        String pass_value = new String(pass_textField.getPassword());

        if (ae.getSource() == login_button) {
            LoginController loginController = new LoginController();
            loginController.helpSetCurrUsername(username_value);
            loginController.callCreateDatabase();
            if (loginController.callValidLogin(username_value, pass_value)) {
                ViewProfilePage viewProfilePage;
                try {
                    viewProfilePage = new ViewProfilePage(username_value);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                viewProfilePage.buildPage();
                frame.dispose();
            } else {
                new LoginErrorPage();
            }
        } else if (ae.getSource() == register_button1) {
            new RegistrationPage();
            frame.dispose();
        } else if (ae.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                pass_textField.setEchoChar((char) 0);
            } else {
                pass_textField.setEchoChar('*');
            }
        }
    }

}