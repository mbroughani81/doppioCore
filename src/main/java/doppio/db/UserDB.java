package doppio.db;

import doppio.apps.authentication.model.User;

import java.util.LinkedList;

public class UserDB implements DBSet<User> {
    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public LinkedList<User> all() {
        return null;
    }

    @Override
    public void add(User user) {
        System.out.println("user is added - add in userdb");
        int id = nextId();
        user.setId(id);
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public int nextId() {
        for (int i = 0; ; i++) {
            boolean isUsed = false;
            for (User user : all()) {
                if (user.getId() == i)
                    isUsed = true;
            }
            if (!isUsed)
                return i;
        }
    }
}
