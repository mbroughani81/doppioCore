package doppio.apps.authentication.listener;

import doppio.apps.authentication.view.LoginPanel;
import doppio.listener.StringListener;

import javax.swing.*;

public class MainpanelToSignupPanelListener implements StringListener {
    JPanel mainPanel;

    public MainpanelToSignupPanelListener(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run(String s) {
        if (s.equals("signupSignupPanel")) {
            System.out.println("loginSignupPanel is in MainpanelToSignupPanelListener");
        }
        if (s.equals("loginSignupPanel")) {
//            System.out.println("loginSignupPanel is in MainpanelToSignupPanelListener");
            LoginPanel loginPanel = new LoginPanel();
            loginPanel.addListener(new MainpanelToLoginPanelListener(mainPanel));
            mainPanel.removeAll();
            mainPanel.add(loginPanel);
            mainPanel.repaint();
            mainPanel.revalidate();
        }
    }
}
