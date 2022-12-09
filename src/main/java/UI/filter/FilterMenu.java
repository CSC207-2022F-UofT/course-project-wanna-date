package UI.filter;

import entities.UserAccount;
import interface_adapters.FilterController;
import interface_adapters.SearchFilterPresenter;
import use_case.CurrUserManager;
import use_case.DatabaseManager;
import use_case.LocationFilterType;
import use_case.SexFilterFemaleType;
import use_case.SexFilterMaleType;

import javax.swing.*;
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
        setSize(450, 500);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // creating drop down menu.
        JComboBox<String> jComboBox = new JComboBox<>(options);
        jComboBox.setBounds(150, 50, 140, 20);

        JButton jButton = new JButton("Done");
        jButton.setBounds(160, 100, 90, 20);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(130, 100, 400, 100);

        add(jButton);
        add(jComboBox);
        add(jLabel);

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
        add(user1);
        add(user2);
        add(user3);
        add(user4);
        add(user5);

        user1.setBounds(100,175,200,40);
        user2.setBounds(100,225,200,40);
        user3.setBounds(100,275,200,40);
        user4.setBounds(100,325,200,40);
        user5.setBounds(100,375,200,40);

        //set the buttons to invisible and disabled
        for (JButton users : userList){
            users.setVisible(false);
            users.setEnabled(false);
        }

        jButton.addActionListener(e -> {
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
                    });
                }
            }
        });

    }

    public static void main(String[] args) {
        DatabaseManager manager = DatabaseManager.getDatabaseManager();
        //sample database for testing
        String[] sample = {"Jiazi,Test 4,44,She/Her,trt,ON,CA,F,H,Others,44448888",
                "Jiaziismycat,Lovina,20,She/Her,trt,ON,CA,F,H,Music,12345678",
                "panda,Peter Panda,33,He/Him,trt,ON,CA,M,B,Exercise,12345678",
                "test1,Test 2,22,He/Him,null,null,null,M,G,Culinary,22222222"
        };
        manager.createDatabase(sample);
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
        }if (Objects.equals(choice, options[2])){
            filterController.setFilter(new LocationFilterType());
        }
        filterController.performFilter();
    }

}


