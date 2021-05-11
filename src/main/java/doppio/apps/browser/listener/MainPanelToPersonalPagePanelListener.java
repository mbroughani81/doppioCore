package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.explorer.showtweets.showusertweets.listener.ShowUserTweetPanelListener;
import doppio.apps.explorer.showtweets.showusertweets.view.ShowUserTweetsPanel;
import doppio.apps.post.listener.NewTweetPanelListener;
import doppio.apps.post.view.NewTweetPanel;
import doppio.apps.setting.editprofile.listener.EditProfilePanelListener;
import doppio.apps.setting.editprofile.view.EditProfilePanel;
import doppio.listener.StringListener;

public class MainPanelToPersonalPagePanelListener implements StringListener {
    MainPanel mainPanel;

    public MainPanelToPersonalPagePanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run(String s) {
        if (s.equals("showTweetsPersonalPagePanel")) {
            ShowUserTweetsPanel showUserTweetsPanel = new ShowUserTweetsPanel(new ShowUserTweetPanelListener());
            showUserTweetsPanel.setTweetClickListener(new MainPanelToShowUserTweetsPanelListener(mainPanel));
            mainPanel.setNewCenter(showUserTweetsPanel);
        }
        if (s.equals("newTweetPersonalPagePanel")) {
            NewTweetPanel newTweetPanel = new NewTweetPanel(new NewTweetPanelListener());
            mainPanel.setNewCenter(newTweetPanel);
        }
        if (s.equals("editProfilePersonalPagePanel")) {
            EditProfilePanel editProfilePanel = new EditProfilePanel(new EditProfilePanelListener());
            mainPanel.setNewCenter(editProfilePanel);
        }
    }
}
