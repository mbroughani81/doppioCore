package doppio.event;

import java.util.LinkedList;

public class NewGroupEvent {
    String groupName;
    int ownerId;
    LinkedList<Integer> userIds;

    public NewGroupEvent(String groupName, int ownerId, LinkedList<Integer> userIds) {
        this.groupName = groupName;
        this.ownerId = ownerId;
        this.userIds = userIds;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
