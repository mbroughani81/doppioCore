package doppio.apps.browser.view;

import doppio.listener.StringInvoker;
import doppio.listener.StringListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ToolsBar extends JPanel implements StringInvoker, ActionListener {

    JButton backButton;
    JButton clearMainPanelButton;
    JButton exitButton;

    LinkedList<StringListener> stringListeners;

    public ToolsBar() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(0, 50));
        this.setBackground(Color.YELLOW);
        this.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();

        this.backButton = new JButton("Back");
        this.backButton.addActionListener(this);
        this.clearMainPanelButton = new JButton("Main Page");
        this.exitButton = new JButton("Exit");

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
