package use_case.filter;

import entities.account.UserAccount;

// implemented by filter use case.
public interface FilterInputBoundary {

    UserAccount[] apply(FilterType type);


}
