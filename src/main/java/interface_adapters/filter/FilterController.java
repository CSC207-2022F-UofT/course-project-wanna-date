package interface_adapters.filter;

import use_case.FilterType;
import use_case.FilterUseCase;
import use_case.FilterInputBoundary;

public class FilterController {
    public FilterType filterType;
    public FilterInputBoundary filter;

    // constructor method that allow UI to pass in presenter.
    public FilterController(SearchFilterPresenter presenter){
        this.filter = new FilterUseCase(presenter);
    }

    // for the different type in UI, set different types of filter
    public void setFilter(FilterType type){
        this.filterType = type;
    }


    // perform filter base on specific filter type with the help of input boundary.
    public void performFilter(){
        this.filter.apply(this.filterType);
    }
}
