package UseCase;

import Entities.UserAccount;

public class SexFilterMaleType implements FilterType {
    @Override
    public UserAccount[] filter() {

        return new UserAccount[0];
    }
}
