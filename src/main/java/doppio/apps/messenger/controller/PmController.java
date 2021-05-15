package doppio.apps.messenger.controller;

import doppio.apps.messenger.model.ChatType;
import doppio.apps.messenger.model.Pm;
import doppio.apps.messenger.model.Chat;
import doppio.controller.AbstractController;
import doppio.event.NewPmEvent;

import java.util.LinkedList;

public class PmController extends AbstractController {

    public LinkedList<Pm> getPms(int chatId) {
        Chat chat = context.Chats.get(chatId);
        LinkedList<Pm> pms = new LinkedList<>();
        for (int pmId : chat.getPmIds()) {
            pms.add(context.Pms.get(pmId));
        }
        return pms;
    }

    public void sendNewPm(NewPmEvent event) {
        Pm pm = new Pm(event.getUserId(), event.getText());
        int id = context.Pms.add(pm);

        Chat eventChat = context.Chats.get(event.getChatId());
        int parentChatId = eventChat.getParentChatId();

        for (Chat chat : context.Chats.all()) {
            if (chat.getParentChatId() == parentChatId) {
                LinkedList<Integer> pmIds = chat.getPmIds();
                pmIds.add(id);
                chat.setPmIds(pmIds);
                context.Chats.update(chat);
                break;
            }
        }
    }

    public void clearPmDB() {
        context.Pms.clear();
    }
}
