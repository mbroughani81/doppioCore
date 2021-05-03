package doppio.apps.authentication.listener;

import doppio.controller.SessionController;
import doppio.event.FormEvent;
import doppio.listener.FormListener;

public class LoginFormListener implements FormListener {
    private SessionController controller = new SessionController();

    @Override
    public void eventOccurred(FormEvent event) {
        controller.newSession(event);
    }
}
