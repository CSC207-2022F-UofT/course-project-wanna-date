package UI;

import entities.UserAccount;
import interfaceAdapters.SearchController;
import interfaceAdapters.SearchFilterPresenter;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchBox extends JFrame {
    private final JTextField textField = new JTextField(20);
    private final JButton searchB = new JButton("Search");
    private final JPanel panel = new JPanel();
    private final JLabel label = new JLabel();
    public SearchController searchController = new SearchController();
    public UserAccount[] results = {};

    public static void main(String[] args) {
        SearchBox searchBox = new SearchBox("Search For Username");
        searchBox.searchController.getKey().setPresenter(new SearchFilterPresenter(searchBox));
    }

    // Note from Arist: I had to clean up some syntax here
//    public static void main(String[] args) {
//        new SearchBox("Search For Username");
//    }

    // create search box that take string as input
    public SearchBox(String title) throws HeadlessException {
        super(title);
        setSize(600, 600);
        setResizable(true);
        addComponents();
        setTable();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //perform search when button is clicked
        searchB.addActionListener(e -> {
            label.setText("Searching for " + textField.getText());
            searchController.setToSearch(textField.getText());
            searchController.performSearch();
        });

        //perform search when enter key is pressed
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    label.setText("Searching for " + textField.getText());
                    searchController.setToSearch(textField.getText());
                    searchController.performSearch();
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

    public void setResult (UserAccount[] results){ this.results = results;}

    private void setTable(){
        searchB.addActionListener(e -> {
            JTableButtonModel jTableButtonModel = new JTableButtonModel();
            jTableButtonModel.setRows(results);
            JTable table = new JTable(jTableButtonModel);
            TableCellRenderer tableRenderer = table.getDefaultRenderer(JButton.class);
            table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);
        });

    }

}

