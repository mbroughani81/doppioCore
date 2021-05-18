package doppio.apps.post.view.component;

import doppio.config.PostConfig;

import java.awt.*;

public class TweetTextField extends TextField {

    PostConfig postConfig = new PostConfig();

    public TweetTextField() throws HeadlessException {
        this.setPreferredSize(new Dimension(postConfig.getTweetTextFieldWidth(), postConfig.getTweetTextFieldHeight()));
    }
}
