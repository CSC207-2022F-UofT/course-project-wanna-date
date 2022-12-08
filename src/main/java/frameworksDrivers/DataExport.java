package frameworksDrivers;

import useCase.DataExportInterface;
import useCase.DatabaseManager;

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

        File csvFile = new File("/Users/adelinemonica.l/Documents/Uni stuff" +
                "/3rd Year/CSC207/course-project-wanna-date/src/main/java/frameworksDrivers/database.csv");
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
