package doppio.apps.authentication.listener;

import doppio.apps.authentication.view.SignupPanel;
import doppio.listener.StringListener;

import javax.swing.*;

public class MainpanelToLoginPanelListener implements StringListener {
    JPanel mainPanel;
    JFrame authenticationFrame;

    public MainpanelToLoginPanelListener(JPanel mainPanel, JFrame authenticationFrame) {
        this.mainPanel = mainPanel;
        this.authenticationFrame = authenticationFrame;
    }

    @Override
    public void run(String s) {
        if (s.equals("signupLoginPanel")) {
            SignupPanel signupPanel = new SignupPanel();
            signupPanel.addListener(new MainpanelToSignupPanelListener(mainPanel, authenticationFrame));
            mainPanel.removeAll();
            mainPanel.add(signupPanel);
            mainPanel.repaint();
            mainPanel.revalidate();
        }
        if (s.equals("loginLoginPanel")) {
//            System.out.println("loginLoginPanel is in run MainpaneltoLoginpalnelistener");
            authenticationFrame.dispose();
            new
        }
    }
}
