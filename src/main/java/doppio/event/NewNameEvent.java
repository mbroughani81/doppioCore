package doppio.event;

import doppio.apps.authentication.model.User;

public class NewNameEvent {
    User user;
    String newName;

    public NewNameEvent(User user, String newName) {
        this.user = user;
        this.newName = newName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
