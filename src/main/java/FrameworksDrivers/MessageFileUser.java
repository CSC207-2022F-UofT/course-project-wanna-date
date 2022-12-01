package FrameworksDrivers;

import InterfaceAdapters.MessageDSGateway;
import useCase.SendMessageDS;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MessageFileUser implements MessageDSGateway{
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, SendMessageDS> messages = new HashMap<>();

    public MessageFileUser(String filePath) throws IOException{
        csvFile = new File(filePath);

        headers.put("sender", 0);
        headers.put("receiver", 1);
        headers.put("message", 2);
        headers.put("time", 3);

        if (csvFile.length() == 0){
            save();
        }

        else {
            // read file
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // skip header

            String row;
            while ((row = br.readLine()) != null) {
                String[] col = row.split(",");
                String sender = String.valueOf(col[headers.get("sender")]);
                String receiver = String.valueOf(col[headers.get("receiver")]);
                String message = String.valueOf(col[headers.get("message")]);
                String time = String.valueOf(col[headers.get("time")]);
                LocalDateTime ldt = LocalDateTime.parse(time);
                SendMessageDS messageDS = new SendMessageDS(sender, receiver, message, ldt);
                messages.put(sender, messageDS);
            }

            br.close();
        }
    }

    @Override
    public void save(SendMessageDS dataSet) {
        messages.put(dataSet.getSender(), dataSet);
        this.save();
    }

    private void save() {
        // write to file
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(csvFile));
            bw.write(String.join(",", headers.keySet()));
            bw.newLine();

            for (SendMessageDS text : messages.values()) {
                // changed this to format (originally formatted)
                String line = "%s,%s,%s,%s".format(
                        text.getSender(), text.getReceiver(), text.getMessage(), text.getTime());
                bw.write(line);
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
