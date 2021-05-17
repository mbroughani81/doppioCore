package doppio.event;

public class NewLikeEvent {
    int userId;
    int tweetId;

    public NewLikeEvent(int userId, int tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }
}
