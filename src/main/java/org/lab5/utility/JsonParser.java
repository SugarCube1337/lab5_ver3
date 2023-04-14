package org.lab5.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.lab5.data.Route;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.HashSet;

public final class JsonParser {
    private JsonParser() {
    }

    public static HashSet<Route> toData(String json) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                .setPrettyPrinting()
                .create();
        Type typeToken = new TypeToken<HashSet<Route>>() {
        }.getType();
        return gson.fromJson(json.trim(), typeToken);
    }

    public static String toJson(Route collectionData) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                .setPrettyPrinting()
                .create();
        return gson.toJson(collectionData);
    }
}