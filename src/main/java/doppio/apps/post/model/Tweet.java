package doppio.apps.post.model;

import doppio.apps.authentication.model.User;

public class Tweet {
    private int id;

    private Tweet parentTweet;
    private String text;
    private User owner;
    private User creator;

    public Tweet(Tweet parentTweet, String text, User owner, User creator) {
        this.parentTweet = parentTweet;
        this.text = text;
        this.owner = owner;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tweet getParentTweet() {
        return parentTweet;
    }

    public void setParentTweet(Tweet parentTweet) {
        this.parentTweet = parentTweet;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
