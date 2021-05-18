package doppio.apps.messenger.view.component.chatlist;

import doppio.apps.messenger.listener.ChatClickInvoker;
import doppio.apps.messenger.listener.ChatClickListener;
import doppio.apps.messenger.model.Chat;
import doppio.apps.messenger.view.component.chatlist.ChatLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class ChatListPanel extends JPanel implements ChatClickInvoker {

    LinkedList<Chat> chats;

    ChatClickListener chatClickListener;

    public ChatListPanel() {
        this.setLayout(new GridBagLayout());

        chats = new LinkedList<>();

        chatClickListener = null;
    }

    public void addChat(Chat chat) {
        chats.add(chat);

        for (int i = 0; i < chats.size(); i++) {
            for (int t = 0; t < chats.size() - 1; t++)
                if (chats.get(t).getUnreadCount() < chats.get(t + 1).getUnreadCount()) {
                    Chat chat1 = chats.get(t);
                    chats.set(t, chats.get(t + 1));
                    chats.set(t + 1, chat1);
                }
        }

        updatePanel();
    }


    private void updatePanel() {
        this.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        for (Chat chat : chats) {
            JLabel chatLabel = new ChatLabel(chat);
            ChatClickAction action = new ChatClickAction(chat);
            chatLabel.addMouseListener(action);
            this.add(chatLabel, gbc);
            gbc.gridy++;
        }
//        for (GroupChat groupChat : groupChats) {
//            JLabel chatLabel = new ChatLabel(groupChat);
//            this.add(chatLabel, gbc);
//            gbc.gridy++;
//        }

        this.repaint();
        this.revalidate();
    }

//    @Override
//    public void setPrivateChatClickListener(PrivateChatClickListener listener) {
//        this.privateChatClickListener = listener;
//    }
//
//    @Override
//    public void checkPrivateClickListener(int privateChatId) {
//        privateChatClickListener.run(privateChatId);
//    }

    @Override
    public void setChatClickListener(ChatClickListener listener) {
        this.chatClickListener = listener;
    }

    @Override
    public void checkChatClickListener(int privateChatId) {
        this.chatClickListener.run(privateChatId);
    }

    class ChatClickAction implements MouseListener {

        Chat chat;

        public ChatClickAction(Chat chat) {
            this.chat = chat;
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            System.out.println("Yaho!! mouseclicked chatclickaction chatlistpanel");
            checkChatClickListener(chat.getId());
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
}
