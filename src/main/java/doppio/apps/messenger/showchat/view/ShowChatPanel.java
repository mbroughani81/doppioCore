package doppio.apps.messenger.showchat.view;

import com.google.gson.Gson;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.messenger.showchat.listener.ShowChatPanelListener;
import doppio.apps.messenger.view.component.messageinput.MessageInputPanel;
import doppio.apps.messenger.view.component.listener.MessageInputPanelListener;
import doppio.apps.messenger.view.component.privatechatpanel.listener.ChatPanelListener;
import doppio.apps.messenger.view.component.privatechatpanel.view.ChatPanel;
import doppio.listener.StringInvoker;
import doppio.listener.StringListener;
import doppio.log.AdvancedLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class ShowChatPanel extends JPanel implements StringInvoker, AdvancedLog, ProfileClickInvoker {
    static Logger logger = LogManager.getLogger(ShowChatPanel.class);

    ChatPanel chatPanel;
    MessageInputPanel messageInputPanel;

    ShowChatPanelListener showChatPanelListener;
    LinkedList<StringListener> stringListeners;
    ProfileClickListener profileClickListener;

    public ShowChatPanel(ShowChatPanelListener showChatPanelListener) {
        this.showChatPanelListener = showChatPanelListener;

        HashMap<String,Integer> map = new HashMap<>();
        map.put("chat id", showChatPanelListener.getChatId());
        log("ShowChatPanel is created", map);

        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        this.setOpaque(true);

        showChatPanelListener.setPmsSeen();
        chatPanel = new ChatPanel(new ChatPanelListener(showChatPanelListener.getChatId()));
        chatPanel.setProfileClickListener(new ProfileClickListener() {
            @Override
            public void runProfileClickListener(int userId) {
                checkProfileClickListener(userId);
            }
        });
        this.add(chatPanel, BorderLayout.CENTER);

        messageInputPanel = new MessageInputPanel(new MessageInputPanelListener(showChatPanelListener.getChatId()));
        messageInputPanel.addListener(new StringListener() {
            @Override
            public void run(String s) {
                if (s.equals("sendButtonClickMessageInputPanel")) {
                    // the list of messages should get updated now

                    BorderLayout layout = (BorderLayout) ShowChatPanel.this.getLayout();
                    ShowChatPanel.this.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                    chatPanel = new ChatPanel(new ChatPanelListener(showChatPanelListener.getChatId()));
                    chatPanel.setProfileClickListener(new ProfileClickListener() {
                        @Override
                        public void runProfileClickListener(int userId) {
                            checkProfileClickListener(userId);
                        }
                    });
                    ShowChatPanel.this.add(chatPanel, BorderLayout.CENTER);
                    ShowChatPanel.this.repaint();
                    ShowChatPanel.this.revalidate();
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

    @Override
    public void setProfileClickListener(ProfileClickListener listener) {
        this.profileClickListener = listener;
    }

    @Override
    public void checkProfileClickListener(int userId) {
        this.profileClickListener.runProfileClickListener(userId);
    }
}
