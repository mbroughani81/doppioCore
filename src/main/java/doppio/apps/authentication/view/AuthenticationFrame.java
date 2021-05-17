package doppio.apps.authentication.view;

import doppio.apps.authentication.listener.LoginFormListener;
import doppio.apps.authentication.listener.MainpanelToLoginPanelListener;
import doppio.apps.authentication.listener.MainpanelToSignupPanelListener;
import doppio.apps.authentication.view.listener.SignupPanelListener;
import doppio.config.AuthenticationConfig;
import doppio.listener.StringListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class AuthenticationFrame extends JFrame {

    static Logger logger = LogManager.getLogger(AuthenticationFrame.class);
    AuthenticationConfig authenticationConfig = new AuthenticationConfig();

    MainPanel mainPanel;
    LogoPanel logoPanel;

    public AuthenticationFrame() {
        logger.trace("AuthenticationFrame is created");

        System.out.println(authenticationConfig.getAuthenticationFrameHeight() + " authenticaiotnframe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(authenticationConfig.getAuthenticationFrameWidth(), authenticationConfig.getAuthenticationFrameHeight());
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
                    loginPanel.addListener(new MainpanelToLoginPanelListener(mainPanel, AuthenticationFrame.this));
                    loginPanel.addFormListener(new LoginFormListener());
                    mainPanel.add(loginPanel, BorderLayout.CENTER);
                    repaint();
                    revalidate();
                }
                if (s.equals("signupDefaultPanel")) {
                    mainPanel.removeAll();
                    SignupPanel signupPanel = new SignupPanel(new SignupPanelListener());
                    signupPanel.addListener(new MainpanelToSignupPanelListener(mainPanel, AuthenticationFrame.this));
                    mainPanel.add(signupPanel, BorderLayout.CENTER);
                    repaint();
                    revalidate();
                }
            }
        });
        mainPanel.add(defaultPanel, BorderLayout.CENTER);
    }
}
