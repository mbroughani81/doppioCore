package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.explorer.profilepanel.listener.ProfilePanelListener;
import doppio.apps.explorer.profilepanel.view.ProfilePanel;
import doppio.apps.explorer.showtweets.showusertweets.listener.ShowUserTweetPanelListener;
import doppio.apps.explorer.showtweets.showusertweets.view.ShowUserTweetsPanel;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.personalpage.showlist.listener.ShowListPanelListener;
import doppio.apps.personalpage.showlist.view.ShowListPanel;
import doppio.apps.post.listener.NewTweetPanelListener;
import doppio.apps.post.view.NewTweetPanel;
import doppio.apps.setting.editprofile.listener.EditProfilePanelListener;
import doppio.apps.setting.editprofile.view.EditProfilePanel;
import doppio.apps.sociallist.view.NotificationPanel;
import doppio.apps.sociallist.view.listener.NotificationPanelListener;
import doppio.listener.StringListener;

public class MainPanelToPersonalPagePanelListener implements StringListener, ProfileClickListener {
    MainPanel mainPanel;

    public MainPanelToPersonalPagePanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run(String s) {
        if (s.equals("showTweetsPersonalPagePanel")) {
            ShowUserTweetsPanel showUserTweetsPanel = new ShowUserTweetsPanel(new ShowUserTweetPanelListener());
            showUserTweetsPanel.setTweetClickListener(new MainPanelToShowUserTweetsPanelListener(mainPanel));
            showUserTweetsPanel.setProfileClickListener(new MainPanelToShowUserTweetsPanelListener(mainPanel));
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
        if (s.equals("showListsPersonalPagePanel")) {
            ShowListPanel showListPanel = new ShowListPanel(new ShowListPanelListener());
            showListPanel.setProfileClickListener(new MainPanelToShowListPanelListener(mainPanel));
            mainPanel.setNewCenter(showListPanel);
        }
        if (s.equals("notificationsPersonalPagePanel")) {
            NotificationPanel notificationPanel = new NotificationPanel(new NotificationPanelListener());
            mainPanel.setNewCenter(notificationPanel);
        }
    }

    @Override
    public void runProfileClickListener(int userId) {
        ProfilePanel profilePanel = new ProfilePanel(new ProfilePanelListener(userId));
        mainPanel.setNewCenter(profilePanel);
    }
}
