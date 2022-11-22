package UseCase;

import Entities.UserAccount;

public class LocationFilterType implements FilterType {
    @Override
    public UserAccount[] filter() {

        return new UserAccount[0];
    }
}
