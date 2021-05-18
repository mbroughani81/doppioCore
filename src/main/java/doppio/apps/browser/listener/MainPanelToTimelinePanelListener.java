package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.explorer.profilepanel.listener.ProfilePanelListener;
import doppio.apps.explorer.profilepanel.view.ProfilePanel;
import doppio.apps.explorer.showtweets.showsingletweet.listener.ShowSingleTweetPanelListener;
import doppio.apps.explorer.showtweets.showsingletweet.view.ShowSingleTweetPanel;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickListener;

public class MainPanelToTimelinePanelListener implements TweetClickListener, ProfileClickListener {
    MainPanel mainPanel;

    public MainPanelToTimelinePanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run(int tweetId) {
        ShowSingleTweetPanel showSingleTweetPanel = new ShowSingleTweetPanel(new ShowSingleTweetPanelListener(tweetId));
        showSingleTweetPanel.setTweetClickListener(new MainPanelToShowSingleTweetPanelListener(mainPanel));
        showSingleTweetPanel.setProfileClickListener(new MainPanelToShowSingleTweetPanelListener(mainPanel));
        mainPanel.setNewCenter(showSingleTweetPanel);
    }

    @Override
    public void runProfileClickListener(int userId) {
        ProfilePanel profilePanel = new ProfilePanel(new ProfilePanelListener(userId));
        profilePanel.setChatClickListener(new MainPanelToProfilePanelListener(mainPanel));
        mainPanel.setNewCenter(profilePanel);
    }
}
