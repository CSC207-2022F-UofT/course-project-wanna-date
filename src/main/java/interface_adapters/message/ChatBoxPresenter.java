package interface_adapters.message;

import use_case.*;

public class ChatBoxPresenter implements ChatBoxOB {
    @Override
    public ChatBoxOD prepareChatBox(ChatBoxOD output) {
        return output;
    }
}