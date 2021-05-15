package doppio.apps.messenger.showmessagedata.view;

import doppio.apps.messenger.listener.PrivateChatClickInvoker;
import doppio.apps.messenger.listener.PrivateChatClickListener;
import doppio.apps.messenger.model.Chat;
import doppio.apps.messenger.showmessagedata.Listener.ShowUserAllMessageDataPanelListener;
import doppio.apps.messenger.view.component.ChatListPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class ShowUserAllMessageDataPanel extends JPanel implements PrivateChatClickInvoker {
    static Logger logger = LogManager.getLogger(ShowUserAllMessageDataPanel.class);

    ShowUserAllMessageDataPanelListener showUserAllMessageDataPanelListener;

    ChatListPanel chatListPanel;

    PrivateChatClickListener privateChatClickListener;

    public ShowUserAllMessageDataPanel(ShowUserAllMessageDataPanelListener showUserAllMessageDataPanelListener) {
        logger.trace("ShowUserAllMessageDataPanel is created");

        this.showUserAllMessageDataPanelListener = showUserAllMessageDataPanelListener;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        this.setOpaque(true);

        chatListPanel = new ChatListPanel();
        chatListPanel.setPrivateChatClickListener(new PrivateChatClickListener() {
            @Override
            public void run(int privateChatId) {
//                System.out.println("Yahooo !  " + privateChatId + " showuserallmessagedatapanel const");
                checkPrivateClickListener(privateChatId);
            }
        });
        this.add(chatListPanel, BorderLayout.CENTER);
        for (Chat privateChat : this.showUserAllMessageDataPanelListener.getPrivateChats()) {
            chatListPanel.addPrivateChat(privateChat);
        }

    }

    @Override
    public void setPrivateChatClickListener(PrivateChatClickListener listener) {
        this.privateChatClickListener = listener;
    }

    @Override
    public void checkPrivateClickListener(int privateChatId) {
//        if (privateChatClickListener != null) {
//            privateChatClickListener.
//        }
        privateChatClickListener.run(privateChatId);
    }
}
