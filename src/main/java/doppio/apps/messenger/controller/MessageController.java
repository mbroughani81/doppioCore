package doppio.apps.messenger.controller;

import doppio.apps.messenger.model.*;
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
        Chat chat1 = new Chat(event.getUser1id(), ChatType.PRIVATE);
        chat1.getMemberIds().add(event.getUser1id());
        chat1.getMemberIds().add(event.getUser2id());
        Chat chat2 = new Chat(event.getUser2id(), ChatType.PRIVATE);
        chat2.getMemberIds().add(event.getUser1id());
        chat2.getMemberIds().add(event.getUser2id());
        int chat1Id = context.Chats.add(chat1);
        int chat2Id = context.Chats.add(chat2);
        chat1.setId(chat1Id);
        chat2.setId(chat2Id);
        chat1.setParentChatId(chat1Id);
        chat2.setParentChatId(chat2Id);
        context.Chats.update(chat1);
        context.Chats.update(chat2);
        messageData1.getChatIds().add(chat1Id);
        messageData2.getChatIds().add(chat2Id);
        context.MessageDatas.update(messageData1);
        context.MessageDatas.update(messageData2);
    }

    public void newUserType(NewUserTypeEvent event) {
        UserType userType = new UserType(event.getUserTypeName(), event.getOwnerId());
        userType.getUserIds().addAll(event.getUserIds());
        context.UserTypes.add(userType);
    }

    public LinkedList<Chat> getPrivateChats(int userId) {
        LinkedList<Chat> chats = new LinkedList<>();
        for (Chat chat : context.Chats.all()) {
            if (chat.getOwnerId() == userId && chat.getChatType() == ChatType.PRIVATE)
                chats.add(chat);
        }
        return chats;
    }


    public void clearMessageDataDB() {
        context.MessageDatas.clear();
    }

    public void clearChatDB() {
        context.Chats.clear();
    }

    public void clearUserTypeDB() {
        context.UserTypes.clear();
    }
}
