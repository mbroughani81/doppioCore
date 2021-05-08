package doppio.apps.messenger.controller;

import doppio.apps.messenger.model.Pm;
import doppio.apps.messenger.model.PrivateChat;
import doppio.controller.AbstractController;
import doppio.event.NewPmEvent;

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

    public void sendNewPm(NewPmEvent event) {
        // get two private chats and update theme with new om created!
        Pm pm = new Pm(event.getUserId(), event.getText());
        int id = context.Pms.add(pm);

        PrivateChat eventPrivateChat = context.PrivateChats.get(event.getPrivateChatId());
        for (PrivateChat privateChat : context.PrivateChats.all()) {
            if (privateChat.getUser1id() == eventPrivateChat.getUser1id() &&
            privateChat.getUser2id() == eventPrivateChat.getUser2id()) {
                LinkedList<Integer> pmIds = privateChat.getPmIds();
                pmIds.add(id);
                privateChat.setPmIds(pmIds);
                context.PrivateChats.update(privateChat);
                break;
            }
        }
        for (PrivateChat privateChat : context.PrivateChats.all()) {
            if (privateChat.getUser1id() == eventPrivateChat.getUser2id() &&
                    privateChat.getUser2id() == eventPrivateChat.getUser1id()) {
                LinkedList<Integer> pmIds = privateChat.getPmIds();
                pmIds.add(id);
                privateChat.setPmIds(pmIds);
                context.PrivateChats.update(privateChat);
                break;
            }
        }
    }

    public void clearPmDB() {
        context.Pms.clear();
    }
}
