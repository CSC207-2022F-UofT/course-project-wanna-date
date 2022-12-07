package useCase;

import entities.UserAccount;

public interface SearchFilterOutputBoundary {

    // method implemented by SearchFilterPresenter class
    void showResult(UserAccount[] users);

}
