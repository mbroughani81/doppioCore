package doppio.apps.messenger.showprivatechat.view;

import com.google.gson.Gson;
import doppio.apps.explorer.showtweets.showusertweets.view.ShowUserTweetsPanel;
import doppio.apps.messenger.showprivatechat.listener.ShowPrivateChatPanelListener;
import doppio.apps.messenger.view.component.MessageInputPanel;
import doppio.apps.messenger.view.component.privatechatpanel.listener.PrivateChatPanelListener;
import doppio.apps.messenger.view.component.privatechatpanel.view.PrivateChatPanel;
import doppio.listener.StringInvoker;
import doppio.listener.StringListener;
import doppio.log.AdvancedLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class ShowPrivateChatPanel extends JPanel implements StringInvoker, AdvancedLog {
    static Logger logger = LogManager.getLogger(ShowPrivateChatPanel.class);

    PrivateChatPanel privateChatPanel;
    MessageInputPanel messageInputPanel;

    ShowPrivateChatPanelListener showPrivateChatPanelListener;
    LinkedList<StringListener> stringListeners;

    public ShowPrivateChatPanel(ShowPrivateChatPanelListener showPrivateChatPanelListener) {
        this.showPrivateChatPanelListener = showPrivateChatPanelListener;

        HashMap<String,Integer> map = new HashMap<>();
        map.put("private chat id", showPrivateChatPanelListener.getPrivateChatId());
        log("ShowPrivateChatPanel is created", map);

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

                    BorderLayout layout = (BorderLayout) ShowPrivateChatPanel.this.getLayout();
                    ShowPrivateChatPanel.this.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                    privateChatPanel = new PrivateChatPanel(new PrivateChatPanelListener(showPrivateChatPanelListener.getPrivateChatId()));
                    ShowPrivateChatPanel.this.add(privateChatPanel, BorderLayout.CENTER);
                    ShowPrivateChatPanel.this.repaint();
                    ShowPrivateChatPanel.this.revalidate();
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

    @Override
    public void log(String message, HashMap<?, ?> map) {
        Gson gson = new Gson();
        logger.trace(message + gson.toJson(map));
    }
}
