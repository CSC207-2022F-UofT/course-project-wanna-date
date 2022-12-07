package useCase;

import entities.UserAccount;

public interface FilterType {

    // method implement by different type of filter
    UserAccount[] filter();

}