package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.messenger.listener.PrivateChatClickListener;
import doppio.apps.messenger.showprivatechat.listener.ShowPrivateChatPanelListener;
import doppio.apps.messenger.showprivatechat.listener.UpdatePrivateChatPanelListener;
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
        ShowPrivateChatPanel showPrivateChatPanel = new ShowPrivateChatPanel(new ShowPrivateChatPanelListener(privateChatId));
        showPrivateChatPanel.addListener(new UpdatePrivateChatPanelListener(mainPanel, privateChatId));
//        showPrivateChatPanel.addListener(new StringListener() {
//            @Override
//            public void run(String s) {
//                if (s.equals("updatePrivateChatPanel")) {
//                    mainPanel.setNewCenter(showPrivateChatPanel);
//                }
//            }
//        });
        mainPanel.setNewCenter(showPrivateChatPanel);
    }
}
