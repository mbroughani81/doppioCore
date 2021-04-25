package doppio.event;

import doppio.apps.authentication.model.User;

public class AddToFollowerEvent {
    User follower;
    User followd;

    public AddToFollowerEvent(User follower, User followd) {
        this.follower = follower;
        this.followd = followd;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowd() {
        return followd;
    }

    public void setFollowd(User followd) {
        this.followd = followd;
    }
}
