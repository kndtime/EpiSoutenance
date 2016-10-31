package com.app.episoutenance.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by banal_a on 30/10/2016.
 */

public class Defense {

    @SerializedName("id")
    private int id;
    @SerializedName("state")
    private int state;
    @SerializedName("date_begin")
    private int date_begin;
    @SerializedName("date_end")
    private int date_end;
    @SerializedName("student")
    private Student student;
    @SerializedName("acu")
    private Acu acu;

    public Defense() {
        this.id = 0;
        this.state = 0;
        this.date_begin = 0;
        this.date_end = 0;
        this.student = new Student();
        this.acu = new Acu();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(int date_begin) {
        this.date_begin = date_begin;
    }

    public int getDate_end() {
        return date_end;
    }

    public void setDate_end(int date_end) {
        this.date_end = date_end;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Acu getAcu() {
        return acu;
    }

    public void setAcu(Acu acu) {
        this.acu = acu;
    }
}
