package doppio.apps.messenger.view.component.messageinput;

import doppio.apps.messenger.view.component.listener.MessageInputPanelListener;
import doppio.listener.StringInvoker;
import doppio.listener.StringListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class MessageInputPanel extends JPanel implements ActionListener, StringInvoker {
//

    TextField messageText;
    JButton sendButton;
    JButton selectImageButton;
    String imagePath = "";


    LinkedList<StringListener> stringListeners;
    MessageInputPanelListener messageInputPanelListener;

    public MessageInputPanel(MessageInputPanelListener messageInputPanelListener) {
        this.messageInputPanelListener = messageInputPanelListener;

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(700, 100));
        this.setBackground(Color.GREEN);
        this.setOpaque(true);

        messageText = new MessageInputTextField();
        sendButton = new MessageSendButton();
        sendButton.addActionListener(this);
        selectImageButton = new MessageSelectImageButton();
        selectImageButton.addActionListener(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0.1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(messageText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(selectImageButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(sendButton, gbc);

        stringListeners = new LinkedList<>();
    }

    public TextField getMessageText() {
        return messageText;
    }

    public void setMessageText(TextField messageText) {
        this.messageText = messageText;
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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton) {
            int pmId = messageInputPanelListener.sendNewPm(this.messageText.getText(), messageInputPanelListener.getChatId());
            if (imagePath.length() > 0) {
                File file = new File(imagePath);

                Path path2 = Paths.get("src/main/resources/pmimages/");

                Path file1 = Paths.get(file.getAbsolutePath());
                Path file2 = path2.resolve(pmId + ".jpeg");

                try {
                    Files.deleteIfExists(file2);
                } catch (IOException ee) {
                    ee.printStackTrace();
                }

                System.out.println(file1.toAbsolutePath() + "  messageinputpanel");
                System.out.println(file2.toAbsolutePath() + "  messageinputpanel");

                try {
                    Files.copy(file1, file2);
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
                imagePath = "";
            }
            checkListeners("sendButtonClickMessageInputPanel");

        }
        if (e.getSource() == selectImageButton) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("/home/mohammadbroughani/Pictures/niceimages/"));

            int respond = fileChooser.showOpenDialog(null);
            if (fileChooser.getSelectedFile() != null && respond == JFileChooser.APPROVE_OPTION) {
                imagePath = fileChooser.getSelectedFile().getAbsolutePath();
            }
        }
    }
}
