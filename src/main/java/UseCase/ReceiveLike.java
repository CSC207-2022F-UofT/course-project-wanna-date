package UseCase;
import Entities.UserAccount;

import java.util.ArrayList;

public class ReceiveLike implements ReceiveLikeInputBoundary{


    @Override
    //Main method to add update UserAccount liked_user and liked_by_user
    public boolean like(UserAccount user1, UserAccount user2){
        ArrayList<String> interests1 = new ArrayList<>();
        interests1.add("watch");
        ArrayList<String>interest2 = new ArrayList<>();
        interest2.add("Eat");
        UserAccount user3 = new UserAccount("AL", "AML", 20, "her", "CAN",
                "ON", "TOR", 'F', 'H',interests1, "123", "num");
        UserAccount user4 = new UserAccount("EL", "EML", 20, "her", "CAN",
                "ON", "TOR", 'F', 'H',interest2, "124", "num");
        user1.set_liked_users(user4);
        user2.set_liked_by_users(user3);
        RetrieveLike like1 = new RetrieveLike();
        like1.connector();
        return true;
    }


}
