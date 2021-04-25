package doppio.event;

import doppio.apps.authentication.model.User;
import doppio.apps.post.model.Tweet;

public class NewCommentEvent {
    private Tweet parentTweet;
    private User owner;
    private String text;

    public NewCommentEvent(Tweet parentTweet, User owner, String text) {
        this.parentTweet = parentTweet;
        this.owner = owner;
        this.text = text;
    }

    public Tweet getParentTweet() {
        return parentTweet;
    }

    public void setParentTweet(Tweet parentTweet) {
        this.parentTweet = parentTweet;
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
