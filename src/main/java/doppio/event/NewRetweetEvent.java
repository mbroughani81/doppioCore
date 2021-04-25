package doppio.event;

import doppio.apps.authentication.model.User;
import doppio.apps.post.model.Tweet;

public class NewRetweetEvent {
    Tweet originalTweet;
    User creator;

    public NewRetweetEvent(Tweet originalTweet, User creator) {
        this.originalTweet = originalTweet;
        this.creator = creator;
    }

    public Tweet getOriginalTweet() {
        return originalTweet;
    }

    public void setOriginalTweet(Tweet originalTweet) {
        this.originalTweet = originalTweet;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
