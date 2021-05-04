package doppio.apps.messenger.view;

import doppio.apps.messenger.showmessagedata.Listener.ShowUserAllMessageDataPanelListener;
import doppio.apps.messenger.showmessagedata.view.ShowUserAllMessageDataPanel;

import javax.swing.*;
import java.awt.*;

public class MessengerPanel extends JPanel {
    MainPanel mainPanel;
    ShowUserAllMessageDataPanel showUserAllMessageDataPanel;

    public MessengerPanel() {
        this.setLayout(new BorderLayout());

        mainPanel = new MainPanel();
        this.add(mainPanel, BorderLayout.CENTER);

        showUserAllMessageDataPanel = new ShowUserAllMessageDataPanel(new ShowUserAllMessageDataPanelListener());
        mainPanel.add(showUserAllMessageDataPanel, BorderLayout.CENTER);

    }
}
