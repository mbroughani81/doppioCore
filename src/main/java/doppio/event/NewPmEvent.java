package doppio.event;

public class NewPmEvent {

    int userId;
    int privateChatId;
    String Text;

    public NewPmEvent(int userId, int privateChatId, String text) {
        this.userId = userId;
        this.privateChatId = privateChatId;
        Text = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrivateChatId() {
        return privateChatId;
    }

    public void setPrivateChatId(int privateChatId) {
        this.privateChatId = privateChatId;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
