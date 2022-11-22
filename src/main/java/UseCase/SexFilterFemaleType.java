package UseCase;

import Entities.UserAccount;

public class SexFilterFemaleType implements FilterType {
    @Override
    public UserAccount[] filter() {

        return new UserAccount[0];
    }
}
