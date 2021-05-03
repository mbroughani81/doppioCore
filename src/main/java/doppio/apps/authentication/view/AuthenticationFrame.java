package doppio.apps.authentication.view;

import doppio.apps.authentication.listener.LoginFormListener;
import doppio.apps.authentication.listener.MainpanelToLoginPanelListener;
import doppio.apps.authentication.listener.MainpanelToSignupPanelListener;
import doppio.listener.StringListener;

import javax.swing.*;
import java.awt.*;

public class AuthenticationFrame extends JFrame {

    MainPanel mainPanel;
    LogoPanel logoPanel;

    public AuthenticationFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.setVisible(true);

        mainPanel = new MainPanel();
        this.add(mainPanel, BorderLayout.CENTER);

        logoPanel = new LogoPanel();
        this.add(logoPanel, BorderLayout.NORTH);

        DefaultPanel defaultPanel = new DefaultPanel();
        defaultPanel.addListener(new StringListener() {
            @Override
            public void run(String s) {
                if (s.equals("loginDefaultPanel")) {
                    mainPanel.removeAll();
                    LoginPanel loginPanel = new LoginPanel();
                    loginPanel.addListener(new MainpanelToLoginPanelListener(mainPanel));
                    loginPanel.addFormListener(new LoginFormListener());
                    mainPanel.add(loginPanel, BorderLayout.CENTER);
                    repaint();
                    revalidate();
                }
                if (s.equals("signupDefaultPanel")) {
                    mainPanel.removeAll();
                    SignupPanel signupPanel = new SignupPanel();
                    signupPanel.addListener(new MainpanelToSignupPanelListener(mainPanel));
                    mainPanel.add(signupPanel, BorderLayout.CENTER);
                    repaint();
                    revalidate();
                }
            }
        });
        mainPanel.add(defaultPanel, BorderLayout.CENTER);
    }
}
