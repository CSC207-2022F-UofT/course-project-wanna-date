package frameworks_drivers.message;

import interface_adapters.message.MessageDSGateway;
import use_case.message.SendMessageDS;
import use_case.message.SendMessageID;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * A class that creates a file and saves messages to said file.
 * It also allows you to read through this file.
 */

public class MessageFileUser implements MessageDSGateway{
    private final File csvFile;

    // the columns in the csv file
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<LocalDateTime, SendMessageDS> messages = new HashMap<>();

    public MessageFileUser(String filePath) throws IOException{
        // file name
        csvFile = new File(filePath);

        // each of the variables stored within the data set
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
            while ((row = br.readLine()) != null) { // read line by line
                String[] col = row.split(",");
                String sender = String.valueOf(col[headers.get("sender")]);
                String receiver = String.valueOf(col[headers.get("receiver")]);
                String message = String.valueOf(col[headers.get("message")]);
                String time = String.valueOf(col[headers.get("time")]);
                LocalDateTime ldt = LocalDateTime.parse(time);
                SendMessageDS messageDS = new SendMessageDS(sender, receiver, message, ldt);
                messages.put(ldt, messageDS);
            }

            br.close();
        }
    }

    @Override
    public void save(SendMessageDS dataSet) {
        messages.put(dataSet.getTime(), dataSet);
        this.save();
    }

    private void save() {
        // write file
        BufferedWriter bw;
        try
        {
            bw = new BufferedWriter(new FileWriter(csvFile));
            bw.write(String.join(",", headers.keySet()));
            bw.newLine();

            for (SendMessageDS text : messages.values()) {
                String line = String.format("%s,%s,%s,%s",
                        text.getSender(), text.getReceiver(), text.getMessage(), text.getTime());
                bw.write(line);
                bw.newLine();
            }

            bw.close();

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<LocalDateTime, SendMessageDS> sortByTime(Map<LocalDateTime, SendMessageDS> map)
    {
        TreeMap<LocalDateTime, SendMessageDS> sorted = new TreeMap<>();
        sorted.putAll(map);
        return sorted;
    }

    public Map<LocalDateTime, SendMessageDS> pastMessages(SendMessageDS input){
        Map<LocalDateTime, SendMessageDS> userMessages = new HashMap<>();
        for (SendMessageDS row : messages.values()){
            if (row.getSender().equals(input.getSender()) || row.getSender().equals(input.getReceiver())){
                if(row.getReceiver().equals(input.getReceiver()) || row.getReceiver().equals(input.getSender())){
                    userMessages.put(row.getTime(), row);
                }
            }
        }

        Map<LocalDateTime, SendMessageDS> lastFiveMessages = new HashMap<>();

        // get the oldest message in lastFiveMessages so far (first message)
        List<LocalDateTime> keys = new ArrayList<LocalDateTime>(userMessages.keySet());
        LocalDateTime oldestMessage = keys.get(0);

        if (userMessages.size() <= 5){
            return userMessages;
        }

        for (LocalDateTime textInfo : userMessages.keySet()){
            if (lastFiveMessages.size() < 5){
                lastFiveMessages.put(textInfo, userMessages.get(textInfo));
            }

            if (textInfo.isAfter(oldestMessage)){
                lastFiveMessages.remove(oldestMessage);
                lastFiveMessages.put(textInfo, userMessages.get(textInfo));
            }

            for (LocalDateTime time : lastFiveMessages.keySet()){
                if (time.isBefore(oldestMessage)){
                    oldestMessage = textInfo;
                }
            }
        }

        // sort messages
        return sortByTime(lastFiveMessages);
    }
}

