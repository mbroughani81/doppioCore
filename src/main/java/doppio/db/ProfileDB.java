package doppio.db;

import doppio.apps.authentication.model.Profile;
import doppio.apps.authentication.model.User;

import java.util.LinkedList;

public class ProfileDB implements DBSet<Profile> {
    @Override
    public Profile get(int id) {
        return null;
    }

    @Override
    public LinkedList<Profile> all() {
        return null;
    }

    @Override
    public void add(Profile profile) {
        System.out.println("profile is added - add in profiledb");
        int id = nextId();
        profile.setId(id);
    }

    @Override
    public void remove(Profile profile) {

    }

    @Override
    public void update(Profile profile) {

    }

    @Override
    public int nextId() {
        for (int i = 0; ; i++) {
            boolean isUsed = false;
            for (Profile profile : all()) {
                if (profile.getId() == i)
                    isUsed = true;
            }
            if (!isUsed)
                return i;
        }
    }
}
