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
    private String signupButtonText;

    private int loginPanelErrorLabelWidth;
    private int loginPanelErrorLabelHeight;
    private int loginPanelTextFieldWidth;
    private int loginPanelTextFieldHeight;
    private int loginPanelLabelWidth;
    private int loginPanelLabelHeight;
    private String loginPanelPasswordLabelText;
    private String loginPanelUsernameLabelText;
    private int logoPanelWidth;
    private int logoPanelHeight;

    private String signupPanelNameLabelText;
    private String signupPanelUsernameLabelText;
    private String signupPanelPasswordLabelText;
    private String signupPanelBirthdayLabelText;
    private String signupPanelEmailLabelText;
    private String signupPanelPhonenumberLabelText;
    private String signupPanelBioLabelText;


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
        signupButtonText = properties.getProperty("signupButtonText");

        loginPanelErrorLabelWidth = Integer.parseInt(properties.getProperty("loginPanelErrorLabelWidth"));
        loginPanelErrorLabelHeight = Integer.parseInt(properties.getProperty("loginPanelErrorLabelHeight"));
        loginPanelTextFieldWidth = Integer.parseInt(properties.getProperty("loginPanelTextFieldWidth"));
        loginPanelTextFieldHeight = Integer.parseInt(properties.getProperty("loginPanelTextFieldHeight"));
        loginPanelLabelWidth = Integer.parseInt(properties.getProperty("loginPanelLabelWidth"));
        loginPanelLabelHeight = Integer.parseInt(properties.getProperty("loginPanelLabelHeight"));
        loginPanelPasswordLabelText = properties.getProperty("loginPanelPasswordLabelText");
        loginPanelUsernameLabelText = properties.getProperty("loginPanelUsernameLabelText");

        logoPanelWidth = Integer.parseInt(properties.getProperty("logoPanelWidth"));
        logoPanelHeight = Integer.parseInt(properties.getProperty("logoPanelHeight"));

        signupPanelNameLabelText = properties.getProperty("signupPanelNameLabelText");
        signupPanelUsernameLabelText = properties.getProperty("signupPanelUsernameLabelText");
        signupPanelPasswordLabelText = properties.getProperty("signupPanelPasswordLabelText");
        signupPanelBirthdayLabelText = properties.getProperty("signupPanelBirthdayLabelText");
        signupPanelEmailLabelText = properties.getProperty("signupPanelEmailLabelText");
        signupPanelPhonenumberLabelText = properties.getProperty("signupPanelPhonenumberLabelText");
        signupPanelBioLabelText = properties.getProperty("signupPanelBioLabelText");
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

    public String getSignupButtonText() {
        return signupButtonText;
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

    public int getLogoPanelWidth() {
        return logoPanelWidth;
    }

    public int getLogoPanelHeight() {
        return logoPanelHeight;
    }

    public String getSignupPanelNameLabelText() {
        return signupPanelNameLabelText;
    }

    public String getSignupPanelUsernameLabelText() {
        return signupPanelUsernameLabelText;
    }

    public String getSignupPanelPasswordLabelText() {
        return signupPanelPasswordLabelText;
    }

    public String getSignupPanelBirthdayLabelText() {
        return signupPanelBirthdayLabelText;
    }

    public String getSignupPanelEmailLabelText() {
        return signupPanelEmailLabelText;
    }

    public String getSignupPanelPhonenumberLabelText() {
        return signupPanelPhonenumberLabelText;
    }

    public String getSignupPanelBioLabelText() {
        return signupPanelBioLabelText;
    }
}
