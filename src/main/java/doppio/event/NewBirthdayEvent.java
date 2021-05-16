package doppio.event;

import doppio.apps.authentication.model.User;

public class NewBirthdayEvent {

    User user;
    String newBirthday;

    public NewBirthdayEvent(User user, String newBirthday) {
        this.user = user;
        this.newBirthday = newBirthday;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewBirthday() {
        return newBirthday;
    }

    public void setNewBirthday(String newBirthday) {
        this.newBirthday = newBirthday;
    }
}
