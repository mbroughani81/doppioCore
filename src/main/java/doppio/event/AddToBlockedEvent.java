package doppio.event;

import doppio.apps.authentication.model.User;

public class AddToBlockedEvent {
    User blocker;
    User blocked;

    public AddToBlockedEvent(User blocker, User blocked) {
        this.blocker = blocker;
        this.blocked = blocked;
    }

    public User getBlocker() {
        return blocker;
    }

    public void setBlocker(User blocker) {
        this.blocker = blocker;
    }

    public User getBlocked() {
        return blocked;
    }

    public void setBlocked(User blocked) {
        this.blocked = blocked;
    }
}
