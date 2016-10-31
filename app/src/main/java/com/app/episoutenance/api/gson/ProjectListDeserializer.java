package com.app.episoutenance.api.gson;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.app.episoutenance.api.models.Project;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by banal_a on 30/10/2016.
 */

public class ProjectListDeserializer implements JsonDeserializer<ObservableList<Project>> {
    @Override
    public ObservableList<Project> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Get the "content" element from the parsed JSON
        JsonArray dataSpace = json.getAsJsonObject().getAsJsonArray("projects");
        ObservableList<Project> myList = new ObservableArrayList<>();
        for (JsonElement e : dataSpace)
        {
            myList.add(new Gson().fromJson(e, Project.class));
        }

        return myList;
    }
}
