package doppio.apps.browser.listener;

import doppio.apps.authentication.view.AuthenticationWindow;
import doppio.apps.browser.view.BrowserFrame;
import doppio.apps.setting.settingpanel.listener.LogoutClickListener;
import doppio.controller.SessionController;

public class MainPanelToSettingPanelListener implements LogoutClickListener {
    BrowserFrame browserFrame;
    SessionController sessionController = new SessionController();

    public MainPanelToSettingPanelListener(BrowserFrame browserFrame) {
        this.browserFrame = browserFrame;
    }

    @Override
    public void run() {
        browserFrame.dispose();
        sessionController.clearSessionDB();
        new AuthenticationWindow();

    }
}
