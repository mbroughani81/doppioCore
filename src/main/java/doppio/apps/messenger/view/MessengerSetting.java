package doppio.apps.messenger.view;

import doppio.apps.messenger.view.component.NewTypeOptionPanel;
import doppio.apps.messenger.view.listener.MessengerSettingListener;
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

    MessengerSettingListener messengerSettingListener;

    public MessengerSetting(MessengerSettingListener messengerSettingListener) {
        this.messengerSettingListener = messengerSettingListener;

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
            String typeName = JOptionPane.showInputDialog("Write type name :");
            if (!typeName.equals("null")) {
                System.out.println(typeName + " newtypeactionlistener messengersetting");
                NewTypeOptionPanel panel = new NewTypeOptionPanel();
                for (int id : messengerSettingListener.getFollowingIds()) {
                    panel.addItem(id, messengerSettingListener.getUser(id).getUsername());
                }
                int ans = JOptionPane.showOptionDialog(null, panel, "radio test", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);


//                String[] name = {"item1", "item2", "item3"};
//                JPanel panel = new JPanel();
//                panel.setLayout(new GridBagLayout());
//                GridBagConstraints gbc = new GridBagConstraints();
//                gbc.anchor = GridBagConstraints.NORTHWEST;
//                gbc.gridx = 0;
//                gbc.gridy = 0;
//                JRadioButton b1 = new JRadioButton("item1");
//                panel.add(b1, gbc);
//                gbc.gridx = 0;
//                gbc.gridy = 1;
//                JRadioButton b2 = new JRadioButton("item2");
//                panel.add(b2, gbc);
//                gbc.gridx = 0;
//                gbc.gridy = 2;
//                JRadioButton b3 = new JRadioButton("item3");
//                panel.add(b3, gbc);
//                JOptionPane.showInputDialog(null, "salam", "test", JOptionPane.DEFAULT_OPTION, null, name, name[0]);
//                int ans = JOptionPane.showOptionDialog(null, panel, "radio test", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
//                System.out.println(ans + " " + b1.isSelected() + " " + b2.isSelected() + " " + b3.isSelected() + "messengersetting");
            }
        }
    }

}
