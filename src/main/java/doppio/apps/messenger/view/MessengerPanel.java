package doppio.apps.messenger.view;

import doppio.apps.messenger.listener.ChatClickInvoker;
import doppio.apps.messenger.listener.ChatClickListener;
import doppio.apps.messenger.showmessagedata.Listener.ShowUserAllMessageDataPanelListener;
import doppio.apps.messenger.showmessagedata.view.ShowUserAllMessageDataPanel;
import doppio.apps.messenger.view.listener.MessengerSettingListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class MessengerPanel extends JPanel implements ChatClickInvoker {
    static Logger logger = LogManager.getLogger(MessengerPanel.class);

    MainPanel mainPanel;
    MessengerSetting messengerSetting;
    ShowUserAllMessageDataPanel showUserAllMessageDataPanel;

    ChatClickListener chatClickListener;

    public MessengerPanel() {
        logger.trace("MessengerPanel is created");

        this.setLayout(new BorderLayout());

        mainPanel = new MainPanel();
        this.add(mainPanel, BorderLayout.CENTER);

        messengerSetting = new MessengerSetting(new MessengerSettingListener());
        this.add(messengerSetting, BorderLayout.EAST);

        showUserAllMessageDataPanel = new ShowUserAllMessageDataPanel(new ShowUserAllMessageDataPanelListener());
        showUserAllMessageDataPanel.setChatClickListener(new ChatClickListener() {
            @Override
            public void run(int privateChatId) {
                checkChatClickListener(privateChatId);
            }
        });
        mainPanel.add(showUserAllMessageDataPanel, BorderLayout.CENTER);


    }

    @Override
    public void setChatClickListener(ChatClickListener listener) {
        this.chatClickListener = listener;
    }

    @Override
    public void checkChatClickListener(int chatId) {
        this.chatClickListener.run(chatId);

    }
}
