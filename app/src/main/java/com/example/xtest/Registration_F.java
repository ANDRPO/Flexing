package com.example.xtest;

public class Registration_F {
    private String login, password, name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Registration_F(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }
}
