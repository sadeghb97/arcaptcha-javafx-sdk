module com.arcaptcha.arcaptchafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.desktop;
    requires jdk.jsobject;

    opens com.arcaptcha.arcaptchafx to javafx.fxml;
    exports com.arcaptcha.arcaptchafx;
}