package interface_adapters.filter;

import entities.account.UserAccount;
import UI.filter.FilterMenu;
import UI.filter.SearchBox;
import use_case.filter.SearchFilterOutputBoundary;

public class SearchFilterPresenter implements SearchFilterOutputBoundary {
    public SearchBox box = null;
    public FilterMenu menu = null;

    // constructor called by the SearchBox UI
    public SearchFilterPresenter(SearchBox view){
        this.box = view;
    }

    // override constructor that it can be called by the filter menu.
    public SearchFilterPresenter(FilterMenu menu){
        this.menu = menu;
    }

    // Present the results that generated from use case
    @Override
    public void showResult(UserAccount[] results) {
        if (this.box != null) {
            box.setResult(results);
        } if (this.menu != null) {
            menu.setResult(results);
        }
    }
}
