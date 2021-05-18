package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.messenger.listener.ChatClickListener;
import doppio.apps.messenger.showchat.listener.ShowChatPanelListener;
import doppio.apps.messenger.showchat.view.ShowChatPanel;

public class MainPanelToMessengerPanelListener implements ChatClickListener {

    MainPanel mainPanel;

    public MainPanelToMessengerPanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

//    @Override
//    public void run(int privateChatId) {
//        System.out.println("ha ha ha run MainPanelToMessengerPanelListener");
//        ShowChatPanel showPrivateChatPanel = new ShowChatPanel(new ShowChatPanelListener(privateChatId));
//        mainPanel.setNewCenter(showPrivateChatPanel);
//    }

    @Override
    public void run(int chatId) {
        System.out.println("ha ha ha run MainPanelToMessengerPanelListener");
        ShowChatPanel showChatPanel = new ShowChatPanel(new ShowChatPanelListener(chatId));
        showChatPanel.setProfileClickListener(new MainPanelToShowChatPanelListener(mainPanel));
        mainPanel.setNewCenter(showChatPanel);
    }
}
