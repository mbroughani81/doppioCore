package doppio.apps.messenger.view.component.privatechatpanel.view;

import doppio.apps.messenger.model.Pm;
import doppio.apps.messenger.view.component.PmListPanel;
import doppio.apps.messenger.view.component.privatechatpanel.listener.ChatPanelListener;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ChatPanel extends JPanel {

    PmListPanel pmListPanel;

    ChatPanelListener chatPanelListener;

    public ChatPanel(ChatPanelListener chatPanelListener) {
        this.chatPanelListener = chatPanelListener;
        this.setLayout(new BorderLayout());

        pmListPanel = new PmListPanel();
        LinkedList<Pm> pms = chatPanelListener.getPms();
        for (Pm pm : pms) {
            if (chatPanelListener.isForUser(pm))
                pmListPanel.addPm(pm, 0);
            else
                pmListPanel.addPm(pm, 1);
        }
        this.add(pmListPanel, BorderLayout.CENTER);
    }

}
