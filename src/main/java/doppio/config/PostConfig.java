package doppio.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PostConfig {
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
    }
}
