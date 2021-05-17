package doppio.apps.authentication.view.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.event.NewUserEvent;

public class SignupPanelListener {
    AuthController authController = new AuthController();

    public void newUser(NewUserEvent event) {
        authController.addUser(event);
    }
}
