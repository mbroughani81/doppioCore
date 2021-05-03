package doppio.apps.browser.listener;

import doppio.apps.browser.view.MainPanel;
import doppio.apps.personalpage.view.PersonalPagePanel;
import doppio.listener.StringListener;

import java.awt.*;

public class MainPanelToAppsMenuPanelListener implements StringListener {

    MainPanel mainPanel;

    public MainPanelToAppsMenuPanelListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run(String s) {
//        System.out.println("run in MainPanelToAppsMenuPanelListener");
        if (s.equals("personalPageAppClicked")) {
            PersonalPagePanel personalPagePanel = new PersonalPagePanel();
            BorderLayout layout = (BorderLayout) mainPanel.getLayout();
            mainPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
            mainPanel.add(personalPagePanel, BorderLayout.CENTER);
            mainPanel.repaint();
            mainPanel.revalidate();
        }
    }
}
