package com.adoredeveloper.sweetsbucket.Model;

import com.google.gson.annotations.SerializedName;

public class LoginModel {
    @SerializedName("login")
    public String login;
    @SerializedName("password")
    public String password;

 public LoginModel(String login, String password) {
        this.login = login;
        this.password = password;


    }

}
