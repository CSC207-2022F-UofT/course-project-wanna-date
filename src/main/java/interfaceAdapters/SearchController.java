package interfaceAdapters;

import useCase.Search;
import useCase.SearchFilterOutputBoundary;
import useCase.SearchInputBoundary;

public class SearchController {
    public String toSearch;
    public SearchInputBoundary key;

    public SearchController(){
        this.toSearch = "";
        this.key = new Search();

    }

    public SearchInputBoundary getKey(){
        return this.key;
    }


    /**
     * Set class variable toSearch (input from user)
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
