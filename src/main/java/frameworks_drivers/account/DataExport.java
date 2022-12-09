package frameworks_drivers.account;

import use_case.account.DataExportInterface;
import use_case.account.DatabaseManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** A frameworksDrivers class that writes CSV File from the Database in application.
 * */
public class DataExport {

    /** Function that writes information from Database in the form of Object[][] to an outer CSV File
     * */
    public void writeCSV() throws IOException {
        DataExportInterface dataExportInterface = DatabaseManager.getDatabaseManager();
        Object[][] data_to_csv = dataExportInterface.writeDatabase();

        File csvFile = new File("src/main/java/frameworks_drivers/database.csv");
        FileWriter fileWriter = new FileWriter(csvFile);

        for (Object[] data: data_to_csv) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                line.append("\"");
                line.append(data[i]);
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
