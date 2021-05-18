package doppio.apps.messenger.view.component.pmlabel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PmImageLabel extends JLabel {

    int pmId;

    public PmImageLabel(int pmId) {
        super("", JLabel.CENTER);

        this.pmId = pmId;

        this.setBackground(Color.RED);
        this.setOpaque(true);

        File file = new File("src/main/resources/pmimages/" + pmId + ".jpeg");
        if (!file.exists()) {
            this.setPreferredSize(new Dimension(0, 0));
            return;
        }

        ImageIcon imageIcon = new ImageIcon("src/main/resources/pmimages/" + pmId + ".jpeg");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(50, 50, Image.SCALE_FAST);
        imageIcon.setImage(newImage);
        this.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
        this.setIcon(imageIcon);
//        this.setPreferredSize(new Dimension(100, 50));
    }
}
