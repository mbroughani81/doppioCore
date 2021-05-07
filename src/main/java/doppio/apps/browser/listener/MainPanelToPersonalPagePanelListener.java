package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.explorer.showtweets.showusertweets.listener.MainPanelToShowUserTweetsPanelListener;
import doppio.apps.explorer.showtweets.showusertweets.listener.ShowUserTweetPanelListener;
import doppio.apps.explorer.showtweets.showusertweets.view.ShowUserTweetsPanel;
import doppio.apps.personalpage.view.PersonalPagePanel;
import doppio.apps.post.listener.NewTweetPanelListener;
import doppio.apps.post.view.NewTweetPanel;
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
            mainPanel.setNewCenter(showUserTweetsPanel);
        }
        if (s.equals("newTweetPersonalPagePanel")) {
            NewTweetPanel newTweetPanel = new NewTweetPanel(new NewTweetPanelListener());
            mainPanel.setNewCenter(newTweetPanel);
        }
    }
}
