package doppio.apps.browser.view;

import doppio.config.BrowserConfig;
import doppio.listener.StringInvoker;
import doppio.listener.StringListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ToolsBar extends JPanel implements StringInvoker, ActionListener {

    BrowserConfig browserConfig = new BrowserConfig();

    JButton backButton;
    JButton clearMainPanelButton;
    JButton exitButton;

    LinkedList<StringListener> stringListeners;

    public ToolsBar() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(browserConfig.getToolsBarWidth(), browserConfig.getToolsBarHeight()));
        this.setBackground(Color.YELLOW);
        this.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();

        this.backButton = new JButton(browserConfig.getToolsBarBackButtonText());
        this.backButton.addActionListener(this);
        this.clearMainPanelButton = new JButton(browserConfig.getToolsBarClearMainPanelButtonText());
        this.clearMainPanelButton.addActionListener(this);
        this.exitButton = new JButton(browserConfig.getToolsBarExitButtonText());
        this.exitButton.addActionListener(this);

        gbc.weightx = 0.1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(this.backButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(this.clearMainPanelButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(this.exitButton, gbc);

        stringListeners = new LinkedList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.backButton) {
            checkListeners("backClickToolsBar");
        }
        if (e.getSource() == this.exitButton) {
            checkListeners("exitClickToolsBar");
        }
        if (e.getSource() == this.clearMainPanelButton) {
            checkListeners("clearMainPanelClickToolsBar");
        }
    }

    @Override
    public void checkListeners(String s) {
        for (StringListener listener : stringListeners)
            listener.run(s);
    }

    @Override
    public void addListener(StringListener listener) {
        stringListeners.add(listener);
    }
}
