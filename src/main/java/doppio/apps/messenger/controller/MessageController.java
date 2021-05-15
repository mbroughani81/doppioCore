package doppio.apps.messenger.controller;

import doppio.apps.authentication.model.User;
import doppio.apps.messenger.model.GroupChat;
import doppio.apps.messenger.model.MessageData;
import doppio.apps.messenger.model.PrivateChat;
import doppio.apps.messenger.model.UserType;
import doppio.controller.AbstractController;
import doppio.event.NewPrivateChatEvent;
import doppio.event.NewUserTypeEvent;

import java.util.LinkedList;

public class MessageController extends AbstractController {
    public void newPrivateChat(NewPrivateChatEvent event) {
        int id1 = context.Users.get(event.getUser1id()).getMessageDataId();
        int id2 = context.Users.get(event.getUser2id()).getMessageDataId();
        MessageData messageData1 = context.MessageDatas.get(id1);
        MessageData messageData2 = context.MessageDatas.get(id2);
        PrivateChat privateChat1 = new PrivateChat(event.getUser1id(), event.getUser2id());
        PrivateChat privateChat2 = new PrivateChat(event.getUser2id(), event.getUser1id());
        int privateChat1Id = context.PrivateChats.add(privateChat1);
        int privateChat2Id = context.PrivateChats.add(privateChat2);
        messageData1.getPrivateChatsId().add(privateChat1Id);
        messageData2.getPrivateChatsId().add(privateChat2Id);
        context.MessageDatas.update(messageData1);
        context.MessageDatas.update(messageData2);
    }

    public void newUserType(NewUserTypeEvent event) {
        UserType userType = new UserType(event.getUserTypeName(), event.getOwnerId());
        userType.getUserIds().addAll(event.getUserIds());
        context.UserTypes.add(userType);
    }

    public LinkedList<GroupChat> getGroupChats(int userId) {
        LinkedList<GroupChat> groupChats = new LinkedList<>();
        return groupChats;
    }


    public LinkedList<PrivateChat> getPrivateChats(int userId) {
        LinkedList<PrivateChat> privateChats = new LinkedList<>();
        for (PrivateChat privateChat : context.PrivateChats.all()) {
            if (privateChat.getUser1id() == userId)
                privateChats.add(privateChat);
        }
        return privateChats;
    }


    public void clearMessageDataDB() {
        context.MessageDatas.clear();
    }

    public void clearPrivateChatDB() {
        context.PrivateChats.clear();
    }

    public void clearGroupChatDB() {
        context.GroupChats.clear();
    }

    public void clearUserTypeDB() {
        context.UserTypes.clear();
    }
}
