package doppio.apps.messenger.model;

import java.util.LinkedList;

public class GroupChat {
    private int id;
    private String title;
    private LinkedList<Integer> participantsId;

    public GroupChat(String title, LinkedList<Integer> participantsId) {
        this.title = title;
        this.participantsId = participantsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList<Integer> getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(LinkedList<Integer> participantsId) {
        this.participantsId = participantsId;
    }
}
