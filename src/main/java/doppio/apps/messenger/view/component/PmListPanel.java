package doppio.apps.messenger.view.component;

import doppio.apps.messenger.model.Pm;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class PmListPanel extends JPanel {
    LinkedList<Pm> pms;
    HashMap<Integer, Color> colorMap;

    public PmListPanel() {
        this.setLayout(new GridBagLayout());

        pms = new LinkedList<>();
        colorMap = new HashMap<>();
    }

    public void setUserIdColor(int userId, Color color) {
        colorMap.put(userId, color);
    }

    public Color getUserIdColor(int userId) {
        return colorMap.get(userId);
    }

    public void addPm(Pm pm) {
        pms.add(pm);

        updatePanel();
    }

    private void updatePanel() {
        this.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        for (Pm pm : pms) {
            PmLabel pmLabel = new PmLabel(pm.getText());
            pmLabel.setBackground(getUserIdColor(pm.getUserId()));
            this.add(pmLabel, gbc);
            gbc.gridy++;
        }
        repaint();
        revalidate();
    }
}
