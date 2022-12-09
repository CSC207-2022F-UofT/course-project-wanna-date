package use_case.message;
public class ChatBoxOD {
    boolean isMutual;

    public ChatBoxOD(boolean isMutual){
        this.isMutual = isMutual;
    }

    public boolean isMutual() {
        return isMutual;
    }
}
