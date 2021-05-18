package doppio.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PostConfig {

    String tweetImagesPath;

    int selectImageButtonWidth;
    int selectImageButtonHeight;

    int sendTweetButtonWidth;
    int sendTweetButtonHeight;

    int tweetTextFieldWidth;
    int tweetTextFieldHeight;


    public PostConfig() {
        try {
            setProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setProperties() throws IOException {
        MainConfig mainConfig = new MainConfig();
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(mainConfig.getPostConfigPath());
        properties.load(fileReader);

        tweetImagesPath = properties.getProperty("tweetImagesPath");

        selectImageButtonWidth = Integer.parseInt(properties.getProperty("selectImageButtonWidth"));
        selectImageButtonHeight = Integer.parseInt(properties.getProperty("selectImageButtonHeight"));

        sendTweetButtonWidth = Integer.parseInt(properties.getProperty("sendTweetButtonWidth"));
        sendTweetButtonHeight = Integer.parseInt(properties.getProperty("sendTweetButtonHeight"));

        tweetTextFieldWidth = Integer.parseInt(properties.getProperty("tweetTextFieldWidth"));
        tweetTextFieldHeight = Integer.parseInt(properties.getProperty("tweetTextFieldHeight"));

    }

    public String getTweetImagesPath() {
        return tweetImagesPath;
    }

    public int getSelectImageButtonWidth() {
        return selectImageButtonWidth;
    }

    public int getSelectImageButtonHeight() {
        return selectImageButtonHeight;
    }

    public int getSendTweetButtonWidth() {
        return sendTweetButtonWidth;
    }

    public int getSendTweetButtonHeight() {
        return sendTweetButtonHeight;
    }

    public int getTweetTextFieldWidth() {
        return tweetTextFieldWidth;
    }

    public int getTweetTextFieldHeight() {
        return tweetTextFieldHeight;
    }
}
