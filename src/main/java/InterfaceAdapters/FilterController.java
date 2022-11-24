package InterfaceAdapters;

import UseCase.FilterType;
import UseCase.FilterUseCase;
import UseCase.FilterInputBoundary;

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

    public FilterInputBoundary getFilter(){
        return this.filter;
    }


   // perform filter base on specific filter type with the help of input boundary.
    public void performFilter(){
        this.filter.apply(this.filterType);



    }

}
