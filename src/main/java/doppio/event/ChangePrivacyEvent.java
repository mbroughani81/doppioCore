package doppio.event;

import doppio.apps.authentication.model.Privacy;
import doppio.apps.authentication.model.Profile;

public class ChangePrivacyEvent {
    Profile profile;
    Privacy newPrivacy;

    public ChangePrivacyEvent(Profile profile, Privacy newPrivacy) {
        this.profile = profile;
        this.newPrivacy = newPrivacy;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Privacy getNewPrivacy() {
        return newPrivacy;
    }

    public void setNewPrivacy(Privacy newPrivacy) {
        this.newPrivacy = newPrivacy;
    }
}
