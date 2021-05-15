package doppio.apps.messenger.view;

import doppio.apps.messenger.listener.PrivateChatClickInvoker;
import doppio.apps.messenger.listener.PrivateChatClickListener;
import doppio.apps.messenger.showmessagedata.Listener.ShowUserAllMessageDataPanelListener;
import doppio.apps.messenger.showmessagedata.view.ShowUserAllMessageDataPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class MessengerPanel extends JPanel implements PrivateChatClickInvoker {
    static Logger logger = LogManager.getLogger(MessengerPanel.class);

    MainPanel mainPanel;
    MessengerSetting messengerSetting;
    ShowUserAllMessageDataPanel showUserAllMessageDataPanel;

    PrivateChatClickListener privateChatClickListener;

    public MessengerPanel() {
        logger.trace("MessengerPanel is created");

        this.setLayout(new BorderLayout());

        mainPanel = new MainPanel();
        this.add(mainPanel, BorderLayout.CENTER);

        messengerSetting = new MessengerSetting();
        this.add(messengerSetting, BorderLayout.EAST);

        showUserAllMessageDataPanel = new ShowUserAllMessageDataPanel(new ShowUserAllMessageDataPanelListener());
        showUserAllMessageDataPanel.setPrivateChatClickListener(new PrivateChatClickListener() {
            @Override
            public void run(int privateChatId) {
                checkPrivateClickListener(privateChatId);
            }
        });
        mainPanel.add(showUserAllMessageDataPanel, BorderLayout.CENTER);


    }

    @Override
    public void setPrivateChatClickListener(PrivateChatClickListener listener) {
        this.privateChatClickListener = listener;
    }

    @Override
    public void checkPrivateClickListener(int privateChatId) {
        privateChatClickListener.run(privateChatId);
    }
}
