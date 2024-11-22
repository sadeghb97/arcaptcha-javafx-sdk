package com.arcaptcha.arcaptchafx;

public class DefaultJSInterface implements JSInterface {
    @Override
    public void passToken(String token) {
        System.out.println("Token: " + token);
    }
}
