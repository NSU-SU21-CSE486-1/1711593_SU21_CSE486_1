package com.fahemaSultana.project02.database;

import androidx.room.TypeConverter;

import com.fahemaSultana.project02.profile.DataModel.Universities;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class UniversitiesConverters {
    @TypeConverter
    public static List<Universities> fromString(String value) {
        Type listType = new TypeToken<List<Universities>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<Universities> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}