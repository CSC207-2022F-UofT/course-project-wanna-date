package useCase;

public interface FilterInputBoundary {

    void apply(FilterType type);

    void setPresenter(SearchFilterOutputBoundary presenter);

}
