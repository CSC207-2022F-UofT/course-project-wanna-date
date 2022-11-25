package UI;
import interfaceAdapters.FilterController;
import useCase.*;

import javax.swing.*;
import java.util.Objects;

public class FilterMenu {
    public String getFilter;
    public String[] options = {"Sex Male", "Sex Female", "Location", "Sexuality"};
    public FilterType type;

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
        FilterController filterController = new FilterController();
        if (Objects.equals(getFilter, options[0])){
            setType(new SexFilterMaleType());
        } if (Objects.equals(getFilter, options[1])){
            setType(new SexFilterFemaleType());
        }if (Objects.equals(getFilter, options[2])){
            setType(new LocationFilterType());
        }else {
            setType(new SexualityFilterType());
        }
        filterController.setFilter(this.type);
        filterController.performFilter();
    }


    public static void main(String[] args) {
        FilterMenu choice = new FilterMenu();
        choice.applyFilter();
    }
}

