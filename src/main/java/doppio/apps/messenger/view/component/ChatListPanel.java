package doppio.apps.messenger.view.component;

import doppio.apps.messenger.listener.PrivateChatClickInvoker;
import doppio.apps.messenger.listener.PrivateChatClickListener;
import doppio.apps.messenger.model.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class ChatListPanel extends JPanel implements PrivateChatClickInvoker {

    LinkedList<Chat> privateChats;

    PrivateChatClickListener privateChatClickListener;

    public ChatListPanel() {
        this.setLayout(new GridBagLayout());

        privateChats = new LinkedList<>();

        privateChatClickListener = null;
    }

    public void addPrivateChat(Chat privateChat) {
        privateChats.add(privateChat);

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
        for (Chat privateChat : privateChats) {
            JLabel chatLabel = new ChatLabel(privateChat);
            ChatClickAction action = new ChatClickAction(privateChat);
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

    @Override
    public void setPrivateChatClickListener(PrivateChatClickListener listener) {
        this.privateChatClickListener = listener;
    }

    @Override
    public void checkPrivateClickListener(int privateChatId) {
        privateChatClickListener.run(privateChatId);
    }

    class ChatClickAction implements MouseListener {

        Chat privateChat;

        public ChatClickAction(Chat privateChat) {
            this.privateChat = privateChat;
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            System.out.println("Yaho!! mouseclicked chatclickaction chatlistpanel");
            checkPrivateClickListener(privateChat.getId());
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
