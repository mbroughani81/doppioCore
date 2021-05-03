package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.listener.StringListener;

public class MainPanelToPersonalPagePanelListener implements StringListener {
    MainPanel mainPanel;

    public MainPanelToPersonalPagePanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run(String s) {
        if (s.equals("showTweetsPersonalPagePanel")) {
            System.out.println("runn in MainPanelToPersonalPagePanelListener");
        }
    }
}
