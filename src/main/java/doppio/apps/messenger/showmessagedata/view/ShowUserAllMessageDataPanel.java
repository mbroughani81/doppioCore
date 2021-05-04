package doppio.apps.messenger.showmessagedata.view;

import doppio.apps.messenger.model.GroupChat;
import doppio.apps.messenger.model.PrivateChat;
import doppio.apps.messenger.showmessagedata.Listener.ShowUserAllMessageDataPanelListener;
import doppio.apps.messenger.view.ChatListPanel;

import javax.swing.*;
import java.awt.*;

public class ShowUserAllMessageDataPanel extends JPanel {

    ShowUserAllMessageDataPanelListener showUserAllMessageDataPanelListener;

    ChatListPanel chatListPanel;

    public ShowUserAllMessageDataPanel(ShowUserAllMessageDataPanelListener showUserAllMessageDataPanelListener) {
        this.showUserAllMessageDataPanelListener = showUserAllMessageDataPanelListener;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        this.setOpaque(true);

        chatListPanel = new ChatListPanel();
        this.add(chatListPanel, BorderLayout.CENTER);
        for (PrivateChat privateChat : this.showUserAllMessageDataPanelListener.getPrivateChats()) {
            chatListPanel.addPrivateChat(privateChat);
        }
        for (GroupChat groupChat : this.showUserAllMessageDataPanelListener.getGroupChats()) {
            chatListPanel.addGroupChat(groupChat);
        }

    }

}
