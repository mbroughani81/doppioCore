package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.messenger.listener.ChatClickListener;
import doppio.apps.messenger.showchat.listener.ShowChatPanelListener;
import doppio.apps.messenger.showchat.view.ShowChatPanel;

public class MainPanelToProfilePanelListener implements ChatClickListener {

    MainPanel mainPanel;

    public MainPanelToProfilePanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run(int chatId) {
        ShowChatPanel showChatPanel = new ShowChatPanel(new ShowChatPanelListener(chatId));
        showChatPanel.setProfileClickListener(new MainPanelToShowChatPanelListener(mainPanel));
        mainPanel.setNewCenter(showChatPanel);
    }
}
