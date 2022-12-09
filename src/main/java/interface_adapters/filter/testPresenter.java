package interface_adapters.filter;

import entities.account.UserAccount;
import use_case.filter.SearchFilterOutputBoundary;

public class testPresenter implements SearchFilterOutputBoundary {
    @Override
    public void showResult(UserAccount[] users) {}
}
