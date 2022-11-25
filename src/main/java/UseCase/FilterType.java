package UseCase;

import Entities.UserAccount;

public interface FilterType {

    // method implement by different type of filter
    UserAccount[] filter();

}
