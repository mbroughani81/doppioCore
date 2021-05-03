package doppio.controller;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.event.FormEvent;
import doppio.model.Session;

public class SessionController extends AbstractController {
    public void newSession(FormEvent event) {
        AuthController authController = new AuthController();
        User user = authController.getUser(event.getUsername());
        Session session = new Session(user.getId());
        context.Sessions.add(session);
    }

    public void clearSessionDB() {
        context.Sessions.clear();
    }
}
