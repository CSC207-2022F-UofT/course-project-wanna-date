package use_case.filter;

import entities.account.UserAccount;

public interface FilterType {

    // method implement by different type of filter
    UserAccount[] filter();

}
