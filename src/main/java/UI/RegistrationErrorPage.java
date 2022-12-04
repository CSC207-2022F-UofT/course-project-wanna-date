package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** A UI class for Registration feature when the registration input is invalid.
 * */
public class RegistrationErrorPage extends JFrame implements ActionListener {

    // === Class Variables ===

    // Frame
    JFrame frame;

    // Labels
    JLabel error_label, username_rule, password_rule;

    // Button
    JButton ok_button;

    /** Constructor function that builds the RegistrationError page.
     * */
    public RegistrationErrorPage() {
        frame = new JFrame();

        error_label = new JLabel();
        error_label.setText("Enter valid username and password combination!");
        error_label.setHorizontalAlignment(JLabel.CENTER);
        error_label.setBounds(0,50,400,15);
        error_label.setFocusable(false);

        username_rule = new JLabel();
        username_rule.setText("- Enter a non-empty username");
        username_rule.setHorizontalAlignment(JLabel.CENTER);
        username_rule.setBounds(0,85,400,15);
        username_rule.setFocusable(false);

        password_rule = new JLabel();
        password_rule.setText("- Enter at least 8 characters password");
        password_rule.setHorizontalAlignment(JLabel.CENTER);
        password_rule.setBounds(0,120,400,15);
        password_rule.setFocusable(false);

        ok_button = new JButton("Ok");
        ok_button.setBounds(70,175,250,40);
        ok_button.setFocusable(false);
        ok_button.addActionListener(this);

        // Set layout for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        // Add elements to the frame
        frame.add(error_label);
        frame.add(username_rule);
        frame.add(password_rule);
        frame.add(ok_button);
    }

    /** Function that implements actionPerformed function from ActionListener interface.
     * Contains the code for actions to the Ok button.
     * */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ok_button) {
            frame.dispose();
        }
    }
}
