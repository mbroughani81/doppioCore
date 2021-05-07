package doppio.apps.messenger.view.component;

import doppio.listener.StringInvoker;
import doppio.listener.StringListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class MessageInputPanel extends JPanel implements ActionListener, StringInvoker {

    TextField messageText;
    JButton sendButton;

    LinkedList<StringListener> stringListeners;

    public MessageInputPanel() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(700, 100));
        this.setBackground(Color.GREEN);
        this.setOpaque(true);

        messageText = new MessageInputTextField();
        sendButton = new MessageSendButton();
        sendButton.addActionListener(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0.1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(messageText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(sendButton, gbc);

        stringListeners = new LinkedList<>();
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        checkListeners("sendButtonClickMessageInputPanel");
    }
}
