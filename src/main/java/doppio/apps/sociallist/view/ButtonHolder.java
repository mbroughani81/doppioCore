package doppio.apps.sociallist.view;

import doppio.config.SociallistConfig;

import javax.swing.*;
import java.awt.*;

public class ButtonHolder extends JPanel {

    SociallistConfig sociallistConfig = new SociallistConfig();

    public ButtonHolder() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(sociallistConfig.getButtonHolderWidth(), sociallistConfig.getButtonHolderHeight()));
        this.setBackground(Color.RED);
        this.setOpaque(true);
    }
}
