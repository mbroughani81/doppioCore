package doppio.apps.messenger.showprivatechat.listener;

import doppio.apps.authentication.model.User;
import doppio.apps.messenger.controller.PmController;
import doppio.apps.messenger.model.Pm;
import doppio.controller.SessionController;
import doppio.event.NewPmEvent;
import doppio.model.Session;

public class ShowPrivateChatPanelListener {

    int privateChatId;
    PmController pmController;
    SessionController sessionController;

    public ShowPrivateChatPanelListener(int privateChatId) {
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
