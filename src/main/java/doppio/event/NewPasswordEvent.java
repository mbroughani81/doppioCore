package doppio.event;

import doppio.apps.authentication.model.User;

public class NewPasswordEvent {
    User user;
    String newPassword;

    public NewPasswordEvent(User user, String newPassword) {
        this.user = user;
        this.newPassword = newPassword;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
