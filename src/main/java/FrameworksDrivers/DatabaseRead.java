package FrameworksDrivers;

import Entities.UserDatabase;
import Entities.UserAccount;
import UseCase.DatabaseManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DatabaseRead {

    public static void main(String[] args)
    {
        String line = "";
        String splitBy = ",";
        try
        {
        //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("Database.csv"));
            br.readLine();
            UserDatabase database = new UserDatabase();
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] user = line.split(splitBy);    // use comma as separator
                for (int i = 0; i < user.length; i ++) {
                    user[i] = user[i].replace("\"", "");
                }
                System.out.println("User 1 [Name=" + user[0] + ", Age=" + user[1] + ", Pronouns=" + user[2] + ", Gender=" + user[3] + ", Sexuality= " + user[4] + ", Interest= " + user[5] + ", Password:" + user[6] + "]");
                UserAccount curr = new UserAccount( user[0], user[1], Integer.valueOf(user[2]), user[3], user[4],
                                                    user[5], user[6], user[7], user[8], user[9], user[10]);
                DatabaseManager dm = new DatabaseManager();
                if (dm.save_user_account(database, user[0], curr)) {
//                    System.out.println(dm.retrieve_user_account(user[0]).get_full_name() == "Jungkook");
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
