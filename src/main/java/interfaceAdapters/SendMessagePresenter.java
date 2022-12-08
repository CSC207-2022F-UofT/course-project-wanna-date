package interfaceAdapters;

import useCase.ReceiveMessageOB;
import useCase.ReceiveMessageOD;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The presenter outputs the time that the message was delivered.
 */
public class SendMessagePresenter implements ReceiveMessageOB {
    @Override
    public ReceiveMessageOD saveMessage(ReceiveMessageOD output){
        return output;
    }
}
