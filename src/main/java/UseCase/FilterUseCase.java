package UseCase;

import Entities.UserAccount;

public class FilterUseCase implements FilterInputBoundary{
    public SearchFilterOutputBoundary presenter = null;


    /**
     * used in controller to set the present to present the result.
     * @param  presenter Presenter to present the result.
     */
    public void setPresenter(SearchFilterOutputBoundary presenter){
        this.presenter = presenter;
    }

    /**
     * apply the filter base on which type of filter it is.
     * @param type the filter type that the user clicked
     */
    @Override
    public void apply(FilterType type) {
        // the result after filter
        UserAccount[] results = type.filter();
        this.presenter.showResult(results);

    }
}
