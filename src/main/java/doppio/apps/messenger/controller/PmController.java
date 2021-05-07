package doppio.apps.messenger.controller;

import doppio.apps.messenger.model.Pm;
import doppio.apps.messenger.model.PrivateChat;
import doppio.controller.AbstractController;

import java.util.LinkedList;

public class PmController extends AbstractController {

    public LinkedList<Pm> getPms(int privateChatId) {
        PrivateChat privateChat = context.PrivateChats.get(privateChatId);
        LinkedList<Pm> pms = new LinkedList<>();
        for (int pmId : privateChat.getPmIds()) {
            pms.add(context.Pms.get(pmId));
        }
        return pms;
    }
}
