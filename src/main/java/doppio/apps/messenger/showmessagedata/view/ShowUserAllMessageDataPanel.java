package doppio.apps.messenger.showmessagedata.view;

import doppio.apps.messenger.listener.ChatClickInvoker;
import doppio.apps.messenger.listener.ChatClickListener;
import doppio.apps.messenger.model.Chat;
import doppio.apps.messenger.showmessagedata.Listener.ShowUserAllMessageDataPanelListener;
import doppio.apps.messenger.view.component.ChatListPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class ShowUserAllMessageDataPanel extends JPanel implements ChatClickInvoker {
    static Logger logger = LogManager.getLogger(ShowUserAllMessageDataPanel.class);

    ShowUserAllMessageDataPanelListener showUserAllMessageDataPanelListener;

    ChatListPanel chatListPanel;

    ChatClickListener chatClickListener;

    public ShowUserAllMessageDataPanel(ShowUserAllMessageDataPanelListener showUserAllMessageDataPanelListener) {
        logger.trace("ShowUserAllMessageDataPanel is created");

        this.showUserAllMessageDataPanelListener = showUserAllMessageDataPanelListener;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        this.setOpaque(true);

        chatListPanel = new ChatListPanel();
        chatListPanel.setChatClickListener(new ChatClickListener() {
            @Override
            public void run(int privateChatId) {
//                System.out.println("Yahooo !  " + privateChatId + " showuserallmessagedatapanel const");
                checkChatClickListener(privateChatId);
            }
        });
        this.add(chatListPanel, BorderLayout.CENTER);
        for (Chat privateChat : this.showUserAllMessageDataPanelListener.getPrivateChats()) {
            chatListPanel.addChat(privateChat);
        }

        for (Chat groupChat : this.showUserAllMessageDataPanelListener.getGroupChats()) {
            chatListPanel.addChat(groupChat);
        }

    }

//    @Override
//    public void setPrivateChatClickListener(PrivateChatClickListener listener) {
//        this.privateChatClickListener = listener;
//    }
//
//    @Override
//    public void checkPrivateClickListener(int privateChatId) {
////        if (privateChatClickListener != null) {
////            privateChatClickListener.
////        }
//        privateChatClickListener.run(privateChatId);
//    }


    @Override
    public void setChatClickListener(ChatClickListener listener) {
        this.chatClickListener = listener;
    }

    @Override
    public void checkChatClickListener(int chatId) {
        this.chatClickListener.run(chatId);
    }
}
