package interface_adapters.filter;

import entities.UserAccount;
import use_case.SearchFilterOutputBoundary;

public class testPresenter implements SearchFilterOutputBoundary {
    @Override
    public void showResult(UserAccount[] users) {}
}
