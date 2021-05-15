package doppio.event;

import java.util.LinkedList;

public class NewUserTypeEvent {
    private String userTypeName;
    private int ownerId;
    private LinkedList<Integer> userIds;

    public NewUserTypeEvent(String userTypeName, int ownerId, LinkedList<Integer> userIds) {
        this.userTypeName = userTypeName;
        this.ownerId = ownerId;
        this.userIds = userIds;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public LinkedList<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(LinkedList<Integer> userIds) {
        this.userIds = userIds;
    }
}
