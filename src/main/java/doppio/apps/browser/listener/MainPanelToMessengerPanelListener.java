package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.messenger.listener.PrivateChatClickListener;
import doppio.apps.messenger.showprivatechat.view.ShowPrivateChatPanel;
import doppio.listener.StringListener;

import java.awt.*;

public class MainPanelToMessengerPanelListener implements PrivateChatClickListener {

    MainPanel mainPanel;

    public MainPanelToMessengerPanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run(int privateChatId) {
        System.out.println("ha ha ha run MainPanelToMessengerPanelListener");
        ShowPrivateChatPanel showPrivateChatPanel = new ShowPrivateChatPanel();
        mainPanel.setNewCenter(showPrivateChatPanel);

    }
}
