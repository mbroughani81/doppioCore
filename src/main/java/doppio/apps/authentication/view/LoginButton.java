package doppio.apps.authentication.view;

import doppio.config.AuthenticationConfig;

import javax.swing.*;
import java.awt.*;

public class LoginButton extends JButton {
    AuthenticationConfig authenticationConfig = new AuthenticationConfig();

    public LoginButton() {
        this.setPreferredSize(new Dimension(authenticationConfig.getLoginButtonWidth(), authenticationConfig.getLoginButtonHeight()));
        this.setFocusable(false);
        this.setText(authenticationConfig.getLoginButtonText());
    }
}
