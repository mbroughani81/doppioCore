package doppio.apps.setting.editprofile.listener;

import doppio.apps.authentication.model.User;
import doppio.controller.SessionController;

public class EditProfilePanelListener {

    SessionController sessionController;

    public EditProfilePanelListener() {
        sessionController = new SessionController();
    }

    public int getUserId() {
        return sessionController.getSession(0).getUserId();
    }
}
