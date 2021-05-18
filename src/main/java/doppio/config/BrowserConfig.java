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
}
