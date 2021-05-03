package doppio.listener;

import doppio.event.FormEvent;

public interface FormInvoker {
    void checkFormListeners(FormEvent event);
    void addFormListener(FormListener listener);
}
