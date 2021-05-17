package doppio.event;

import doppio.apps.authentication.model.LastSeenPrivacy;
import doppio.apps.authentication.model.Privacy;
import doppio.apps.authentication.model.Profile;

public class ChangeLastSeenPrivacy {
    Profile profile;
    LastSeenPrivacy newPrivacy;

    public ChangeLastSeenPrivacy(Profile profile, LastSeenPrivacy newPrivacy) {
        this.profile = profile;
        this.newPrivacy = newPrivacy;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public LastSeenPrivacy getNewPrivacy() {
        return newPrivacy;
    }

    public void setNewPrivacy(LastSeenPrivacy newPrivacy) {
        this.newPrivacy = newPrivacy;
    }
}
