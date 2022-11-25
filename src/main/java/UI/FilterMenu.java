package UI;

import Entities.UserAccount;
import InterfaceAdapters.FilterController;
import InterfaceAdapters.SearchFilterPresenter;

import UseCase.*;

import javax.swing.*;
import java.util.Objects;

public class FilterMenu {
    public String getFilter;
    public String[] options = {"Sex Male", "Sex Female", "Location"};
    public FilterType type;
    public FilterController filterController = new FilterController();
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
        choice.filterController.getFilter().setPresenter(new SearchFilterPresenter(choice));

    }


}

