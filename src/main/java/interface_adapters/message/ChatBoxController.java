package interface_adapters.message;

import use_case.*;

/**
 * A controller that calls on ChatBoxIB and thus interacts with OpenChatbox
 * to check if users are mutually liked.
 */

public class ChatBoxController {
    final ChatBoxIB chatInput;

    public ChatBoxController(ChatBoxIB chatInput) {
        this.chatInput = chatInput;
    }

    ChatBoxOD mutualUsers(SendMessageID messageInput) {
        return chatInput.mutualUsers(messageInput);
    }
}
