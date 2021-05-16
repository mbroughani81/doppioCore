package doppio.event;

import doppio.apps.authentication.model.User;

public class NewBioEvent {

    User user;
    String newBio;

    public NewBioEvent(User user, String newBio) {
        this.user = user;
        this.newBio = newBio;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewBio() {
        return newBio;
    }

    public void setNewBio(String newBio) {
        this.newBio = newBio;
    }
}
