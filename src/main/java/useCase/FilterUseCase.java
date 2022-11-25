package useCase;

public class FilterUseCase implements FilterInputBoundary{
    public SearchFilterOutputBoundary presenter = null;


    /**
     * used in controller to set the present to present the result.
     */
    public void setPresenter(SearchFilterOutputBoundary presenter){
        this.presenter = presenter;
    }

    /**
     * apply the filter base on which type of filter it is.
     */
    @Override
    public void apply(FilterType type) {
        // the result after filter
        type.filter();
        this.presenter.showResult();

    }
}
