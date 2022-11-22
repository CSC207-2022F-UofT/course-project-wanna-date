package UseCase;


import Entities.UserAccount;

public class Search implements SearchInputBoundary {

    public SearchFilterOutputBoundary presenter = null;


    /**
     * used in controller to set the presenter to present the result.
     * @param  presenter Presenter to present the result.
     */
    public void setPresenter(SearchFilterOutputBoundary presenter){
        this.presenter = presenter;
    }

    /**
     * Return a list of profiles whose username contains the given key word.
     * @param name Input from user to search.
     */

    @Override
    public void search(String name) {

        // do the search here and give a result
        UserAccount[] results = {};
        // show result
        this.presenter.showResult(results);

    }


}
