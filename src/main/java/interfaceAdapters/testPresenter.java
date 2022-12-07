package interfaceAdapters;

import entities.UserAccount;
import useCase.SearchFilterOutputBoundary;

public class testPresenter implements SearchFilterOutputBoundary {
    @Override
    public void showResult(UserAccount[] users) {}
}
