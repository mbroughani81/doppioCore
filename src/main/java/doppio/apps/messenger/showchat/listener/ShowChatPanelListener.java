package doppio.apps.messenger.showchat.listener;

import doppio.apps.messenger.controller.PmController;
import doppio.controller.SessionController;
import doppio.event.NewPmEvent;

public class ShowChatPanelListener {

    int privateChatId;
    PmController pmController;
    SessionController sessionController;

    public ShowChatPanelListener(int privateChatId) {
        this.privateChatId = privateChatId;

        pmController = new PmController();
        sessionController = new SessionController();
    }

    public int getPrivateChatId() {
        return privateChatId;
    }

    public void sendNewPm(String text) {
        int userId = sessionController.getSession(0).getUserId();
        NewPmEvent event = new NewPmEvent(userId, privateChatId, text);

        pmController.sendNewPm(event);
    }
}
