package frameworksDrivers;

import entities.UserDatabase;
import useCase.DatabaseManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class DataAccess {

    public DataAccess() {}

    //TODO: don't forget to transfer the accounts liked/blocked as well!
    public UserDatabase read_csv() {

        String line = "";
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("database.csv"));
            br.readLine();
            String[] data_from_csv = {};
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                data_from_csv = Arrays.copyOf(data_from_csv, data_from_csv.length + 1);
                data_from_csv[data_from_csv.length - 1] = line;
            }
            return databaseManager.createDatabase(data_from_csv);

        }
        catch (IOException e)
        {
            e.printStackTrace();
            String[] empty_array = {};
            UserDatabase empty_database = new UserDatabase();   // QS: Can we create an empty UserDatabase for the sake of the function?
            return empty_database;
        }
    }
}
