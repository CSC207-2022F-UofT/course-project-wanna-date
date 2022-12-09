package use_case.filter;

import entities.account.UserAccount;

public interface SearchFilterOutputBoundary {

    // method implemented by SearchFilterPresenter class
     void showResult(UserAccount[] users);

}
