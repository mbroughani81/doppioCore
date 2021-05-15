package doppio.apps.personalpage.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ItemListPanel extends JPanel {

    LinkedList<JButton> buttons;

    public ItemListPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
        buttons = new LinkedList<>();
    }

    public void addButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        buttons.add(button);

        updatePanel();
    }

    private void updatePanel() {
        System.out.println("Hmm updatepanel itemlistpanel" + buttons.size());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0.1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        for (JButton button : buttons) {
            this.add(button, gbc);
            gbc.gridy++;
        }

        this.repaint();
        this.revalidate();
    }
}
