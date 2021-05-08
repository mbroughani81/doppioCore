package doppio.apps.messenger.view;

import doppio.apps.messenger.listener.PrivateChatClickInvoker;
import doppio.apps.messenger.listener.PrivateChatClickListener;
import doppio.apps.messenger.showmessagedata.Listener.ShowUserAllMessageDataPanelListener;
import doppio.apps.messenger.showmessagedata.view.ShowUserAllMessageDataPanel;
import doppio.apps.messenger.view.MainPanel;

import javax.swing.*;
import java.awt.*;

public class MessengerPanel extends JPanel implements PrivateChatClickInvoker {
    MainPanel mainPanel;
    ShowUserAllMessageDataPanel showUserAllMessageDataPanel;

    PrivateChatClickListener privateChatClickListener;

    public MessengerPanel() {
        this.setLayout(new BorderLayout());

        mainPanel = new MainPanel();
        this.add(mainPanel, BorderLayout.CENTER);

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