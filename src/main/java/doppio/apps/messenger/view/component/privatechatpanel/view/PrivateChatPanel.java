package doppio.apps.messenger.view.component.privatechatpanel.view;

import doppio.apps.messenger.model.Pm;
import doppio.apps.messenger.view.component.PmListPanel;
import doppio.apps.messenger.view.component.privatechatpanel.listener.PrivateChatPanelListener;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class PrivateChatPanel extends JPanel {

    PmListPanel pmListPanel;

    PrivateChatPanelListener privateChatPanelListener;

    public PrivateChatPanel(PrivateChatPanelListener privateChatPanelListener) {
        this.privateChatPanelListener = privateChatPanelListener;
        this.setLayout(new BorderLayout());

        pmListPanel = new PmListPanel();
        LinkedList<Pm> pms = privateChatPanelListener.getPms();
        for (Pm pm : pms) {
            pmListPanel.addPm(pm);
        }
        this.add(pmListPanel, BorderLayout.CENTER);
    }

}
