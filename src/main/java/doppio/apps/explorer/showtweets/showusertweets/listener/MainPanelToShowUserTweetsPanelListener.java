package doppio.apps.explorer.showtweets.showusertweets.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.explorer.tweetlist.listener.TweetClickListener;

public class MainPanelToShowUserTweetsPanelListener implements TweetClickListener {
    MainPanel mainPanel;

    public MainPanelToShowUserTweetsPanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run(int tweetId) {
//
        System.out.println("gizez MainPanelToShowUserTweetsPanelListener run");
        // here we will load the tweetId Tweet into the mainpanel
    }
}
