package doppio.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MessengerConfig {

    int messengerSettingWidth;
    int messengerSettingHeight;

    int pmImageLabelWidth;
    int pmImageLabelHeight;
    String pmImagePath;

    int pmLabelWidth;
    int pmLabelHeight;

    public MessengerConfig() {
        try {
            setProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setProperties() throws IOException {
        MainConfig mainConfig = new MainConfig();
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(mainConfig.getMessengerConfigPath());
        properties.load(fileReader);

        messengerSettingWidth = Integer.parseInt(properties.getProperty("messengerSettingWidth"));
        messengerSettingHeight = Integer.parseInt(properties.getProperty("messengerSettingHeight"));

        pmImageLabelWidth = Integer.parseInt(properties.getProperty("pmImageLabelWidth"));
        pmImageLabelHeight = Integer.parseInt(properties.getProperty("pmImageLabelHeight"));
        pmImagePath = properties.getProperty("pmImagePath");

        pmLabelWidth = Integer.parseInt(properties.getProperty("pmLabelWidth"));
        pmLabelHeight = Integer.parseInt(properties.getProperty("pmLabelHeight"));
    }

    public int getMessengerSettingWidth() {
        return messengerSettingWidth;
    }

    public int getMessengerSettingHeight() {
        return messengerSettingHeight;
    }

    public int getPmImageLabelWidth() {
        return pmImageLabelWidth;
    }

    public int getPmImageLabelHeight() {
        return pmImageLabelHeight;
    }

    public String getPmImagePath() {
        return pmImagePath;
    }

    public int getPmLabelWidth() {
        return pmLabelWidth;
    }

    public int getPmLabelHeight() {
        return pmLabelHeight;
    }
}
