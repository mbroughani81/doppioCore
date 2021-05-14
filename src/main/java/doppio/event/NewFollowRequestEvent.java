package doppio.event;

import doppio.apps.authentication.model.User;

public class NewFollowRequestEvent {
    User follower;
    User followed;

    public NewFollowRequestEvent(User follower, User followed) {
        this.follower = follower;
        this.followed = followed;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }
}
