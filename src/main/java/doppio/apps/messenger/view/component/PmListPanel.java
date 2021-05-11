package doppio.apps.messenger.view.component;

import doppio.apps.messenger.model.Pm;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class PmListPanel extends JPanel {

    LinkedList<Pm> pms;
    HashMap<Integer, Integer> pmPos;

    public PmListPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.MAGENTA);
        this.setOpaque(true);

        pms = new LinkedList<>();
        pmPos = new HashMap<>();

    }

    public void addPm(Pm pm, int pos) {
        pmPos.put(pm.getId(), pos);
        pms.add(pm);
        GridBagConstraints gbc = new GridBagConstraints();

        this.removeAll();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        for (Pm pm1 : pms) {
            PmLabel label = new PmLabel(pm1);
            if (pmPos.get(pm1.getId()) == 0)
                gbc.gridx = 0;
            if (pmPos.get(pm1.getId()) == 1)
                gbc.gridx = 1;
            this.add(label, gbc);
            gbc.gridy++;
        }
        System.out.println(pms.size() + " should be more then one after click!!! pmlistpnael const");
    }


}

