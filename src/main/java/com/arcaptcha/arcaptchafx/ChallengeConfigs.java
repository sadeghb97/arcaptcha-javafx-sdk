package com.arcaptcha.arcaptchafx;

import java.util.HashMap;
import java.util.Map;

public class ChallengeConfigs {
    public JSInterface jsInterface = new DefaultJSInterface();
    public String challengeBaseUrl = "https://igpro.ir/arc.php";
    public String specialChallengeUrl = null;
    public String title = "Arcaptcha Challenge";
    public String siteKey = null;
    public String domain = null;
    public String theme = null;
    public String bgColor = null;

    public ChallengeConfigs(JSInterface jsInterface, String siteKey, String domain) {
        this.jsInterface = jsInterface;
        this.siteKey = siteKey;
        this.domain = domain;
    }

    public ChallengeConfigs(JSInterface jsInterface, String specialChallengeUrl) {
        this.jsInterface = jsInterface;
        this.specialChallengeUrl = specialChallengeUrl;
    }

    private String generateUrlWithParams(String url, HashMap<String, String> params){
        StringBuilder stringBuilder = new StringBuilder(url);

        boolean isFirst = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if(isFirst){
                stringBuilder.append("?");
                isFirst = false;
            }
            else stringBuilder.append("&");
            stringBuilder.append(entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append(entry.getValue());
        }

        return stringBuilder.toString();
    }

    public String getFinalChallengeUrl(){
        if(specialChallengeUrl != null) return specialChallengeUrl;
        HashMap<String, String> params = new HashMap<>();
        params.put("site_key", siteKey);
        params.put("domain", domain);
        if(theme != null && !theme.isBlank()) params.put("theme", theme);
        if(bgColor != null && !bgColor.isBlank()) params.put("bg_color", bgColor);
        return generateUrlWithParams(challengeBaseUrl, params);
    }
}
