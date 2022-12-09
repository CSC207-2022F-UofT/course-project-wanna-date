package use_case.message;

/**
 * A class that checks whether the sender is liked by the person receiving the text.
 */

public class OpenChatbox implements ChatBoxIB {
    final UserManager likes;
    final ChatBoxOB chatPresenter;

    public OpenChatbox(UserManager likes, ChatBoxOB chatPresenter){
        this.likes = likes;
        this.chatPresenter = chatPresenter;
    }

    @Override
    public ChatBoxOD mutualUsers(SendMessageID messageInput){
        // check if users are mutually liked
        ChatBoxOD messageOutput = new ChatBoxOD(likes.getLikedByUsernames().contains(messageInput.getSendingUser()));
        return chatPresenter.prepareChatBox(messageOutput);
    }
}

