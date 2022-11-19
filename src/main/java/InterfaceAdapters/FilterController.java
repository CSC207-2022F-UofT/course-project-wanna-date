package InterfaceAdapters;

import UseCase.FilterType;
import UseCase.FilterUseCase;
import UseCase.FilterInputBoundary;
import UseCase.SearchFilterOutputBoundary;

public class FilterController {
    public FilterType filterType;
    public FilterInputBoundary filter;


    public FilterController(){
        this.filter = new FilterUseCase();
    }

    // for the different type in UI, set different types of filter
    public void setFilter(FilterType type){
        this.filterType = type;

    }


   // perform filter base on specific filter type with the help of input boundary.
    public void performFilter(){
        this.filter.apply(this.filterType);
        SearchFilterOutputBoundary presenter = new SearchFilterPresenter();
        this.filter.setPresenter(presenter);


    }

}
