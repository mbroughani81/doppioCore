package doppio.apps.browser.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BrowserWindow {
    static Logger logger = LogManager.getLogger(BrowserWindow.class);

    BrowserFrame frame;

    public BrowserWindow() {
        logger.trace("BrowserWindow is created");

        this.frame = new BrowserFrame();
    }


}
