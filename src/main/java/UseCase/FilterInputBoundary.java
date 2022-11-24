package UseCase;

import Entities.UserAccount;

public interface FilterInputBoundary {

    UserAccount[] apply(FilterType type);

    void setPresenter(SearchFilterOutputBoundary presenter);

}
