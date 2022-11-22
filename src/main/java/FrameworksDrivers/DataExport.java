package FrameworksDrivers;

import UseCase.DatabaseManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataExport {

    public void write_csv() throws IOException {
        DataExportInterface dataExportInterface = DatabaseManager.getDatabaseManager();
        Object[][] data_to_csv = dataExportInterface.writeDatabase();

        File csvFile = new File("database.csv");
        FileWriter fileWriter = new FileWriter(csvFile);

        for (Object[] data: data_to_csv) {
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
