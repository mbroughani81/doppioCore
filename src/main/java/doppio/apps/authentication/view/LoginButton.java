package doppio.apps.authentication.view;

import javax.swing.*;
import java.awt.*;

public class LoginButton extends JButton {
    public LoginButton() {
//        this.setSize(new Dimension(50, 50));
        this.setPreferredSize(new Dimension(100, 30));
        this.setFocusable(false);
        this.setText("Login");
    }
}
