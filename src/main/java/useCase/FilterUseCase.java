package useCase;

import entities.UserAccount;
import interfaceAdapters.testPresenter;

public class FilterUseCase implements FilterInputBoundary{
    public SearchFilterOutputBoundary presenter;

    public FilterUseCase(SearchFilterOutputBoundary presenter){this.presenter = presenter;};

    public FilterUseCase(){this.presenter = new testPresenter();}

    /**
     * apply the filter base on which type of filter it is.

     * @param type the filter type that the user clicked
     */
    @Override
    public UserAccount[] apply(FilterType type) {
        // the result after filter
        UserAccount[] results = type.filter();
        this.presenter.showResult(results);
        return results;

    }
}
