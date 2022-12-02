package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginErrorPage extends JFrame implements ActionListener {

    JFrame frame;
    JButton ok_button;
    JLabel error_label;

    public LoginErrorPage() {
        frame = new JFrame();

        error_label = new JLabel();
        error_label.setText("Enter valid username and password");
        error_label.setHorizontalAlignment(SwingConstants.CENTER);
        error_label.setBounds(70,30,250,40);
        error_label.setFocusable(false);

        ok_button = new JButton("Ok");
        ok_button.setBounds(70,100,250,40);
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
        frame.add(ok_button);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ok_button) {
            frame.dispose();
        }
    }

}

