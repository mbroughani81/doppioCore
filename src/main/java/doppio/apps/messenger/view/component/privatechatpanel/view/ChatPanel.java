package doppio.apps.messenger.view.component.privatechatpanel.view;

import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.messenger.model.Pm;
import doppio.apps.messenger.view.component.pmlabel.PmListPanel;
import doppio.apps.messenger.view.component.privatechatpanel.listener.ChatPanelListener;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ChatPanel extends JPanel implements ProfileClickInvoker {

    PmListPanel pmListPanel;

    ChatPanelListener chatPanelListener;
    ProfileClickListener profileClickListener;

    public ChatPanel(ChatPanelListener chatPanelListener) {
        this.chatPanelListener = chatPanelListener;
        this.setLayout(new BorderLayout());

        pmListPanel = new PmListPanel();
        pmListPanel.setProfileClickListener(new ProfileClickListener() {
            @Override
            public void runProfileClickListener(int userId) {
                checkProfileClickListener(userId);
            }
        });
        LinkedList<Pm> pms = chatPanelListener.getPms();
        for (Pm pm : pms) {
            if (chatPanelListener.isForUser(pm))
                pmListPanel.addPm(pm, 0);
            else
                pmListPanel.addPm(pm, 1);
        }
        this.add(pmListPanel, BorderLayout.CENTER);
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
