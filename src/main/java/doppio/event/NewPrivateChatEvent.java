package doppio.event;

public class NewPrivateChatEvent {
    int user1id;
    int user2id;

    public NewPrivateChatEvent(int user1id, int user2id) {
        this.user1id = user1id;
        this.user2id = user2id;
    }

    public int getUser1id() {
        return user1id;
    }

    public void setUser1id(int user1id) {
        this.user1id = user1id;
    }

    public int getUser2id() {
        return user2id;
    }

    public void setUser2id(int user2id) {
        this.user2id = user2id;
    }
}
