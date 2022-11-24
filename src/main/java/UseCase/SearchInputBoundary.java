package UseCase;

public interface SearchInputBoundary {

    // search method implemented by Search class
    void search(String name);
    void setPresenter(SearchFilterOutputBoundary presenter);

}
