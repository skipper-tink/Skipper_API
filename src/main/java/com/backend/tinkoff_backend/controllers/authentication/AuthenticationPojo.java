package com.backend.tinkoff_backend.controllers.authentication;

public class AuthenticationPojo {
    private String login;
    private String password;

    public  AuthenticationPojo() {}

    public AuthenticationPojo(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
