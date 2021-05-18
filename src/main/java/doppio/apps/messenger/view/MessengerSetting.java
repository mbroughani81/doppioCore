package doppio.apps.messenger.view;

import doppio.apps.messenger.model.UserType;
import doppio.apps.messenger.view.component.NewTypeOptionPanel;
import doppio.apps.messenger.view.listener.MessengerSettingListener;
import doppio.apps.personalpage.view.ItemListPanel;
import doppio.event.NewGroupChatEvent;
import doppio.event.NewPmEvent;
import doppio.event.NewUserTypeEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

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
            String messageText = JOptionPane.showInputDialog("Write message :");
            if (messageText != null) {
                NewTypeOptionPanel panel1 = new NewTypeOptionPanel();
                for (UserType userType : messengerSettingListener.getTypes()) {
                    panel1.addItem(userType.getId(), userType.getUserTypeName());
                }
                NewTypeOptionPanel panel2 = new NewTypeOptionPanel();
                for (int id : messengerSettingListener.getFollowingIds()) {
                    panel2.addItem(id, messengerSettingListener.getUser(id).getUsername());
                }
                int ans1 = JOptionPane.showOptionDialog(null, panel1, "Choose UserTypes", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                int ans2 = JOptionPane.showOptionDialog(null, panel2, "Choose User", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                LinkedList<Integer> userIds = new LinkedList<>();
                if (ans1 == 0) {
                    for (int id : panel1.getSelectedItemsFirst()) {
                        for (int userId : messengerSettingListener.getUserType(id).getUserIds()) {
                            if (!userIds.contains(userId))
                                userIds.add(userId);
                        }
                    }
                }
                if (ans2 == 0) {
                    for (int id : panel2.getSelectedItemsFirst()) {
                        if (!userIds.contains(id))
                            userIds.add(id);
                    }
                }
                for (int id : userIds) {
                    int chatId = messengerSettingListener.getChatId(id);
                    NewPmEvent event = new NewPmEvent(messengerSettingListener.getUser().getId(), chatId, messageText);
                    messengerSettingListener.newPm(event);
                }
            }
        }
    }

    class NewGroupActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String groupName = JOptionPane.showInputDialog("Write group name :");
            if (groupName != null) {
                System.out.println(groupName + " newgroupactionlistener messengersetting");
                NewTypeOptionPanel panel = new NewTypeOptionPanel();
                for (int id : messengerSettingListener.getFollowingIds()) {
                    panel.addItem(id, messengerSettingListener.getUser(id).getUsername());
                }
                int ans;
                do {
                    ans = JOptionPane.showOptionDialog(null, panel, "New Group", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                } while (ans == 0 && panel.getSelectedItemsFirst().size() == 0);

                for (int id : panel.getSelectedItemsFirst()) {
                    System.out.println(id + " is selected messneesetting");

                }
                if (ans == 0) {
                    LinkedList<Integer> groupMembers = panel.getSelectedItemsFirst();
                    groupMembers.add(messengerSettingListener.getUser().getId());
                    NewGroupChatEvent event = new NewGroupChatEvent(
                            groupName,
                            messengerSettingListener.getUser().getId(),
                            groupMembers
                    );
                    int chatId = messengerSettingListener.newGroupChat(event);
                    for (int userId : groupMembers) {
                        NewPmEvent e = new NewPmEvent(userId, chatId, userId + " joined the group");
                        messengerSettingListener.newPm(e);
                    }
                }
            }
        }
    }

    class NewTypeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String typeName = JOptionPane.showInputDialog("Write type name :");
            if (typeName != null) {
                System.out.println(typeName + " newtypeactionlistener messengersetting");
                NewTypeOptionPanel panel = new NewTypeOptionPanel();
                for (int id : messengerSettingListener.getFollowingIds()) {
                    panel.addItem(id, messengerSettingListener.getUser(id).getUsername());
                }
                int ans;
                do {
                    ans = JOptionPane.showOptionDialog(null, panel, "New Type", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                } while (ans == 0 && panel.getSelectedItemsFirst().size() == 0);

                if (ans == 0) {
                    NewUserTypeEvent event = new NewUserTypeEvent(
                            typeName,
                            messengerSettingListener.getUser().getId(),
                            panel.getSelectedItemsFirst()
                    );
                    messengerSettingListener.newUserType(event);
                }
            }

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
