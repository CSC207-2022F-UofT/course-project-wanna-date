package UI;

import entities.UserAccount;
import interfaceAdapters.SearchController;
import interfaceAdapters.SearchFilterPresenter;
import useCase.CurrUserManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class SearchBox extends JFrame {
    private final JTextField textField = new JTextField(20);
    private final JButton searchB = new JButton("Search");
    private final JPanel panel = new JPanel();
    private final JLabel label = new JLabel();
    public UserAccount[] results = {};
    public SearchFilterPresenter presenter = new SearchFilterPresenter(this);
    public SearchController searchController = new SearchController(presenter);

    public static void main(String[] args) {
        new SearchBox("Search For Username");
    }


    // create search box that take string as input
    public SearchBox(String title) throws HeadlessException {
        //set up the frame
        super(title);
        setSize(600, 600);
        setResizable(true);
        addComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // create 5 result buttons and store them in a list.
        ArrayList<JButton> userList = new ArrayList<>();
        JButton user1 = new JButton("");
        JButton user2 = new JButton("");
        JButton user3 = new JButton("");
        JButton user4 = new JButton("");
        JButton user5 = new JButton("");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        // add the buttons to the frame, and set their location.
        add(user1);
        add(user2);
        add(user3);
        add(user4);
        add(user5);

        user1.setBounds(100,200,350,30);
        user2.setBounds(200,200,350,30);
        user3.setBounds(100,300,350,30);
        user4.setBounds(200,300,350,30);
        user5.setBounds(150,400,350,30);



        //set the buttons to invisible and disabled
        for (JButton users : userList){
            users.setVisible(false);
            users.setEnabled(false);
        }


        //perform search when button is clicked
        searchB.addActionListener(e -> {
            label.setText("Searching for " + textField.getText());
            //perform the search base on user input
            searchController.setToSearch(textField.getText());
            searchController.performSearch();
            //presenter the result and call the view profile UI when button is clicked
            for (int i = 0; i <= results.length - 1; i++){
                if (i <= 4){
                    JButton currButton = userList.get(i);
                    UserAccount targetUser = results[i];
                    currButton.setText(targetUser.getUsername());
                    currButton.setVisible(true);
                    currButton.setEnabled(true);
                    currButton.addActionListener(e1 -> {
                        CurrUserManager currUserManager = CurrUserManager.getCurrUserManager();
                        UserAccount account = currUserManager.getCurrUser();
                        UserLikeBlock profile = new UserLikeBlock(account, targetUser);
                        profile.functionToCall();
                    });
                }
            }
        });

        //perform search when enter key is pressed
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    label.setText("Searching for " + textField.getText());
                    //perform the search base on user input
                    searchController.setToSearch(textField.getText());
                    searchController.performSearch();
                    //presenter the result and call the view profile UI when button is clicked
                    for (int i = 0; i <= results.length - 1; i++){
                        if (i <= 4){
                            JButton currButton = userList.get(i);
                            UserAccount targetUser = results[i];
                            currButton.setText(targetUser.getUsername());
                            currButton.setVisible(true);
                            currButton.setEnabled(true);
                            currButton.addActionListener(e1 -> {
                                CurrUserManager currUserManager = CurrUserManager.getCurrUserManager();
                                UserAccount account = currUserManager.getCurrUser();
                                UserLikeBlock profile = new UserLikeBlock(account, targetUser);
                                profile.functionToCall();
                            });
                        }
                    }
                }
            }
        });
    }

    private void addComponents() {
        panel.add(textField);
        panel.add(searchB);
        panel.add(label);
        add(panel);
    }

    // allows the presenter to set results to presenter
    public void setResult (UserAccount[] results){ this.results = results;}

}

