package doppio.apps.messenger.showprivatechat.view;

import doppio.apps.messenger.showprivatechat.listener.ShowPrivateChatPanelListener;
import doppio.apps.messenger.view.component.MessageInputPanel;
import doppio.apps.messenger.view.component.privatechatpanel.listener.PrivateChatPanelListener;
import doppio.apps.messenger.view.component.privatechatpanel.view.PrivateChatPanel;
import doppio.listener.StringInvoker;
import doppio.listener.StringListener;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ShowPrivateChatPanel extends JPanel implements StringInvoker {

    PrivateChatPanel privateChatPanel;
    MessageInputPanel messageInputPanel;

    ShowPrivateChatPanelListener showPrivateChatPanelListener;
    LinkedList<StringListener> stringListeners;

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
                    showPrivateChatPanelListener.sendNewPm(messageInputPanel.getMessageText().getText());
//                    privateChatPanel = new PrivateChatPanel(new PrivateChatPanelListener(showPrivateChatPanelListener.getPrivateChatId()));
                    checkListeners("updatePrivateChatPanel");
                }
            }
        });
        this.add(messageInputPanel, BorderLayout.SOUTH);

        stringListeners = new LinkedList<>();
    }

    @Override
    public void checkListeners(String s) {
        for (StringListener listener : stringListeners)
            listener.run(s);
    }

    @Override
    public void addListener(StringListener listener) {
        stringListeners.add(listener);
    }
}
