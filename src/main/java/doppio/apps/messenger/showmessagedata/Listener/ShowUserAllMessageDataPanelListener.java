package doppio.apps.messenger.showmessagedata.Listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.messenger.controller.MessageController;
import doppio.apps.messenger.model.GroupChat;
import doppio.apps.messenger.model.PrivateChat;
import doppio.controller.SessionController;

import java.util.LinkedList;

public class ShowUserAllMessageDataPanelListener {
    MessageController messageController;
    SessionController sessionController;

    public ShowUserAllMessageDataPanelListener() {
        messageController = new MessageController();
        sessionController = new SessionController();
    }

    public LinkedList<PrivateChat> getPrivateChats() {
        LinkedList<PrivateChat> privateChats = new LinkedList<>();
        int userId = sessionController.getSession(0).getUserId();
        privateChats = messageController.getPrivateChats(userId);
        return privateChats;
    }

    public LinkedList<GroupChat> getGroupChats() {
        LinkedList<GroupChat> groupChats = new LinkedList<>();

        return groupChats;
    }
}
