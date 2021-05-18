package doppio.apps.explorer.explorerpanel.view;

import doppio.apps.explorer.explorerpanel.listener.SearchBoxListener;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.config.ExplorerConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBox extends JPanel implements ProfileClickInvoker {
    ExplorerConfig explorerConfig = new ExplorerConfig();

    TextField searchField;
    JButton searchButton;

    ProfileClickListener profileClickListener;
    SearchBoxListener searchBoxListener;

    public SearchBox(SearchBoxListener searchBoxListener) {
        this.setPreferredSize(new Dimension(explorerConfig.getExplorerPanelSearchBoxWidth(), explorerConfig.getExplorerPanelSearchBoxHeight()));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;

        searchField = new TextField();
        searchField.setPreferredSize(new Dimension(explorerConfig.getExplorerPanelSearchFieldWidth(), explorerConfig.getExplorerPanelSearchFieldHeight()));
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(searchField, gbc);

        searchButton = new JButton(explorerConfig.getExplorerPanelSearchButtonText());
        searchButton.setPreferredSize(new Dimension(explorerConfig.getExplorerPanelSearchButtonWidth(), explorerConfig.getExplorerPanelSearchButtonHeight()));
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String username = searchField.getText();
                int id = searchBoxListener.getUserId(username);
                if (id != -1)
                    checkProfileClickListener(id);
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(searchButton, gbc);
    }

    @Override
    public void setProfileClickListener(ProfileClickListener listener) {
        this.profileClickListener = listener;
    }

    @Override
    public void checkProfileClickListener(int userId) {
        this.profileClickListener.runProfileClickListener(userId);
    }
}
