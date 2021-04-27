package doppio.apps.authentication.view;

import javax.swing.*;
import java.awt.*;

public class SignupButton extends JButton {
    public SignupButton() {
        this.setPreferredSize(new Dimension(100, 30));
        this.setFocusable(false);
        this.setText("Signup");
    }
}
