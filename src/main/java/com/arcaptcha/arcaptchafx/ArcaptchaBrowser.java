package com.arcaptcha.arcaptchafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class ArcaptchaBrowser extends Region {
    private JSInterface bridge;
    private String challengeUrl;
    WebView webView = new WebView();
    WebEngine webEngine = webView.getEngine();

    public ArcaptchaBrowser(ChallengeConfigs configs){
        this.bridge = configs.jsInterface;
        final String challengeUrl = configs.getFinalChallengeUrl();

        webEngine.load(challengeUrl);
        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>(){
                    @Override
                    public void changed(ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) {
                        if(newState == Worker.State.SUCCEEDED){
                            JSObject window = (JSObject)webEngine.executeScript("window");
                            window.setMember("AndroidInterface", bridge);
                        }
                    }
                });


        JSObject window = (JSObject)webEngine.executeScript("window");
        window.setMember("AndroidInterface", bridge);
        getChildren().add(webView);
    }
}
