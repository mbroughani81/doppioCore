package doppio.listener;

import doppio.apps.authentication.exception.InvalidPasswordException;
import doppio.apps.authentication.exception.InvalidUsernameException;
import doppio.event.FormEvent;

public interface FormInvoker {
    void checkFormListeners(FormEvent event) throws InvalidPasswordException, InvalidUsernameException;
    void addFormListener(FormListener listener);
}
