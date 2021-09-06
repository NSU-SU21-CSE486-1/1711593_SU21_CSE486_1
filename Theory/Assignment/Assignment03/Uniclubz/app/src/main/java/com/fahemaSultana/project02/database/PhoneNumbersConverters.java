package com.fahemaSultana.project02.database;

import androidx.room.TypeConverter;

import com.fahemaSultana.project02.profile.DataModel.PhoneNumbers;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class PhoneNumbersConverters {

    @TypeConverter
    public static List<PhoneNumbers> fromString(String value) {
        Type listType = new TypeToken<List<PhoneNumbers>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<PhoneNumbers> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

}