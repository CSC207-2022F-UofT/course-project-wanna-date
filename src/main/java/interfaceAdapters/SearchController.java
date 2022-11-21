package interfaceAdapters;

import useCase.SearchInputBoundary;

public class SearchController {
    String toSearch;

    /**
     * Set class variable toSearch (input from user)
     * @param toSearch
     */

    public void setToSearch(String toSearch) {
        this.toSearch = toSearch;
    }

    /**
     * Call use case to perform search for the specific input
     * Use the input boundary to help
     * @param key
     */

    public void performSearch(SearchInputBoundary key){

        key.search(toSearch);

    }

}
