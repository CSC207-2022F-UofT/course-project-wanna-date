package UseCase;


public class Search implements SearchInputBoundary {
    public SearchFilterOutputBoundary presenter = null;


    /**
     * used in controller to set the present to present the result.
     */
    public void setPresenter(SearchFilterOutputBoundary presenter){
        this.presenter = presenter;
    }

    /**
     * Return a list of profiles whose username contains the given key word
     */

    @Override
    public void search(String name) {

        // do the search here and give a result
        // show result
        this.presenter.showResult();

    }


}
