package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.explorer.explorerpanel.listener.ExplorerPanelListener;
import doppio.apps.explorer.explorerpanel.view.ExplorerPanel;
import doppio.apps.messenger.view.MessengerPanel;
import doppio.apps.personalpage.view.PersonalPagePanel;
import doppio.apps.personalpage.view.listener.PersonalPagePanelListener;
import doppio.apps.setting.settingpanel.listener.SettingPanelListener;
import doppio.apps.setting.settingpanel.view.SettingPanel;
import doppio.apps.timeline.view.TimelinePanel;
import doppio.apps.timeline.view.listener.TimelinePanelListener;
import doppio.listener.StringListener;

public class MainPanelToAppsMenuPanelListener implements StringListener {

    MainPanel mainPanel;

    public MainPanelToAppsMenuPanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run(String s) {
//        System.out.println("run in MainPanelToAppsMenuPanelListener");
        if (s.equals("personalPageAppClicked")) {
            PersonalPagePanel personalPagePanel = new PersonalPagePanel(new PersonalPagePanelListener());
            personalPagePanel.addListener(new MainPanelToPersonalPagePanelListener(mainPanel));
            personalPagePanel.setProfileClickListener(new MainPanelToPersonalPagePanelListener(mainPanel));
            mainPanel.setNewCenter(personalPagePanel);
        }
        if (s.equals("timelineAppClicked")) {
            TimelinePanel timelinePanel = new TimelinePanel(new TimelinePanelListener());
            timelinePanel.setTweetClickListener(new MainPanelToExplorerPanelListener(mainPanel));
            timelinePanel.setProfileClickListener(new MainPanelToExplorerPanelListener(mainPanel));
            mainPanel.setNewCenter(timelinePanel);
        }
        if (s.equals("messengerAppClicked")) {
            MessengerPanel messengerPanel = new MessengerPanel();
            messengerPanel.setChatClickListener(new MainPanelToMessengerPanelListener(mainPanel));
            mainPanel.setNewCenter(messengerPanel);
        }
        if (s.equals("settingAppClicked")) {
            SettingPanel settingPanel = new SettingPanel(new SettingPanelListener());
            mainPanel.setNewCenter(settingPanel);
        }
        if (s.equals("explorerAppClicked")) {
            ExplorerPanel explorerPanel = new ExplorerPanel(new ExplorerPanelListener());
            explorerPanel.setTweetClickListener(new MainPanelToExplorerPanelListener(mainPanel));
            explorerPanel.setProfileClickListener(new MainPanelToExplorerPanelListener(mainPanel));
            mainPanel.setNewCenter(explorerPanel);
        }
    }
}
