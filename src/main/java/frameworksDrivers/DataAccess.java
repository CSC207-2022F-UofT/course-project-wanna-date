package frameworksDrivers;

import useCase.DatabaseManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class DataAccess {

    public DataAccess() {}

    public void readCSV() {

        String line;
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/frameworksDrivers/database.csv"));

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
