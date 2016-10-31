package com.app.episoutenance.api.models;

import com.google.gson.annotations.SerializedName;

import static android.R.attr.id;

/**
 * Created by banal_a on 30/10/2016.
 */

public class Student {

    @SerializedName("id")
    private int id;
    @SerializedName("login")
    private String login;

    public Student() {
        this.id = 0;
        this.login = "";
    }

    public Student(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
