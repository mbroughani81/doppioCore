package doppio.apps.authentication.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.view.LoginPanel;
import doppio.listener.StringListener;

import javax.swing.*;

public class MainpanelToSignupPanelListener implements StringListener {
    JPanel mainPanel;
    JFrame authenticationFrame;
    AuthController authController = new AuthController();

    public MainpanelToSignupPanelListener(JPanel mainPanel, JFrame authenticationFrame) {
        this.mainPanel = mainPanel;
        this.authenticationFrame = authenticationFrame;
    }

    @Override
    public void run(String s) {
        if (s.equals("signupSignupPanel")) {
            System.out.println("loginSignupPanel is in MainpanelToSignupPanelListener");
            authenticationFrame.dispose();
        }
        if (s.equals("loginSignupPanel")) {
//            System.out.println("loginSignupPanel is in MainpanelToSignupPanelListener");
            LoginPanel loginPanel = new LoginPanel();
            loginPanel.addListener(new MainpanelToLoginPanelListener(mainPanel, authenticationFrame));
            loginPanel.addFormListener(new LoginFormListener());
            mainPanel.removeAll();
            mainPanel.add(loginPanel);
            mainPanel.repaint();
            mainPanel.revalidate();
        }
    }
}
