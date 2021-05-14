package doppio.apps.setting.settingpanel.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.Privacy;
import doppio.apps.authentication.model.Profile;
import doppio.apps.authentication.model.User;
import doppio.controller.SessionController;
import doppio.event.ChangePrivacyEvent;
import doppio.event.NewPrivateChatEvent;

public class SettingPanelListener {

    AuthController authController;
    SessionController sessionController;

    public SettingPanelListener() {
        authController = new AuthController();
        sessionController = new SessionController();
    }

    public void changePrivacy(Privacy p) {
        int userId = sessionController.getSession(0).getUserId();
        User user = authController.getUser(userId);
        Profile profile = authController.getProfile(user.getProfile().getId());
        System.out.println(profile.getId() + " " + p + " changepriacy settinpanellistener");
        ChangePrivacyEvent event = new ChangePrivacyEvent(profile, p);
        authController.changePrivacy(event);
    }
}
