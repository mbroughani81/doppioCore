package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.explorer.showtweets.showusertweets.listener.MainPanelToShowUserTweetsPanelListener;
import doppio.apps.explorer.showtweets.showusertweets.listener.ShowUserTweetPanelListener;
import doppio.apps.explorer.showtweets.showusertweets.view.ShowUserTweetsPanel;
import doppio.apps.personalpage.view.PersonalPagePanel;
import doppio.listener.StringListener;

import java.awt.*;

public class MainPanelToPersonalPagePanelListener implements StringListener {
    MainPanel mainPanel;

    public MainPanelToPersonalPagePanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run(String s) {
        if (s.equals("showTweetsPersonalPagePanel")) {
//            System.out.println("runn in MainPanelToPersonalPagePanelListener");
            ShowUserTweetsPanel showUserTweetsPanel = new ShowUserTweetsPanel(new ShowUserTweetPanelListener());
            showUserTweetsPanel.setTweetClickListener(new MainPanelToShowUserTweetsPanelListener(mainPanel));
            BorderLayout layout = (BorderLayout) mainPanel.getLayout();
            mainPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
            mainPanel.add(showUserTweetsPanel, BorderLayout.CENTER);
            mainPanel.repaint();
            mainPanel.revalidate();
        }
    }
}
