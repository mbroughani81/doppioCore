package doppio.event;

import doppio.apps.authentication.model.User;

public class NewEmailEvent {

    User user;
    String newEmail;

    public NewEmailEvent(User user, String newEmail) {
        this.user = user;
        this.newEmail = newEmail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
