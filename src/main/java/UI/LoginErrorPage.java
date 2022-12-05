package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** A UI class for Login feature when the login input is invalid.
 * */
public class LoginErrorPage extends JFrame implements ActionListener {

    // === Class Variables ===

    // Frame
    JFrame frame;

    // Label
    JLabel error_label;

    // Button
    JButton ok_button;

    /** Constructor function that builds the LoginError page.
     * */
    public LoginErrorPage() {
        frame = new JFrame();

        error_label = new JLabel();
        error_label.setText("Enter valid username and password!");
        error_label.setHorizontalAlignment(SwingConstants.CENTER);
        error_label.setBounds(70,75,250,40);
        error_label.setFocusable(false);

        ok_button = new JButton("Ok");
        ok_button.setBounds(70,150,250,40);
        ok_button.setFocusable(false);
        ok_button.addActionListener(this);

        // Set layout for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        Color LIGHT_YELLOW = new Color(255, 200, 100, 200);
        frame.getContentPane().setBackground(LIGHT_YELLOW);

        // Add elements to the frame
        frame.add(error_label);
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

