package doppio.apps.messenger.view.component;

import doppio.datatype.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class NewTypeOptionPanel extends JPanel {

    LinkedList<Pair> pairs;
    LinkedList<JRadioButton> buttons;

    public NewTypeOptionPanel() {
        this.setLayout(new GridBagLayout());
        pairs = new LinkedList<>();
        buttons = new LinkedList<>();
    }

    public void addItem(int id, String name) {
        Pair<Integer, String> pair = new Pair<Integer, String>(id, name);
        pairs.add(pair);
        buttons.clear();

        for (Pair p : pairs) {
            buttons.add(new JRadioButton((String) p.getSecond()));
        }
        updatePanel();
    }

    private void updatePanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        this.removeAll();

        gbc.gridx = 0;
        gbc.gridy = 0;
        for (JRadioButton button : buttons) {
            this.add(button, gbc);
            gbc.gridy++;
        }
    }

    public LinkedList<Integer> getSelectedItemsFirst() {
        LinkedList<Integer> res = new LinkedList<>();
        for (Pair pair : pairs) {
            for (JRadioButton button : buttons) {
                if (button.getText().equals(pair.getSecond())) {
                    if (button.isSelected())
                        res.add((int)pair.getFirst());
                }
            }
        }
        return res;
    }

}
