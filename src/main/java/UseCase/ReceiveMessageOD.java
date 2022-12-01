package useCase;
public class ReceiveMessageOD {
    String sent;
    String delivered;

    public ReceiveMessageOD(String sent, String sentAt){
        this.sent = sent;
        this.delivered = sentAt;
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public String getSentAt() {
        return delivered;
    }

    public void setSentAt(String sentAt) {
        this.delivered= sentAt;
    }
}
