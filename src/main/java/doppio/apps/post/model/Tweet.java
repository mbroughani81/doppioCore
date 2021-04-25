package doppio.apps.post.model;

import com.google.gson.annotations.SerializedName;
import doppio.apps.authentication.model.User;

public class Tweet {
    private int id;

    private int parentTweetId;
    private String text;
    private User creator;
    private int sourceId;

    public Tweet(int parentTweetId, String text, User creator) {
        this.parentTweetId = parentTweetId;
        this.text = text;
        this.creator = creator;
        this.sourceId = -1;
    }

    public Tweet(int parentTweetId, String text, User creator, int sourceId) {
        this.parentTweetId = parentTweetId;
        this.text = text;
        this.creator = creator;
        this.sourceId = sourceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentTweetId() {
        return parentTweetId;
    }

    public void setParentTweetId(int parentTweetId) {
        this.parentTweetId = parentTweetId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }
}
