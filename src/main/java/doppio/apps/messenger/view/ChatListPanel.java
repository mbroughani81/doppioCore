package doppio.apps.messenger.view;

import doppio.apps.messenger.model.GroupChat;
import doppio.apps.messenger.model.PrivateChat;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ChatListPanel extends JPanel {

    LinkedList<PrivateChat> privateChats;
    LinkedList<GroupChat> groupChats;

    public ChatListPanel() {
        this.setLayout(new GridBagLayout());

        privateChats = new LinkedList<>();
        groupChats = new LinkedList<>();
    }

    public void addPrivateChat(PrivateChat privateChat) {
        privateChats.add(privateChat);

        updatePanel();
    }

    public void addGroupChat(GroupChat groupChat) {
        groupChats.add(groupChat);

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
        for (PrivateChat privateChat : privateChats) {
            JLabel chatLabel = new ChatLabel(privateChat);
            this.add(chatLabel, gbc);
            gbc.gridy++;
        }
        for (GroupChat groupChat : groupChats) {
            JLabel chatLabel = new ChatLabel(groupChat);
            this.add(chatLabel, gbc);
            gbc.gridy++;
        }

        this.repaint();
        this.revalidate();
    }
}
