package doppio.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AuthenticationConfig {

    private int authenticationFrameWidth;
    private int authenticationFrameHeight;

    public AuthenticationConfig() {
        try {
            setProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setProperties() throws IOException {
        MainConfig mainConfig = new MainConfig();
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(mainConfig.getAuthenticationConfigPath());
        properties.load(fileReader);

        authenticationFrameWidth = Integer.parseInt(properties.getProperty("authenticationFrameWidth"));
        authenticationFrameHeight = Integer.parseInt(properties.getProperty("authenticationFrameHeight"));

    }

    public int getAuthenticationFrameWidth() {
        return authenticationFrameWidth;
    }

    public int getAuthenticationFrameHeight() {
        return authenticationFrameHeight;
    }
}
