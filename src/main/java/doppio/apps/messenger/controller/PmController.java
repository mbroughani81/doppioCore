package doppio.apps.messenger.controller;

import doppio.apps.messenger.model.ChatType;
import doppio.apps.messenger.model.Pm;
import doppio.apps.messenger.model.Chat;
import doppio.apps.sociallist.model.BlockList;
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

        for (Chat chat : context.Chats.all()) {
            int userId1 = eventChat.getOwnerId();
            int userId2 = chat.getOwnerId();
            BlockList blockList1 = context.Blocklists.get(context.Users.get(userId1).getBlockListId());
            BlockList blockList2 = context.Blocklists.get(context.Users.get(userId2).getBlockListId());
            if (blockList1.getList().contains(userId2) || blockList2.getList().contains(userId1))
                continue;
            if (chat.getParentChatId() == parentChatId) {
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
