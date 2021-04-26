package doppio.apps.messenger.model;

import java.util.LinkedList;

public class MessageData {
    private int id;

    private LinkedList<Integer> privateChatsId;
    private LinkedList<Integer> groupChatsId;

    public MessageData(LinkedList<Integer> privateChatsId, LinkedList<Integer> groupChatsId) {
        this.privateChatsId = privateChatsId;
        this.groupChatsId = groupChatsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Integer> getPrivateChatsId() {
        return privateChatsId;
    }

    public void setPrivateChatsId(LinkedList<Integer> privateChatsId) {
        this.privateChatsId = privateChatsId;
    }

    public LinkedList<Integer> getGroupChatsId() {
        return groupChatsId;
    }

    public void setGroupChatsId(LinkedList<Integer> groupChatsId) {
        this.groupChatsId = groupChatsId;
    }
}
