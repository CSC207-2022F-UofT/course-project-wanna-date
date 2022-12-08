package useCase;

import entities.UserAccount;

public interface GenerateUserHistoryInputBoundary {

    default void getCurrentUserStats() {
        /**
         CurrUserManager currUserManager = CurrUserManager.getCurrUserManager();
         UserAccount account = currUserManager.getCurrUser();
         */

        UserAccount userTest1 = new UserAccount("johnd", "John Doe", 20, "her", "USA",
                "ILL", "CHI", "M", "H","Watching", "123");
        UserAccount userTest2 = new UserAccount("JSmith", "Jessica Smith", 20, "her", "CAN",
                "ON", "TOR", "F", "G","Music", "124");
        UserAccount userTest3 = new UserAccount("janed", "Jane Doe", 18, "her", "CAN",
                "ON", "TOR", "F", "H","Music", "124");
        UserAccount userTest4 = new UserAccount("jenndoe", "Jennifer Doe", 18, "her", "CAN",
                "ON", "OTT", "F", "H","Watching", "124");

        //user1.setLikedUsers(user2);
        // user1.setLikedUsers(user3);
    }


}

