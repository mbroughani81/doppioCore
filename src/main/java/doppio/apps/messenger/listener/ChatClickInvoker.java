package doppio.apps.messenger.listener;

public interface PrivateChatClickInvoker {
    void setPrivateChatClickListener(PrivateChatClickListener listener);
    void checkPrivateClickListener(int privateChatId);
}
