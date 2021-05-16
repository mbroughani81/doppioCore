package doppio.apps.setting.editprofile.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.controller.SessionController;
import doppio.event.NewNameEvent;

public class EditProfilePanelListener {

    SessionController sessionController;
    AuthController authController;

    public EditProfilePanelListener() {
        sessionController = new SessionController();
        authController = new AuthController();
    }

    public int getUserId() {
        return sessionController.getSession(0).getUserId();
    }

    public User getUser() {
        int userId = sessionController.getSession(0).getUserId();
        return authController.getUser(userId);
    }

    public void setNewName(NewNameEvent event) {
        authController.changeName(event);
    }
}
