package FrameworksDrivers;


import javax.swing.*;
import java.io.*;
import Entities.MessageHistory;

public class MessageDatabase {

    static MessageHistory history;

    public static void main(String[] args)
    {
        String sender = history.getSendingUser();
        String receiver = history.getReceivingUser();
        String message = history.getMessage();
        String time = history.getFormattedMessageDateTime();
        String filepath = "messages.txt";

        saveMessages(sender, receiver, message, time, filepath);
    }

    public static void saveMessages(String sender, String receiver, String message, String time, String filepath) {
        try {
            FileWriter file = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(file);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(sender + "," + receiver + "," + message + "," + time + ", " + filepath);
            pw.flush();
            JOptionPane.showMessageDialog(null, "Message sent");
        }

        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Message error");
        }

    }
}
