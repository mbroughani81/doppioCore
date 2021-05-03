package doppio.apps.browser.view;

import javax.swing.*;
import java.awt.*;

public class BrowserFrame extends JFrame {

    MainPanel mainPanel;
    AppsMenuPanel menuPanel;
    ToolsBar toolsBar;

    public BrowserFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.setVisible(true);

        mainPanel = new MainPanel();
        this.add(mainPanel, BorderLayout.CENTER);

        menuPanel = new AppsMenuPanel();
        mainPanel.add(menuPanel, BorderLayout.WEST);

        toolsBar = new ToolsBar();
        mainPanel.add(toolsBar, BorderLayout.NORTH);
    }
}
