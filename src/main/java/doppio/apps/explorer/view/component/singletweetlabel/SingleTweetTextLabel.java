package doppio.apps.explorer.view.component.singletweetlabel;

import doppio.config.ExplorerConfig;

import javax.swing.*;
import java.awt.*;

public class SingleTweetTextLabel extends JLabel {

    ExplorerConfig explorerConfig = new ExplorerConfig();

    public SingleTweetTextLabel(String text) {
        this.setText(text);

        this.setPreferredSize(new Dimension(explorerConfig.getSingleTweetTextLabelWidth(), explorerConfig.getSingleTweetTextLabelHeight()));
    }
}
