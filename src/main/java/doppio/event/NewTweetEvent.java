package doppio.event;

import doppio.apps.authentication.model.User;

public class NewTweetEvent {
    private User owner;
    private String text;

    public NewTweetEvent(User owner, String text) {
        this.owner = owner;
        this.text = text;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
