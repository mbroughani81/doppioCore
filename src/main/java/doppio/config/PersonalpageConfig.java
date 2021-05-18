package doppio.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PersonalpageConfig {

    int profileListPanelWidth;
    int profileListPanelHeight;

    public PersonalpageConfig() {
        try {
            setProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setProperties() throws IOException {
        MainConfig mainConfig = new MainConfig();
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(mainConfig.getPersonalpageConfigPath());
        properties.load(fileReader);

        profileListPanelWidth = Integer.parseInt(properties.getProperty("profileListPanelWidth"));
        profileListPanelHeight = Integer.parseInt(properties.getProperty("profileListPanelHeight"));

    }

    public int getProfileListPanelWidth() {
        return profileListPanelWidth;
    }

    public int getProfileListPanelHeight() {
        return profileListPanelHeight;
    }
}
