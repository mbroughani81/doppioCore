package doppio.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BrowserConfig {

    int appsMenuPanelWidth;
    int appsMenuPanelHeight;

    String personalPageAppButtonText;
    String timelineAppButtonText;
    String explorerAppButtonText;
    String messengerAppButtonText;
    String settingAppButtonText;

    int browserFrameWidth;
    int browserFrameHeight;

    int toolsBarWidth;
    int toolsBarHeight;

    String toolsBarBackButtonText;
    String toolsBarClearMainPanelButtonText;
    String toolsBarExitButtonText;

    public BrowserConfig() {
        try {
            setProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setProperties() throws IOException {
        MainConfig mainConfig = new MainConfig();
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(mainConfig.getBrowserConfigPath());
        properties.load(fileReader);

        appsMenuPanelWidth = Integer.parseInt(properties.getProperty("appsMenuPanelWidth"));
        appsMenuPanelHeight = Integer.parseInt(properties.getProperty("appsMenuPanelHeight"));

        personalPageAppButtonText = properties.getProperty("personalPageAppButtonText");
        timelineAppButtonText = properties.getProperty("timelineAppButtonText");
        explorerAppButtonText = properties.getProperty("explorerAppButtonText");
        messengerAppButtonText = properties.getProperty("messengerAppButtonText");
        settingAppButtonText = properties.getProperty("settingAppButtonText");

        browserFrameWidth = Integer.parseInt(properties.getProperty("browserFrameWidth"));
        browserFrameHeight = Integer.parseInt(properties.getProperty("browserFrameHeight"));

        toolsBarWidth = Integer.parseInt(properties.getProperty("toolsBarWidth"));
        toolsBarHeight = Integer.parseInt(properties.getProperty("toolsBarHeight"));

        toolsBarBackButtonText = properties.getProperty("toolsBarBackButtonText");
        toolsBarClearMainPanelButtonText = properties.getProperty("toolsBarClearMainPanelButtonText");
        toolsBarExitButtonText = properties.getProperty("toolsBarExitButtonText");
    }

    public int getAppsMenuPanelWidth() {
        return appsMenuPanelWidth;
    }

    public int getAppsMenuPanelHeight() {
        return appsMenuPanelHeight;
    }

    public String getPersonalPageAppButtonText() {
        return personalPageAppButtonText;
    }

    public String getTimelineAppButtonText() {
        return timelineAppButtonText;
    }

    public String getExplorerAppButtonText() {
        return explorerAppButtonText;
    }

    public String getMessengerAppButtonText() {
        return messengerAppButtonText;
    }

    public String getSettingAppButtonText() {
        return settingAppButtonText;
    }

    public int getBrowserFrameWidth() {
        return browserFrameWidth;
    }

    public int getBrowserFrameHeight() {
        return browserFrameHeight;
    }

    public int getToolsBarWidth() {
        return toolsBarWidth;
    }

    public int getToolsBarHeight() {
        return toolsBarHeight;
    }

    public String getToolsBarBackButtonText() {
        return toolsBarBackButtonText;
    }

    public String getToolsBarClearMainPanelButtonText() {
        return toolsBarClearMainPanelButtonText;
    }

    public String getToolsBarExitButtonText() {
        return toolsBarExitButtonText;
    }
}
