package doppio.config;

import doppio.apps.explorer.profilepanel.view.BigProfileLabel;
import doppio.apps.explorer.profilepanel.view.LeftPanel;
import doppio.apps.explorer.profilepanel.view.RightPanel;
import doppio.apps.explorer.view.component.singletweetlabel.ProfilePictureLabel;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ExplorerConfig {

    int explorerPanelSearchBoxWidth;
    int explorerPanelSearchBoxHeight;
    int explorerPanelSearchFieldWidth;
    int explorerPanelSearchFieldHeight;
    String explorerPanelSearchButtonText;
    int explorerPanelSearchButtonWidth;
    int explorerPanelSearchButtonHeight;

    int bigProfileLabelWidth;
    int bigProfileLabelHeight;

    int leftPanelWidth;
    int leftPanelHeight;

    int rightPanelWidth;
    int rightPanelHeight;

    int profilePictureLabelWidth;
    int profilePictureLabelHeight;
    String profileImagesPath;

    int singleTweetBottomBarWidth;
    int singleTweetBottomBarHeight;

    int singleTweetLabelWidth;
    int singleTweetLabelHeight;

    int singleTweetTextLabelWidth;
    int singleTweetTextLabelHeight;
    public ExplorerConfig() {
        try {
            setProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setProperties() throws IOException {
        MainConfig mainConfig = new MainConfig();
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(mainConfig.getExplorerConfigPath());
        properties.load(fileReader);

        explorerPanelSearchBoxWidth = Integer.parseInt(properties.getProperty("explorerPanelSearchBoxWidth"));
        explorerPanelSearchBoxHeight = Integer.parseInt(properties.getProperty("explorerPanelSearchBoxHeight"));
        explorerPanelSearchFieldWidth = Integer.parseInt(properties.getProperty("explorerPanelSearchFieldWidth"));
        explorerPanelSearchFieldHeight = Integer.parseInt(properties.getProperty("explorerPanelSearchFieldHeight"));
        explorerPanelSearchButtonText = properties.getProperty("explorerPanelSearchButtonText");
        explorerPanelSearchButtonWidth = Integer.parseInt(properties.getProperty("explorerPanelSearchButtonWidth"));
        explorerPanelSearchButtonHeight = Integer.parseInt(properties.getProperty("explorerPanelSearchButtonHeight"));

        bigProfileLabelWidth =  Integer.parseInt(properties.getProperty("bigProfileLabelWidth"));
        bigProfileLabelHeight = Integer.parseInt(properties.getProperty("bigProfileLabelHeight"));

        leftPanelWidth = Integer.parseInt(properties.getProperty("leftPanelWidth"));
        leftPanelHeight = Integer.parseInt(properties.getProperty("leftPanelHeight"));

        rightPanelWidth = Integer.parseInt(properties.getProperty("rightPanelWidth"));
        rightPanelHeight = Integer.parseInt(properties.getProperty("rightPanelHeight"));

        profilePictureLabelWidth = Integer.parseInt(properties.getProperty("profilePictureLabelWidth"));
        profilePictureLabelHeight = Integer.parseInt(properties.getProperty("profilePictureLabelHeight"));
        profileImagesPath = properties.getProperty("profileImagesPath");

        singleTweetBottomBarWidth = Integer.parseInt(properties.getProperty("singleTweetBottomBarWidth"));
        singleTweetBottomBarHeight = Integer.parseInt(properties.getProperty("singleTweetBottomBarHeight"));

        singleTweetLabelWidth = Integer.parseInt(properties.getProperty("singleTweetLabelWidth"));
        singleTweetLabelHeight = Integer.parseInt(properties.getProperty("singleTweetLabelHeight"));

        singleTweetTextLabelWidth = Integer.parseInt(properties.getProperty("singleTweetTextLabelWidth"));
        singleTweetTextLabelHeight = Integer.parseInt(properties.getProperty("singleTweetTextLabelHeight"));
    }

    public int getExplorerPanelSearchBoxWidth() {
        return explorerPanelSearchBoxWidth;
    }

    public int getExplorerPanelSearchBoxHeight() {
        return explorerPanelSearchBoxHeight;
    }

    public int getExplorerPanelSearchFieldWidth() {
        return explorerPanelSearchFieldWidth;
    }

    public int getExplorerPanelSearchFieldHeight() {
        return explorerPanelSearchFieldHeight;
    }

    public String getExplorerPanelSearchButtonText() {
        return explorerPanelSearchButtonText;
    }

    public int getExplorerPanelSearchButtonWidth() {
        return explorerPanelSearchButtonWidth;
    }

    public int getExplorerPanelSearchButtonHeight() {
        return explorerPanelSearchButtonHeight;
    }

    public int getBigProfileLabelWidth() {
        return bigProfileLabelWidth;
    }

    public int getBigProfileLabelHeight() {
        return bigProfileLabelHeight;
    }

    public int getLeftPanelWidth() {
        return leftPanelWidth;
    }

    public int getLeftPanelHeight() {
        return leftPanelHeight;
    }

    public int getRightPanelWidth() {
        return rightPanelWidth;
    }

    public int getRightPanelHeight() {
        return rightPanelHeight;
    }

    public int getProfilePictureLabelWidth() {
        return profilePictureLabelWidth;
    }

    public int getProfilePictureLabelHeight() {
        return profilePictureLabelHeight;
    }

    public String getProfileImagesPath() {
        return profileImagesPath;
    }

    public int getSingleTweetBottomBarWidth() {
        return singleTweetBottomBarWidth;
    }

    public int getSingleTweetBottomBarHeight() {
        return singleTweetBottomBarHeight;
    }

    public int getSingleTweetLabelWidth() {
        return singleTweetLabelWidth;
    }

    public int getSingleTweetLabelHeight() {
        return singleTweetLabelHeight;
    }

    public int getSingleTweetTextLabelWidth() {
        return singleTweetTextLabelWidth;
    }

    public int getSingleTweetTextLabelHeight() {
        return singleTweetTextLabelHeight;
    }
}
