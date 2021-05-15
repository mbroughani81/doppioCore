package doppio.apps.messenger.view;

import doppio.apps.personalpage.view.ItemListPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessengerSetting extends JPanel {

    ActionListener multiPmAction;
    ActionListener newGroupAction;
    ActionListener newTypeAction;

    ItemListPanel itemListPanel;

    public MessengerSetting() {
        this.setPreferredSize(new Dimension(300, 0));
        this.setLayout(new BorderLayout());

        multiPmAction = new MultiPmActionListener();
        newGroupAction = new NewGroupActionListener();
        newTypeAction = new NewTypeActionListener();

        itemListPanel = new ItemListPanel();
        itemListPanel.addButton("MultiPm", multiPmAction);
        itemListPanel.addButton("New group", newGroupAction);
        itemListPanel.addButton("New type", newTypeAction);
        this.add(itemListPanel, BorderLayout.CENTER);
    }

    class MultiPmActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }

    class NewGroupActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }

    class NewTypeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }

}
