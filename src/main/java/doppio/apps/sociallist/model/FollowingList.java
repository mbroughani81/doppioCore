package doppio.apps.sociallist.model;

import java.util.LinkedList;

public class FollowingList {
    int id;

    private LinkedList<Integer> list;

    public FollowingList() {
        list = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Integer> getList() {
        return list;
    }

    public void setList(LinkedList<Integer> list) {
        this.list = list;
    }
}
