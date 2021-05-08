package doppio.apps.messenger.showprivatechat.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.messenger.showprivatechat.view.ShowPrivateChatPanel;
import doppio.listener.StringListener;

public class UpdatePrivateChatPanelListener implements StringListener {

    MainPanel mainPanel;
    int privateChatId;

    public UpdatePrivateChatPanelListener(MainPanel mainPanel, int privateChatId) {
        this.mainPanel = mainPanel;
        this.privateChatId = privateChatId;
    }

    @Override
    public void run(String s) {
        if (s.equals("updatePrivateChatPanel")) {
            ShowPrivateChatPanel showPrivateChatPanel = new ShowPrivateChatPanel(new ShowPrivateChatPanelListener(privateChatId));
            showPrivateChatPanel.addListener(new UpdatePrivateChatPanelListener(mainPanel, privateChatId));
            mainPanel.undo();
            mainPanel.setNewCenter(showPrivateChatPanel);
            System.out.println("besmellah run updateprivatechatpanellistener");
        }
    }
}
