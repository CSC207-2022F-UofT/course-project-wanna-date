package FrameworksDrivers;

import Entities.UserAccount;
import Entities.UserDatabase;
import UseCase.DatabaseManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DatabaseWrite {

//    static UserDatabase database_to_write;
//
//    public DatabaseWrite(UserDatabase database_to_write) {
//        this.database_to_write = database_to_write;
//    }

    public static void main(String[] args) throws IOException {
//        Object[][] userProfile = {
//                {"Username", "Name", "Age", "Pronouns", "Country", "Province", "City", "Gender", "Sexuality", "Interests", "Password"},
//                {"international playboy", "Jungkook", 25, "He/Him", "Korea", "Busan", "Myeongdeong", "M", "H", "travelling", "busan123"},
//                {"deep voice","Taehyung", 27, "He/Him", "Korea", "Daegu", "Gangnam", "M", "H", "photography", "daegu456"}
//        };

        Object[][] userProfile = {{}};
        DatabaseManager dm = new DatabaseManager();
        UserDatabase database = new UserDatabase();
//        HashMap<String, UserAccount> database = database_to_write.get_data();
        String[] usernames = dm.list_username(database);
        for (int i = 0; i < dm.number_user(database); i++) {
            UserAccount user = dm.retrieve_user_account(database, usernames[i]);
            Object[] userProfileEach = new Object[]{user.get_username(),
                                                    user.get_full_name(),
                                                    user.get_age(),
                                                    user.get_pronouns(),
                                                    user.get_location().get("Country"),
                                                    user.get_location().get("Province"),
                                                    user.get_location().get("City"),
                                                    user.get_gender(),
                                                    user.get_sexuality(),
                                                    user.get_interests(),
                                                    user.get_password()};
            userProfile = Arrays.copyOf(userProfile, userProfile.length + 1);
            userProfile[userProfile.length - 1] = userProfileEach;
        }


        File csvFile = new File("database.csv");
        FileWriter fileWriter = new FileWriter(csvFile);

        //write header line here if you need.

        for (Object[] data : userProfile) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                line.append("\"");
                line.append(data[i]);
//                line.append(data[i].replaceAll("\"","\"\""));
                line.append("\"");
                if (i != data.length - 1) {
                    line.append(',');
                }
            }
            line.append("\n");
            fileWriter.write(line.toString());
        }
        fileWriter.close();
    }
}
