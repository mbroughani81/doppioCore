package doppio.apps.messenger.controller;

import doppio.apps.authentication.model.User;
import doppio.apps.messenger.model.*;
import doppio.controller.AbstractController;
import doppio.event.NewGroupChatEvent;
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

    public int newGroupChat(NewGroupChatEvent event) {
        int messageDataId = context.Users.get(event.getOwnerId()).getMessageDataId();
        MessageData messageData = context.MessageDatas.get(messageDataId);
        Chat chat = new Chat(event.getOwnerId(), ChatType.GROUP);
        chat.setChatName(event.getGroupName());
        for (int id : event.getMemberIds()) {
            chat.getMemberIds().add(id);
        }
        int parentId = context.Chats.add(chat);
        chat.setParentChatId(parentId);
        chat.setId(parentId);
        context.Chats.update(chat);
        messageData.getChatIds().add(chat.getId());
        context.MessageDatas.update(messageData);

        for (int id : event.getMemberIds()) {
            if (id == event.getOwnerId()) {
                continue;
            }
            messageData = context.MessageDatas.get(messageDataId);
            chat = new Chat(id, ChatType.GROUP);
            for (int idd : event.getMemberIds()) {
                chat.getMemberIds().add(idd);
            }
            chat.setParentChatId(parentId);
            context.Chats.add(chat);
            messageData.getChatIds().add(chat.getId());
            context.MessageDatas.update(messageData);
        }
        return parentId;
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

    public LinkedList<Chat> getGroupChats(int userId) {
        LinkedList<Chat> chats = new LinkedList<>();
        for (Chat chat : context.Chats.all()) {
            if (chat.getOwnerId() == userId && chat.getChatType() == ChatType.GROUP)
                chats.add(chat);
        }
        return chats;
    }

    public LinkedList<Chat> getChats(int userId) {
        LinkedList<Chat> chats = new LinkedList<>();
        for (Chat chat : context.Chats.all()) {
            if (chat.getOwnerId() == userId)
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
