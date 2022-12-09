package UI.filter;

import entities.UserAccount;
import interface_adapters.SearchController;
import interface_adapters.SearchFilterPresenter;
import use_case.CurrUserManager;
import use_case.DatabaseManager;

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
        DatabaseManager manager = DatabaseManager.getDatabaseManager();
        //sample database for testing
        String[] sample = {"Jiazi,Test 4,44,She/Her,trt,ON,CA,F,H,Others,44448888",
                "Jiaziismycat,Lovina,20,She/Her,trt,ON,CA,F,H,Music,12345678",
                "panda,Peter Panda,33,He/Him,trt,ON,CA,M,B,Exercise,12345678",
                "test1,Test 2,22,He/Him,null,null,null,M,G,Culinary,22222222"
        };
        manager.createDatabase(sample);
        new SearchBox("Search For Username");
    }


    // create search box that take string as input
    public SearchBox(String title) throws HeadlessException {
        //set up the frame
        super(title);
        setSize(250, 300);
        setResizable(true);
        addComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // create 5 result buttons and store them in a list.
        ArrayList<JButton> userList = new ArrayList<>();
        JButton user1 = new JButton("1");
        JButton user2 = new JButton("2");
        JButton user3 = new JButton("3");
        JButton user4 = new JButton("4");
        JButton user5 = new JButton("5");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        // add the buttons to the frame, and set their location.
        panel.add(user1);
        panel.add(user2);
        panel.add(user3);
        panel.add(user4);
        panel.add(user5);


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
                        String account = currUserManager.getCurrUser().getUsername();
                        UserLikeBlock profile = new UserLikeBlock(account, targetUser.getUsername());
                        getContentPane().remove(panel);
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
                                String account = currUserManager.getCurrUser().getUsername();
                                UserLikeBlock profile = new UserLikeBlock(account, targetUser.getUsername());
                                getContentPane().remove(panel);
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

