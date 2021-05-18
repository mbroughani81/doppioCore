package doppio.apps.explorer.profilepanel.view;

import doppio.config.ExplorerConfig;

import javax.swing.*;
import java.awt.*;

public class BigProfileLabel extends JLabel {
    ExplorerConfig explorerConfig = new ExplorerConfig();

    int userId;

    public BigProfileLabel(int userId) {
        this.userId = userId;

        this.setPreferredSize(new Dimension(explorerConfig.getBigProfileLabelWidth(), explorerConfig.getBigProfileLabelHeight()));
        this.setBackground(Color.DARK_GRAY);
        this.setOpaque(true);

        ImageIcon imageIcon = new ImageIcon("src/main/resources/profileimages/" + userId + ".jpeg");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(explorerConfig.getBigProfileLabelWidth(), explorerConfig.getBigProfileLabelHeight(), Image.SCALE_FAST);
        imageIcon.setImage(newImage);
        this.setIcon(imageIcon);


    }
}
