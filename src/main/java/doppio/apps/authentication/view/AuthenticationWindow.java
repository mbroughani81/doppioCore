package doppio.apps.authentication.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationWindow {
    static Logger logger = LogManager.getLogger(AuthenticationWindow.class);

    AuthenticationFrame frame;

    public AuthenticationWindow() {
        logger.trace("AuthenticationWindow is created");

        this.frame = new AuthenticationFrame();
    }
}
