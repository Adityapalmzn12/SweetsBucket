package com.adoredeveloper.sweetsbucket.Model;

import com.google.gson.annotations.SerializedName;

public class SignUpModel {
    @SerializedName("name")
    public String name;
    @SerializedName("email")
    public String email;
    @SerializedName("mobile")
    public String mobile;
    @SerializedName("password")
    public String password;
    @SerializedName("password_confirmation")
    public String password_confirmation;



    public SignUpModel(String name, String email, String mobile, String password, String password_confirmation) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.password_confirmation = password_confirmation;

    }
}
