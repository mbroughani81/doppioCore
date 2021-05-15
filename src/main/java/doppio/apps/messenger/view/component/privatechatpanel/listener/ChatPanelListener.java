package doppio.apps.messenger.view.component.privatechatpanel.listener;

import doppio.apps.messenger.controller.PmController;
import doppio.apps.messenger.model.Pm;
import doppio.controller.SessionController;

import java.util.LinkedList;

public class PrivateChatPanelListener {

    int privateChatId;

    PmController pmController;
    SessionController sessionController;

    public PrivateChatPanelListener(int privateChatId) {
        this.privateChatId = privateChatId;
        pmController = new PmController();
        sessionController = new SessionController();
    }

    public LinkedList<Pm> getPms() {
        LinkedList<Pm> pms = pmController.getPms(privateChatId);
        return pms;
    }

    public boolean isForUser(Pm pm) {
        int userId = sessionController.getSession(0).getUserId();
        return (pm.getUserId() == userId);
    }

}
