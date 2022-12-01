package InterfaceAdapters;

import useCase.ReceiveMessageOB;
import useCase.ReceiveMessageOD;
import useCase.SendMessageDS;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SendMessagePresenter implements ReceiveMessageOB {

    @Override
    public ReceiveMessageOD saveMessage(ReceiveMessageOD output){
        LocalDateTime deliveredTime = LocalDateTime.parse(output.getSentAt());
        output.setSentAt(deliveredTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return output;
    }
}
