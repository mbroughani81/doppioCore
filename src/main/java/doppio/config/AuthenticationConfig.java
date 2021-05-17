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
    private int loginPanelErrorLabelWidth;
    private int loginPanelErrorLabelHeight;
    private int loginPanelTextFieldWidth;
    private int loginPanelTextFieldHeight;
    private int loginPanelLabelWidth;
    private int loginPanelLabelHeight;
    private String loginPanelPasswordLabelText;
    private String loginPanelUsernameLabelText;

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
        loginPanelErrorLabelWidth = Integer.parseInt(properties.getProperty("loginPanelErrorLabelWidth"));
        loginPanelErrorLabelHeight = Integer.parseInt(properties.getProperty("loginPanelErrorLabelHeight"));
        loginPanelTextFieldWidth = Integer.parseInt(properties.getProperty("loginPanelTextFieldWidth"));
        loginPanelTextFieldHeight = Integer.parseInt(properties.getProperty("loginPanelTextFieldHeight"));
        loginPanelLabelWidth = Integer.parseInt(properties.getProperty("loginPanelLabelWidth"));
        loginPanelLabelHeight = Integer.parseInt(properties.getProperty("loginPanelLabelHeight"));
        loginPanelPasswordLabelText = properties.getProperty("loginPanelPasswordLabelText");
        loginPanelUsernameLabelText = properties.getProperty("loginPanelUsernameLabelText");
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

    public int getLoginPanelErrorLabelWidth() {
        return loginPanelErrorLabelWidth;
    }

    public int getLoginPanelErrorLabelHeight() {
        return loginPanelErrorLabelHeight;
    }

    public int getLoginPanelTextFieldWidth() {
        return loginPanelTextFieldWidth;
    }

    public int getLoginPanelTextFieldHeight() {
        return loginPanelTextFieldHeight;
    }

    public int getLoginPanelLabelWidth() {
        return loginPanelLabelWidth;
    }

    public int getLoginPanelLabelHeight() {
        return loginPanelLabelHeight;
    }

    public String getLoginPanelPasswordLabelText() {
        return loginPanelPasswordLabelText;
    }

    public String getLoginPanelUsernameLabelText() {
        return loginPanelUsernameLabelText;
    }
}
