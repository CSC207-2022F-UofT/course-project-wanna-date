package frameworksDrivers;

import useCase.DatabaseManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

/** A frameworksDrivers class that reads an outer CSV File and create the Database in the application.
 * */
public class DataAccess {

    public DataAccess() {}

    /** Function that reads an outer CSV File and convert the information to the form of String[]
     * which will be transferred to a function in DatabaseManager class to create the Database in the application.
     * */
    public void readCSV() {

        String line;
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("/Users/adelinemonica.l/Documents/Uni stuff" +
                    "/3rd Year/CSC207/course-project-wanna-date/src/main/java/frameworksDrivers/database.csv"));
            br.readLine();
            String[] data_from_csv = {};
            while ((line = br.readLine()) != null)
            {
                data_from_csv = Arrays.copyOf(data_from_csv, data_from_csv.length + 1);
                data_from_csv[data_from_csv.length - 1] = line;
            }
            databaseManager.createDatabase(data_from_csv);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
