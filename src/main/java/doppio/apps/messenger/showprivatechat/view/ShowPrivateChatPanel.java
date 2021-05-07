package doppio.apps.messenger.showprivatechat.view;

import doppio.apps.messenger.showprivatechat.listener.ShowPrivateChatPanelListener;
import doppio.apps.messenger.view.component.MessageInputPanel;
import doppio.apps.messenger.view.component.privatechatpanel.listener.PrivateChatPanelListener;
import doppio.apps.messenger.view.component.privatechatpanel.view.PrivateChatPanel;
import doppio.listener.StringListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowPrivateChatPanel extends JPanel implements ActionListener {

    PrivateChatPanel privateChatPanel;
    MessageInputPanel messageInputPanel;

    ShowPrivateChatPanelListener showPrivateChatPanelListener;

    public ShowPrivateChatPanel(ShowPrivateChatPanelListener showPrivateChatPanelListener) {
        this.showPrivateChatPanelListener = showPrivateChatPanelListener;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        this.setOpaque(true);

        privateChatPanel = new PrivateChatPanel(new PrivateChatPanelListener(showPrivateChatPanelListener.getPrivateChatId()));
        this.add(privateChatPanel, BorderLayout.CENTER);

        messageInputPanel = new MessageInputPanel();
        messageInputPanel.addListener(new StringListener() {
            @Override
            public void run(String s) {
                if (s.equals("sendButtonClickMessageInputPanel")) {
                    // the list of messages should get updated now
                }
            }
        });
        this.add(messageInputPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
