package com.arcaptcha.arcaptchafx;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ArcaptchaLauncher {
    public static void launch(Stage stage, ChallengeConfigs configs){
        stage.setTitle(configs.title);

        ArcaptchaBrowser myBrowser = new ArcaptchaBrowser(configs);
        Scene scene = new Scene(myBrowser, 800, 600);

        stage.setScene(scene);
        stage.show();
    }
}
