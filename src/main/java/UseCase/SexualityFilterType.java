package UseCase;

import Entities.UserAccount;

public class SexualityFilterType implements FilterType {
    @Override
    public UserAccount[] filter() {

        return new UserAccount[0];
    }
}
