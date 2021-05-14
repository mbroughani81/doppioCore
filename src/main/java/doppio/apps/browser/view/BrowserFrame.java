package doppio.apps.browser.view;

import doppio.apps.authentication.view.AuthenticationWindow;
import doppio.apps.browser.listener.MainPanelToAppsMenuPanelListener;
import doppio.listener.StringListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class BrowserFrame extends JFrame {
    static Logger logger = LogManager.getLogger(BrowserFrame.class);

    MainPanel mainPanel;
    AppsMenuPanel menuPanel;
    ToolsBar toolsBar;
    JPanel appPlace;

    public BrowserFrame() {
        logger.trace("BrowserFrame is created");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.setVisible(true);

        mainPanel = new MainPanel();
        this.add(mainPanel, BorderLayout.CENTER);

        menuPanel = new AppsMenuPanel();
        menuPanel.addListener(new MainPanelToAppsMenuPanelListener(mainPanel));
        mainPanel.add(menuPanel, BorderLayout.WEST);

        toolsBar = new ToolsBar();
        toolsBar.addListener(new StringListener() {
            @Override
            public void run(String s) {
                if (s.equals("backClickToolsBar")) {
                    mainPanel.undo();
                    System.out.println("good cons browsergframe");
                }
            }
        });
        mainPanel.add(toolsBar, BorderLayout.NORTH);

        appPlace = new JPanel();
        mainPanel.add(appPlace, BorderLayout.CENTER);
    }
}
