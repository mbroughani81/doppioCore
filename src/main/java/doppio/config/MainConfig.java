package doppio.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MainConfig {
    private String mainConfigPath = "src/main/resources/config/mainConfig.txt";

    private String authenticationConfigPath;
    private String browserConfigPath;
    private String explorerConfigPath;
    private String messengerConfigPath;
    private String personalpageConfigPath;
    private String postConfigPath;
    private String settingConfigPath;
    private String sociallistConfigPath;
    private String timelineConfigPath;

    public MainConfig() {
        try {
            setProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setProperties() throws IOException {
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(mainConfigPath);
        properties.load(fileReader);

        authenticationConfigPath = properties.getProperty("authenticationConfigPath");
        browserConfigPath = properties.getProperty("browserConfigPath") ;
        explorerConfigPath = properties.getProperty("explorerConfigPath");
        messengerConfigPath = properties.getProperty("messengerConfigPath");
        personalpageConfigPath = properties.getProperty("personalpageConfigPath");
        postConfigPath = properties.getProperty("postConfigPath");
        settingConfigPath = properties.getProperty("settingConfigPath");
        sociallistConfigPath = properties.getProperty("sociallistConfigPath");
        timelineConfigPath = properties.getProperty("timelineConfigPath");
    }

    public String getAuthenticationConfigPath() {
        return authenticationConfigPath;
    }

    public String getBrowserConfigPath() {
        return browserConfigPath;
    }

    public String getExplorerConfigPath() {
        return explorerConfigPath;
    }

    public String getMessengerConfigPath() {
        return messengerConfigPath;
    }

    public String getPersonalpageConfigPath() {
        return personalpageConfigPath;
    }

    public String getPostConfigPath() {
        return postConfigPath;
    }

    public String getSettingConfigPath() {
        return settingConfigPath;
    }

    public String getSociallistConfigPath() {
        return sociallistConfigPath;
    }

    public String getTimelineConfigPath() {
        return timelineConfigPath;
    }
}
