package useCase;

import entities.UserAccount;

public interface FilterInputBoundary {

    UserAccount[] apply(FilterType type);

    void setPresenter(SearchFilterOutputBoundary presenter);

}
