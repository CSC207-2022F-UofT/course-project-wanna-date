package UI;

import Entities.UserAccount;
import Entities.UserDatabase;
import UseCase.DatabaseManager;

public class ViewProfilePageDemo {

    public static void main(String[] args) {
        UserAccount acc1 = new UserAccount("lov123", "Lovina", 20, "She/Her",
                "Canada", "ON", "Toronto", "F", "H", "Watching", "CSC207");
        UserAccount acc2 = new UserAccount("95liners", "Taehyung", 20, "He/Him",
                "Canada", "ON", "Toronto", "M", "H", "Music", "BTS7");

        UserDatabase database = new UserDatabase();
        DatabaseManager dm = new DatabaseManager();

        // Note from Arist: had to change the below so that it would run
        dm.saveNewUser(acc1.get_username(), acc1);
        dm.saveNewUser(acc2.get_username(), acc2);
//        dm.saveNewUser(database, acc1.get_username(), acc1);
//        dm.saveNewUser(database, acc2.get_username(), acc2);

        ViewProfilePage viewProfilePage = new ViewProfilePage(database, acc1.get_username());
//        view view_demo = new view();
    }
}
