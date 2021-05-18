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

    public Pm getPm(int pmId) {
        return context.Pms.get(pmId);
    }

    public int sendNewPm(NewPmEvent event) {
        Pm pm = new Pm(event.getUserId(), event.getText());
        int id = context.Pms.add(pm);

        Chat eventChat = context.Chats.get(event.getChatId());
        int parentChatId = eventChat.getParentChatId();

        System.out.println(parentChatId + " is parent id pm controller");

        for (Chat chat : context.Chats.all()) {
            if (chat.getParentChatId() == parentChatId) {
                System.out.println(chat.getId() + " has parentid pmcontroller");
                LinkedList<Integer> pmIds = chat.getPmIds();
                pmIds.add(id);
                chat.setPmIds(pmIds);
                if (chat.getId() != event.getChatId())
                    chat.setUnreadCount(chat.getUnreadCount() + 1);
                context.Chats.update(chat);
            }
        }
        return id;
    }

    public void removePm(int pmId) {
        Pm pm = context.Pms.get(pmId);
        pm.setText("(This is deleted)");
        context.Pms.update(pm);
    }

    public void editPm(int pmId, String text) {
        Pm pm  = context.Pms.get(pmId);
        pm.setText(text);
        context.Pms.update(pm);
    }

    public void clearPmDB() {
        context.Pms.clear();
    }
}
