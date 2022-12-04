package interfaceAdapters;

import entities.UserAccount;
import useCase.*;

public class ChatBoxPresenter implements ChatBoxOB {
    @Override
    public ChatBoxOD prepareChatBox(ChatBoxOD output) {
        return output;
    }
}