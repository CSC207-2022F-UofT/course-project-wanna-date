package FrameworksDrivers;

import javax.swing.*;

public class LoginPageDemo {
    public static void main(String arg[]) {
        try {
            LoginPage page = new LoginPage();
            page.setSize(1000, 500);
            page.setVisible(true);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
