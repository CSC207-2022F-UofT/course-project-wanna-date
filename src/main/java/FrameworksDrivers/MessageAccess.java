package FrameworksDrivers;

import java.io.*;

public class MessageAccess {
    public MessageAccess() {
        // location of file
        String filepath = "/C:/csc207/programming exercises/course-project-wanna-date/message.csv";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));

            while((line = br.readLine()) != null){
                String[] messages = line.split(",");
            }
        }

        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
