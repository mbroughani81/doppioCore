package doppio.apps.post.view.component;

import java.awt.*;

public class TweetTextField extends TextField {
    public TweetTextField() throws HeadlessException {
        this.setPreferredSize(new Dimension(400, 100));
    }
}
