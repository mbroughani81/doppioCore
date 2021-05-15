package doppio.apps.messenger.showmessagedata.Listener;

import doppio.apps.messenger.controller.MessageController;
import doppio.apps.messenger.model.Chat;
import doppio.controller.SessionController;

import java.util.LinkedList;

public class ShowUserAllMessageDataPanelListener {
    MessageController messageController;
    SessionController sessionController;

    public ShowUserAllMessageDataPanelListener() {
        messageController = new MessageController();
        sessionController = new SessionController();
    }

    public LinkedList<Chat> getPrivateChats() {
        LinkedList<Chat> privateChats = new LinkedList<>();
        int userId = sessionController.getSession(0).getUserId();
        privateChats = messageController.getPrivateChats(userId);
        return privateChats;
    }
}
