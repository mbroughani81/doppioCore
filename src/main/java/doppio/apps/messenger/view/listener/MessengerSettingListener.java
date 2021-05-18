package doppio.apps.messenger.view.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.messenger.controller.MessageController;
import doppio.apps.messenger.controller.PmController;
import doppio.apps.messenger.model.Chat;
import doppio.apps.messenger.model.ChatType;
import doppio.apps.messenger.model.Pm;
import doppio.apps.messenger.model.UserType;
import doppio.apps.sociallist.controller.SocialListController;
import doppio.controller.SessionController;
import doppio.event.NewGroupChatEvent;
import doppio.event.NewPmEvent;
import doppio.event.NewPrivateChatEvent;
import doppio.event.NewUserTypeEvent;

import java.util.LinkedList;

public class MessengerSettingListener {
    AuthController authController = new AuthController();
    SessionController sessionController = new SessionController();
    SocialListController socialListController = new SocialListController();
    MessageController messageController = new MessageController();
    PmController pmController = new PmController();

    public User getUser(int userId) {
        return authController.getUser(userId);
    }

    public User getUser() {
        int userId = sessionController.getSession(0).getUserId();
        return authController.getUser(userId);
    }

    public LinkedList<Integer> getFollowingIds() {
        int userId = sessionController.getSession(0).getUserId();
        User u = authController.getUser(userId);
        return socialListController.getFollowingList(u).getList();
    }

    public LinkedList<UserType> getTypes() {
        int userId = sessionController.getSession(0).getUserId();
        LinkedList<UserType> res = new LinkedList<>();
        for (UserType userType : messageController.getAllUserTypes()) {
            if (userType.getOwnerId() == userId)
                res.add(userType);
        }
        return res;
    }
    public UserType getUserType(int userTypeId) {
        for (UserType userType : messageController.getAllUserTypes()) {
            if (userType.getId() == userTypeId)
                return userType;
        }
        return null;
    }
    public int getChatId(int userId) {
        int userId1 = sessionController.getSession(0).getUserId();
        int userId2 = userId;
        for (Chat chat : messageController.getPrivateChats(userId1)) {
            if (chat.getChatType() == ChatType.PRIVATE && chat.getMemberIds().contains(userId2))
                return chat.getId();
        }
        NewPrivateChatEvent event = new NewPrivateChatEvent(userId1, userId2);
        return messageController.newPrivateChat(event);
    }

    public void newUserType(NewUserTypeEvent event) {
        messageController.newUserType(event);
    }

    public int newGroupChat(NewGroupChatEvent event) {
        return messageController.newGroupChat(event);
    }

    public void newPm(NewPmEvent event) {
        pmController.sendNewPm(event);
    }
}
