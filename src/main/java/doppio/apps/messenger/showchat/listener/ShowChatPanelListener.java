package doppio.apps.messenger.showchat.listener;

import doppio.apps.messenger.controller.MessageController;
import doppio.apps.messenger.controller.PmController;
import doppio.apps.messenger.model.Pm;
import doppio.controller.SessionController;
import doppio.event.NewPmEvent;

public class ShowChatPanelListener {

    int chatId;
    PmController pmController = new PmController();
    MessageController messageController = new MessageController();
    SessionController sessionController = new SessionController();

    public ShowChatPanelListener(int chatId) {
        this.chatId = chatId;
    }

    public int getChatId() {
        return chatId;
    }

    public void sendNewPm(String text) {
        int userId = sessionController.getSession(0).getUserId();
        NewPmEvent event = new NewPmEvent(userId, chatId, text);

        pmController.sendNewPm(event);
    }

    public void setPmsSeen() {
        messageController.setPmsSeen(chatId);
    }
}
