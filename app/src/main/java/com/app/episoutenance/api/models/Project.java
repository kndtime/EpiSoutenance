package com.app.episoutenance.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by banal_a on 30/10/2016.
 */

public class Project {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("creation_date")
    private int creation_date;
    @SerializedName("defenses")
    ArrayList<Defense> defenses;

    public Project() {
        this.id = 0;
        this.name = "";
        this.creation_date = 0;
        this.defenses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(int creation_date) {
        this.creation_date = creation_date;
    }

    public ArrayList<Defense> getDefenses() {
        return defenses;
    }

    public void setDefenses(ArrayList<Defense> defenses) {
        this.defenses = defenses;
    }
}
