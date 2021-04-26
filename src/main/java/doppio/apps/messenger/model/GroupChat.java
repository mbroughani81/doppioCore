package doppio.apps.messenger.model;

import java.util.LinkedList;

public class GroupChat {
    private int id;
    private String title;
    private LinkedList<Integer> participants;

    public GroupChat(String title, LinkedList<Integer> participants) {
        this.title = title;
        this.participants = participants;
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

    public LinkedList<Integer> getParticipants() {
        return participants;
    }

    public void setParticipants(LinkedList<Integer> participants) {
        this.participants = participants;
    }
}
