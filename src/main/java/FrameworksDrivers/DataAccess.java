package FrameworksDrivers;

import UseCase.DataAccessInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class DataAccess implements DataAccessInterface {

    public DataAccess() {}

    public String[] read_csv() {

        String line = "";
        String splitBy = ",";
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("Database.csv"));
            br.readLine();
            String[] data_from_csv = {};
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                data_from_csv = Arrays.copyOf(data_from_csv, data_from_csv.length + 1);
                data_from_csv[data_from_csv.length - 1] = line;
            }
            return data_from_csv;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            String[] empty_array = {};
            return empty_array;
        }
    }

    public void write_csv(Object[][] data_to_csv) throws IOException {

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
