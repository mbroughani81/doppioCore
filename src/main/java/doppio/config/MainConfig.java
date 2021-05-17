package doppio.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MainConfig {
    private String mainConfigPath = "src/main/resources/config/mainConfig.txt";

    private String authenticationConfigPath;

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
    }

    public String getAuthenticationConfigPath() {
        return authenticationConfigPath;
    }
}
