package doppio.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AuthenticationConfig {

    private int authenticationFrameWidth;
    private int authenticationFrameHeight;
    private int loginButtonWidth;
    private int loginButtonHeight;
    private String loginButtonText;

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
        loginButtonWidth = Integer.parseInt(properties.getProperty("loginButtonWidth"));
        loginButtonHeight = Integer.parseInt(properties.getProperty("loginButtonHeight"));
        loginButtonText = properties.getProperty("loginButtonText");

    }

    public int getAuthenticationFrameWidth() {
        return authenticationFrameWidth;
    }

    public int getAuthenticationFrameHeight() {
        return authenticationFrameHeight;
    }

    public int getLoginButtonWidth() {
        return loginButtonWidth;
    }

    public int getLoginButtonHeight() {
        return loginButtonHeight;
    }

    public String getLoginButtonText() {
        return loginButtonText;
    }
}
