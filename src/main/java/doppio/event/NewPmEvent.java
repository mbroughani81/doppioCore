package doppio.event;

public class NewPmEvent {

    int userId;
    int chatId;
    String Text;

    public NewPmEvent(int userId, int chatId, String text) {
        this.userId = userId;
        this.chatId = chatId;
        Text = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
