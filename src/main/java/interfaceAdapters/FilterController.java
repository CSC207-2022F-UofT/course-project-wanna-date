package interfaceAdapters;

import useCase.FilterType;
import useCase.FilterUseCase;
import useCase.FilterInputBoundary;

public class FilterController {
    public FilterType filterType;
    public FilterInputBoundary filter;


    public FilterController(SearchFilterPresenter presenter){
        this.filter = new FilterUseCase(presenter);
    }

    // for the different type in UI, set different types of filter
    public void setFilter(FilterType type){
        this.filterType = type;
    }

    public FilterInputBoundary getFilter(){
        return this.filter;
    }


   // perform filter base on specific filter type with the help of input boundary.
    public void performFilter(){
        this.filter.apply(this.filterType);
    }

}
