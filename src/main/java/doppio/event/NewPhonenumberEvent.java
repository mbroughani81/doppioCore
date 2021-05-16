package doppio.event;

import doppio.apps.authentication.model.User;

public class NewPhonenumberEvent {

    User user;
    String newPhonenumber;

    public NewPhonenumberEvent(User user, String newPhonenumber) {
        this.user = user;
        this.newPhonenumber = newPhonenumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewPhonenumber() {
        return newPhonenumber;
    }

    public void setNewPhonenumber(String newPhonenumber) {
        this.newPhonenumber = newPhonenumber;
    }
}
