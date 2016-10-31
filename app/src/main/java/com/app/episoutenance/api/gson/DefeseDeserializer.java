package com.app.episoutenance.api.gson;

import com.app.episoutenance.api.models.Defense;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by banal_a on 30/10/2016.
 */

public class DefeseDeserializer implements JsonDeserializer<Defense> {
    @Override
    public Defense deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Get the "content" element from the parsed JSON
        JsonElement content = json.getAsJsonObject().get("defense");

        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
        // to this deserializer
        return new Gson().fromJson(content, Defense.class);
    }
}
