package doppio.apps.messenger.view.component.chatlist;

import doppio.apps.messenger.model.Chat;
import doppio.apps.messenger.model.ChatType;
import doppio.apps.messenger.view.component.chatlist.listener.ChatLabelListener;

import javax.swing.*;
import java.awt.*;

public class ChatLabel extends JLabel {

    ChatLabelListener chatLabelListener = new ChatLabelListener();

    Chat chat;

    public ChatLabel(Chat chat) {
        this.chat = chat;

        this.setPreferredSize(new Dimension(500, 30));
        this.setBackground(Color.RED);
        this.setOpaque(true);

        String unreadCount = "(" + chat.getUnreadCount() + ")";

        if (chat.getChatType() == ChatType.GROUP || chat.getMemberIds().size() == 1) {
            this.setText(chat.getChatName() + unreadCount);
        } else
        if (chat.getChatType() == ChatType.PRIVATE) {
            int otherMemberId = ((chat.getOwnerId() == chat.getMemberIds().get(0)) ?
                    chat.getMemberIds().get(1) : chat.getMemberIds().get(0));
            this.setText(chatLabelListener.getUsername(otherMemberId) + unreadCount);
        }
    }
}
