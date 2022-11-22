package UseCase;

import Entities.UserAccount;

public interface SearchFilterOutputBoundary {

    // method implemented by SearchFilterPresenter class
     void showResult(UserAccount[] users);

}
