package doppio;

import doppio.apps.authentication.view.AuthenticationWindow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

public class Main {
    static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.trace("Doppio started");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AuthenticationWindow();
            }
        });
    }
}
