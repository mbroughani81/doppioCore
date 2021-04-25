package doppio.apps.sociallist.model;

import doppio.apps.authentication.model.User;

import java.util.LinkedList;

public class FollowerList {
    private LinkedList<User> list;

    public FollowerList() {
        list = new LinkedList<>();
    }

    public LinkedList<User> getList() {
        return list;
    }

    public void setList(LinkedList<User> list) {
        this.list = list;
    }
}
