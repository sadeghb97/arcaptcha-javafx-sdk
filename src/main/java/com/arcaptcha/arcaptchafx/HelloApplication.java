package com.arcaptcha.arcaptchafx;

import javafx.application.Application;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        JSInterface jsInterface = new DefaultJSInterface();
        ChallengeConfigs configs = new ChallengeConfigs(jsInterface, "afge5xjsq6","igpro.ir");
        ArcaptchaLauncher.launch(primaryStage, configs);
    }
}