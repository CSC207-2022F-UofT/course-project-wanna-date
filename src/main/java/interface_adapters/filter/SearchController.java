package interface_adapters.filter;

import use_case.filter.Search;
import use_case.filter.SearchFilterOutputBoundary;
import use_case.filter.SearchInputBoundary;

public class SearchController {
    public String toSearch;
    public SearchInputBoundary key;

    // Constructor that set the presenter for use case
    public SearchController(SearchFilterOutputBoundary presenter){
        this.toSearch = "";
        this.key = new Search(presenter);

    }

    /**
     * Set class variable toSearch (input from user)
     * @param toSearch Input from the user
     */

    public void setToSearch(String toSearch) {
        this.toSearch = toSearch;
    }

    /**
     * Call use case to perform search for the specific input
     * Use the input boundary to help
     */

    public void performSearch(){

        this.key.search(toSearch);

    }

}

