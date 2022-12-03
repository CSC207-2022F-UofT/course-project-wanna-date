package useCase;

import entities.UserAccount;

public interface GenerateUserHistoryInputBoundary {

    UserAccount userTest1 = new UserAccount("johnd", "John Doe", 20, "her", "USA",
            "ILL", "CHI", "M", "H","Watching", "123");
    UserAccount userTest2 = new UserAccount("JSmith", "Jessica Smith", 20, "her", "CAN",
            "ON", "TOR", "F", "G","Music", "124");
    UserAccount userTest3 = new UserAccount("janed", "Jane Doe", 18, "her", "CAN",
            "ON", "TOR", "F", "H","Music", "124");
    UserAccount userTest4 = new UserAccount("jenndoe", "Jennifer Doe", 18, "her", "CAN",
            "ON", "OTT", "F", "H","Watching", "124");

    default String getCurrentUserStats(UserAccount user, String stat) {
        /**
        CurrUserManager currUserManager = CurrUserManager.getCurrUserManager();
        UserAccount account = currUserManager.getCurrUser();
         */

         userTest1.setLikedUsers(userTest2);
         userTest1.setLikedByUsers(userTest3);

        return stat;
    }
}
