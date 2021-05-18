package doppio.apps.messenger.view.component.listener;

import doppio.apps.messenger.controller.PmController;
import doppio.controller.SessionController;
import doppio.event.NewPmEvent;

public class MessageInputPanelListener {

    int chatId;
    PmController pmController = new PmController();
    SessionController sessionController = new SessionController();

    public MessageInputPanelListener(int chatId) {
        this.chatId = chatId;
    }

    public int getChatId() {
        return chatId;
    }

    public int sendNewPm(String s, int chatId) {
        int userId = sessionController.getSession(0).getUserId();
        NewPmEvent event = new NewPmEvent(userId, chatId, s);
        return pmController.sendNewPm(event);
    }
}
