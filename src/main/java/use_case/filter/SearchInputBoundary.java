package use_case.filter;

import entities.account.UserAccount;

public interface SearchInputBoundary {

    // search method implemented by Search class
    UserAccount[] search(String name);
    

}
