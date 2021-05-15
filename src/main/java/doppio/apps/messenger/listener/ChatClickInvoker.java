package doppio.apps.messenger.listener;

public interface ChatClickInvoker {
    void setChatClickListener(ChatClickListener listener);
    void checkChatClickListener(int chatId);
}
