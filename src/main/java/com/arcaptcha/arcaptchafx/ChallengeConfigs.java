package com.arcaptcha.arcaptchafx;

public class ChallengeConfigs {
    public JSInterface jsInterface = new DefaultJSInterface();
    public String challengeUrl = "https://igpro.ir/arc.php";
    public String title = "Arcaptcha Challenge";

    public ChallengeConfigs(JSInterface jsInterface) {
        this.jsInterface = jsInterface;
    }
}
