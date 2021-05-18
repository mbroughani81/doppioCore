package doppio.apps.messenger.view.component.pmlabel;

import doppio.config.MessengerConfig;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PmImageLabel extends JLabel {

    MessengerConfig messengerConfig = new MessengerConfig();

    int pmId;

    public PmImageLabel(int pmId) {
        super("", JLabel.CENTER);

        this.pmId = pmId;

        this.setBackground(Color.RED);
        this.setOpaque(true);

        File file = new File(messengerConfig.getPmImagePath() + pmId + ".jpeg");
        if (!file.exists()) {
            this.setPreferredSize(new Dimension(0, 0));
            return;
        }

        ImageIcon imageIcon = new ImageIcon(messengerConfig.getPmImagePath() + pmId + ".jpeg");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(messengerConfig.getPmImageLabelWidth(), messengerConfig.getPmImageLabelHeight(), Image.SCALE_FAST);
        imageIcon.setImage(newImage);
        this.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
        this.setIcon(imageIcon);
    }
}
