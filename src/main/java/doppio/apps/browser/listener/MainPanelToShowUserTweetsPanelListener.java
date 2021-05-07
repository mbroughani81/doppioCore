package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.explorer.showtweets.showsingletweet.listener.ShowSingleTweetPanelListener;
import doppio.apps.explorer.showtweets.showsingletweet.view.ShowSingleTweetPanel;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickListener;

public class MainPanelToShowUserTweetsPanelListener implements TweetClickListener {
    MainPanel mainPanel;

    public MainPanelToShowUserTweetsPanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run(int tweetId) {
        ShowSingleTweetPanel showSingleTweetPanel = new ShowSingleTweetPanel(new ShowSingleTweetPanelListener(tweetId));
        showSingleTweetPanel.setTweetClickListener(new MainPanelToShowSingleTweetPanelListener(mainPanel));
        mainPanel.setNewCenter(showSingleTweetPanel);
    }
}
