package UI;

import entities.UserAccount;
import interfaceAdapters.FilterController;
import interfaceAdapters.SearchFilterPresenter;
import useCase.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class FilterMenu extends JFrame{
    public UserAccount[] results = {};
    public String[] options = {"Sex Male", "Sex Female", "Location"};
    public SearchFilterPresenter presenter = new SearchFilterPresenter(this);
    public FilterController filterController = new FilterController(presenter);
    public FilterMenu(String title){
        // set up the frame
        super(title);
        setSize(600, 600);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // creating drop down menu.
        JComboBox<String> jComboBox = new JComboBox<>(options);
        jComboBox.setBounds(80, 50, 140, 20);

        JButton jButton = new JButton("Done");
        jButton.setBounds(100, 100, 90, 20);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(90, 100, 400, 100);

        add(jButton);
        add(jComboBox);
        add(jLabel);

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

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFilter = "You selected " + jComboBox.getItemAt(jComboBox.getSelectedIndex());
                jLabel.setText(selectedFilter);
                // apply user's selection here
                applyFilter(jComboBox.getItemAt(jComboBox.getSelectedIndex()));
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
                            profile.functionToCall();
                        });
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        new FilterMenu("Choose the filter");
    }

    // allows the presenter to set results to presenter
    public void setResult (UserAccount[] results){ this.results = results;}

    // distinguish user's choice and perform the filter
    public void applyFilter(String choice){
        if (Objects.equals(choice, options[0])){
            filterController.setFilter(new SexFilterMaleType());
        } if (Objects.equals(choice, options[1])){
            filterController.setFilter(new SexFilterFemaleType());
        }else {
            filterController.setFilter(new LocationFilterType());
        }
        filterController.performFilter();
    }

}

