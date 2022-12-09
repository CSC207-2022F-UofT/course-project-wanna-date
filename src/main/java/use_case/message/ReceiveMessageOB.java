package use_case.message;

/**
 * An interface that is implemented by SendMessagePresenter.
 */

public interface ReceiveMessageOB {
    ReceiveMessageOD saveMessage(ReceiveMessageOD message);
}