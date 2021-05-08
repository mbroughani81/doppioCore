package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.messenger.listener.PrivateChatClickListener;
import doppio.apps.messenger.showprivatechat.listener.ShowPrivateChatPanelListener;
import doppio.apps.messenger.showprivatechat.view.ShowPrivateChatPanel;

public class MainPanelToMessengerPanelListener implements PrivateChatClickListener {

    MainPanel mainPanel;

    public MainPanelToMessengerPanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run(int privateChatId) {
        System.out.println("ha ha ha run MainPanelToMessengerPanelListener");
        ShowPrivateChatPanel showPrivateChatPanel = new ShowPrivateChatPanel(new ShowPrivateChatPanelListener(privateChatId));
        mainPanel.setNewCenter(showPrivateChatPanel);
    }
}
