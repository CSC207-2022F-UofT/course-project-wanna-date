package FrameworksDrivers;

import javax.swing.*;

public class RegistrationPageDemo {
    public static void main(String arg[]) {
        try{
            RegistrationPage page = new RegistrationPage();
            page.setSize(1000,500);
            page.setVisible(true);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
