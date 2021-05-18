package doppio.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SociallistConfig {

    int buttonHolderWidth;
    int buttonHolderHeight;
    int inboxRequestLabelWidth;
    int inboxRequestLabelHeight;


    public SociallistConfig() {
        try {
            setProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setProperties() throws IOException {
        MainConfig mainConfig = new MainConfig();
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(mainConfig.getSociallistConfigPath());
        properties.load(fileReader);

        buttonHolderWidth = Integer.parseInt(properties.getProperty("buttonHolderWidth"));
        buttonHolderHeight = Integer.parseInt(properties.getProperty("buttonHolderHeight"));

        inboxRequestLabelWidth = Integer.parseInt(properties.getProperty("inboxRequestLabelWidth"));
        inboxRequestLabelHeight = Integer.parseInt(properties.getProperty("inboxRequestLabelHeight"));
    }

    public int getButtonHolderWidth() {
        return buttonHolderWidth;
    }

    public int getButtonHolderHeight() {
        return buttonHolderHeight;
    }

    public int getInboxRequestLabelWidth() {
        return inboxRequestLabelWidth;
    }

    public int getInboxRequestLabelHeight() {
        return inboxRequestLabelHeight;
    }
}
