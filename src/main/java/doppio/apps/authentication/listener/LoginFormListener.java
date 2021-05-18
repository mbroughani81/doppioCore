package doppio.apps.authentication.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.exception.InvalidPasswordException;
import doppio.apps.authentication.exception.InvalidUsernameException;
import doppio.controller.SessionController;
import doppio.event.FormEvent;
import doppio.listener.FormListener;

public class LoginFormListener implements FormListener {
    SessionController sessionController = new SessionController();
    AuthController authController = new AuthController();

    @Override
    public void eventOccurred(FormEvent event) throws InvalidPasswordException, InvalidUsernameException {
        if (!authController.usernameExists(event.getUsername())) {
            throw new InvalidUsernameException("username not found");
        }
        if (!authController.passwordMatches(event.getUsername(), event.getPassword())) {
            throw new InvalidPasswordException("password in incorrect");
        }
        sessionController.newSession(event);
        authController.updateLastSeen(event.getUsername());
    }
}
