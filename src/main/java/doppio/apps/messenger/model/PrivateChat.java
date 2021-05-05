package doppio.apps.messenger.model;

public class PrivateChat {
    int id;

    int user1id;
    int user2id;



    public PrivateChat(int user1id, int user2id) {
        this.id = -1;

        this.user1id = user1id;
        this.user2id = user2id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
