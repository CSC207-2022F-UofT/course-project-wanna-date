package interfaceAdapters;

import useCase.Search;
import useCase.SearchFilterOutputBoundary;
import useCase.SearchInputBoundary;

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

