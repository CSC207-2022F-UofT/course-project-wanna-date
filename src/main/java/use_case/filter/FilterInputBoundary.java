package use_case.filter;

import entities.UserAccount;

// implemented by filter use case.
public interface FilterInputBoundary {

    UserAccount[] apply(FilterType type);


}
