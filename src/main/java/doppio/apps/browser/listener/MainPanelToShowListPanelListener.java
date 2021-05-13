package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.explorer.profilepanel.listener.ProfilePanelListener;
import doppio.apps.explorer.profilepanel.view.ProfilePanel;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;

public class MainPanelToShowListPanelListener implements ProfileClickListener {

    MainPanel mainPanel;

    public MainPanelToShowListPanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void runProfileClickListener(int userId) {
        ProfilePanel profilePanel = new ProfilePanel(new ProfilePanelListener(userId));
        mainPanel.setNewCenter(profilePanel);
    }
}
