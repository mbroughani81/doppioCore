package doppio.apps.messenger.view.component.privatechatpanel.listener;

import doppio.apps.messenger.controller.PmController;
import doppio.apps.messenger.model.Pm;

import java.util.LinkedList;

public class PrivateChatPanelListener {

    int privateChatId;

    PmController pmController;

    public PrivateChatPanelListener(int privateChatId) {
        this.privateChatId = privateChatId;
        pmController = new PmController();
    }

    public LinkedList<Pm> getPms() {
        LinkedList<Pm> pms = pmController.getPms(privateChatId);
        return pms;
    }

}
