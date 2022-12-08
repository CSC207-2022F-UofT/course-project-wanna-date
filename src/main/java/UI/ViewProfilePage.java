package UI;

import entities.MessageFactory;
import entities.MessageFormat;
import frameworksDrivers.MessageFileUser;
import interfaceAdapters.*;
import useCase.ReceiveMessageOB;
import useCase.SendMessage;
import useCase.SendMessageIB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

/** A UI class for ViewProfile feature.
 * */
public class ViewProfilePage extends JFrame implements ActionListener, ViewProfileInterface {

    // === Class Variables ===

    // Frame
    JFrame frame;

    // Labels
    JLabel usernameLabel, nameLabel, ageLabel, pronounsLabel, countryLabel, provinceLabel, cityLabel,
            genderLabel, sexualityLabel, interestLabel, passLabel, title;

    // Buttons
    JButton recommendButton, searchButton, messageButton, historyButton, logoutButton;

    // String
    String username,
            usernameValue, nameValue, ageValue, pronounsValue, countryValue, provinceValue, cityValue,
            genderValue, sexualityValue, interestValue, passValue;

    public MessageDSGateway gateway = new MessageFileUser("./messages.csv");
    public ReceiveMessageOB messagePresenter = new SendMessagePresenter();
    public MessageFactory messageFactory = new MessageFormat();
    public SendMessageIB interact = new SendMessage(gateway, messagePresenter, messageFactory);
    public SendMessageController sendMessageController = new SendMessageController(interact);

    /** Constructor function that sets username instance variable
     * */
    public ViewProfilePage(String username) throws IOException {
        this.username = username;
    }

    /** Function that implements retrieveInfo function from ViewProfileInterface interface. This function sets the
     * instance variables declared in order for them to be used in buildPage function.
     *
     * @param info  represents an ArrayList of String of user's variables to display
     * */
    @Override
    public void retrieveInfo(ArrayList<String> info) {
        usernameValue = info.get(0);
        nameValue = info.get(1);
        ageValue = info.get(2);
        pronounsValue = info.get(3);
        countryValue = info.get(4);
        provinceValue = info.get(5);
        cityValue = info.get(6);
        genderValue = info.get(7);
        sexualityValue = info.get(8);
        interestValue = info.get(9);
        passValue = info.get(10);
    }

    /** Function that builds the ViewProfile page.
     * */
    public void buildPage() {
        ViewProfileController viewProfileController = new ViewProfileController();
        viewProfileController.callSearchInfo(this.username, this);

        frame = new JFrame();

        // Set labels of user information to display
        title = new JLabel();
        title.setText("Your APHRODITE Profile");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0, 50, 1000, 40);
        title.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));
        title.setFocusable(false);


        usernameLabel = new JLabel();
        usernameLabel.setText("Username: " + usernameValue);
        usernameLabel.setBounds(200,125,200,40);
        usernameLabel.setFocusable(false);


        nameLabel = new JLabel();
        nameLabel.setText("Full name: " + nameValue);
        nameLabel.setBounds(200,175,200,40);
        nameLabel.setFocusable(false);


        ageLabel = new JLabel();
        ageLabel.setText("Age: " + ageValue);
        ageLabel.setBounds(200,225,200,40);
        ageLabel.setFocusable(false);


        pronounsLabel = new JLabel();
        pronounsLabel.setText("Pronouns: " + pronounsValue);
        pronounsLabel.setBounds(200,275,200,40);
        pronounsLabel.setFocusable(false);

        countryLabel = new JLabel();
        countryLabel.setText("Country: " + countryValue);
        countryLabel.setBounds(200,325,200,40);
        countryLabel.setFocusable(false);

        provinceLabel = new JLabel();
        provinceLabel.setText("Province: " + provinceValue);
        provinceLabel.setBounds(200,375,200,40);
        provinceLabel.setFocusable(false);


        cityLabel = new JLabel();
        cityLabel.setText("City: " + cityValue);
        cityLabel.setBounds(200,425,200,40);
        cityLabel.setFocusable(false);


        genderLabel = new JLabel();
        genderLabel.setText("Gender: " + genderValue);
        genderLabel.setBounds(200,475,200,40);
        genderLabel.setFocusable(false);


        sexualityLabel = new JLabel();
        sexualityLabel.setText("Sexuality: " + sexualityValue);
        sexualityLabel.setBounds(200,525,200,40);
        sexualityLabel.setFocusable(false);


        interestLabel = new JLabel();
        interestLabel.setText("Interest: " + interestValue);
        interestLabel.setBounds(200,575,200,40);
        interestLabel.setFocusable(false);


        passLabel = new JLabel();
        passLabel.setText("Password: " + passValue);
        passLabel.setBounds(200,625,200,40);
        passLabel.setFocusable(false);


        // Set buttons for different functionality
        recommendButton = new JButton("Recommendation");
        recommendButton.setBounds(125,700,150,40);
        recommendButton.setFocusable(false);
        recommendButton.addActionListener(this);

        searchButton = new JButton("Search Users");
        searchButton.setBounds(275,700,150,40);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);

        messageButton = new JButton("Message");
        messageButton.setBounds(425,700,150,40);
        messageButton.setFocusable(false);
        messageButton.addActionListener(this);

        historyButton = new JButton("History");
        historyButton.setBounds(575,700,150,40);
        historyButton.setFocusable(false);
        historyButton.addActionListener(this);

        logoutButton = new JButton("Log out");
        logoutButton.setBounds(725,700,150,40);
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(this);

        // Add elements to the frame
        frame.add(title);

        frame.add(usernameLabel);
        frame.add(nameLabel);
        frame.add(ageLabel);
        frame.add(pronounsLabel);
        frame.add(countryLabel);
        frame.add(provinceLabel);
        frame.add(cityLabel);
        frame.add(genderLabel);
        frame.add(sexualityLabel);
        frame.add(interestLabel);
        frame.add(passLabel);

        frame.add(recommendButton);
        frame.add(searchButton);
        frame.add(messageButton);
        frame.add(historyButton);
        frame.add(logoutButton);

        // Set layout for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        Color LIGHT_PINK = new Color(255, 175, 175, 150);
        frame.getContentPane().setBackground(LIGHT_PINK);
    }

    /** Function that implements actionPerformed function from ActionListener interface.
     * Contains the code for actions to the Recommendation, Search, Message, and Logout buttons.
     * */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == recommendButton) {
//            new RecBtnManager();
        } else if (ae.getSource() == searchButton) {
            new SearchBox("Initiate SearchBox");
            new FilterMenu("Initiate FilterMenu");
        } else if (ae.getSource() == messageButton) {
            String name = nameLabel.getText().substring(11);
            String username = usernameLabel.getText().substring(10);
            try {
                new MessageUI(name, sendMessageController.getLikedUsers(username));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (ae.getSource() == historyButton) {
            new UserHistoryUI(username);
        } else if (ae.getSource() == logoutButton) {
            // Create LogoutController
            LogoutController logoutController = new LogoutController();
            try {
                logoutController.helpWriteDatabase();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            new LoginPage();
            frame.dispose();
        }
    }
}
