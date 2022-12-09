package interface_adapters.message;

import use_case.message.ReceiveMessageOB;
import use_case.message.ReceiveMessageOD;

/**
 * The presenter outputs the time that the message was delivered.
 */
public class SendMessagePresenter implements ReceiveMessageOB {
    @Override
    public ReceiveMessageOD saveMessage(ReceiveMessageOD output){
        return output;
    }
}
