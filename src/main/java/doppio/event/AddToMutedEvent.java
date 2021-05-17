package doppio.event;

import doppio.apps.authentication.model.User;

public class AddToMutedEvent {
    int muterId;
    int mutedId;

    public AddToMutedEvent(int muterId, int mutedId) {
        this.muterId = muterId;
        this.mutedId = mutedId;
    }

    public int getMuterId() {
        return muterId;
    }

    public void setMuterId(int muterId) {
        this.muterId = muterId;
    }

    public int getMutedId() {
        return mutedId;
    }

    public void setMutedId(int mutedId) {
        this.mutedId = mutedId;
    }
}
