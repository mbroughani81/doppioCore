package doppio.apps.messenger.view.component;

import doppio.apps.browser.view.BrowserFrame;
import doppio.apps.explorer.view.component.SingleTweetLabel;
import doppio.apps.explorer.view.component.tweetlist.view.TweetListPanel;
import doppio.apps.messenger.model.Pm;
import doppio.apps.post.model.Tweet;
import doppio.listener.StringInvoker;
import doppio.listener.StringListener;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.jar.JarEntry;

public class PmListPanel extends JPanel {

    LinkedList<Pm> pms;
    HashMap<Integer, Color> colorMap;

    public PmListPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.MAGENTA);
        this.setOpaque(true);

        pms = new LinkedList<>();

    }

    public void addPm(Pm pm) {
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
            this.add(label, gbc);
            gbc.gridy++;
        }
        System.out.println(pms.size() + " should be more then one after click!!! pmlistpnael const");
    }


}
