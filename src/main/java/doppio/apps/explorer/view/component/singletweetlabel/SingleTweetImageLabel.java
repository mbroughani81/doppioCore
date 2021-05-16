package doppio.apps.explorer.view.component.singletweetlabel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class SingleTweetImageLabel extends JLabel {

    int tweetId;

    public SingleTweetImageLabel(int tweetId) {
        super("", JLabel.CENTER);

        this.tweetId = tweetId;

        this.setBackground(Color.GREEN);
        this.setOpaque(true);

        File file = new File("src/main/resources/tweetimages/" + tweetId + ".jpeg");
        if (!file.exists()) {
            this.setPreferredSize(new Dimension(0, 0));
            return;
        }

        ImageIcon imageIcon = new ImageIcon("src/main/resources/tweetimages/" + tweetId + ".jpeg");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(imageIcon.getIconWidth() / 5, imageIcon.getIconHeight() / 5, Image.SCALE_FAST);
        imageIcon.setImage(newImage);
        this.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
        this.setIcon(imageIcon);
    }
}
