package doppio.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MessengerConfig {
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
    }
}
