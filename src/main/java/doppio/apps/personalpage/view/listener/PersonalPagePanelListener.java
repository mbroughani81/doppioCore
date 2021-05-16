package doppio.apps.personalpage.view.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.controller.SessionController;

public class PersonalPagePanelListener {
    SessionController sessionController = new SessionController();

    public int getUserId() {
        return sessionController.getSession(0).getId();
    }
}
