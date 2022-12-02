package UI;

import entities.UserAccount;
import interfaceAdapters.FilterController;
import interfaceAdapters.SearchFilterPresenter;
import useCase.FilterType;
import useCase.LocationFilterType;
import useCase.SexFilterFemaleType;
import useCase.SexFilterMaleType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class FilterMenu extends JFrame{
    public UserAccount[] results = {};
    public FilterType type;
    public String[] options = {"Sex Male", "Sex Female", "Location"};
    public SearchFilterPresenter presenter = new SearchFilterPresenter(this);
    public FilterController filterController = new FilterController(presenter);
    public FilterMenu(String title){
        super(title);
        setSize(600, 600);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


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


        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

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
                applyFilter(jComboBox.getItemAt(jComboBox.getSelectedIndex()));
                for (int i = 0; i <= results.length - 1; i++){
                    if (i <= 4){
                        JButton currButton = userList.get(i);
                        currButton.setText(results[i].getUsername());
                        currButton.setVisible(true);
                        currButton.setEnabled(true);
                        currButton.addActionListener(e1 -> {
                            CurrUserManager currUserManager = CurrUserManager.getCurrUserManager();
                            UserAccount account = currUserManager.getCurrUser();
                            UserLikeBlock profile = new UserLikeBlock(account, results[i]);
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
    public void setResult (UserAccount[] results){ this.results = results;}

    public void applyFilter(String choice){
        if (Objects.equals(choice, options[0])){
            setType(new SexFilterMaleType());
        } if (Objects.equals(choice, options[1])){
            setType(new SexFilterFemaleType());
        }else {
            setType(new LocationFilterType());
        }
        filterController.setFilter(this.type);
        filterController.performFilter();
    }

    public void setType(FilterType type) {
        this.type = type;
    }
}


/**
import entities.UserAccount;
import interfaceAdapters.FilterController;
import interfaceAdapters.SearchFilterPresenter;
import useCase.*;

import javax.swing.*;
import java.util.Objects;

public class FilterMenu {
    public String getFilter;
    public String[] options = {"Sex Male", "Sex Female", "Location"};
    public FilterType type;
    public SearchFilterPresenter presenter = new SearchFilterPresenter(this);
    public FilterController filterController = new FilterController(presenter);
    public UserAccount[] results = {};

    public FilterMenu(){

        this.getFilter = (String) JOptionPane.showInputDialog(
                null,
                "Which area are you interested in?",
                "Choose Filter",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
    }

    public void setType(FilterType type) {
        this.type = type;
    }

    public void applyFilter(){
        if (Objects.equals(getFilter, options[0])){
            setType(new SexFilterMaleType());
        } if (Objects.equals(getFilter, options[1])){
            setType(new SexFilterFemaleType());
        }else {
            setType(new LocationFilterType());
        }
        filterController.setFilter(this.type);
        filterController.performFilter();
    }

    public void setResult (UserAccount[] results){ this.results = results;}


    public static void main(String[] args) {
        FilterMenu choice = new FilterMenu();
        choice.applyFilter();

    }

}

