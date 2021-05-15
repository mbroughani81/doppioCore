package doppio.event;

import java.util.LinkedList;

public class NewGroupChatEvent {

    String groupName;
    int ownerId;
    LinkedList<Integer> memberIds;

    public NewGroupChatEvent(String groupName, int ownerId, LinkedList<Integer> memberIds) {
        this.groupName = groupName;
        this.ownerId = ownerId;
        this.memberIds = memberIds;
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

    public LinkedList<Integer> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(LinkedList<Integer> memberIds) {
        this.memberIds = memberIds;
    }
}
