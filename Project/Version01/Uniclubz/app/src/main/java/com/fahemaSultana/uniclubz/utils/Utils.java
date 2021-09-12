package com.fahemaSultana.uniclubz.utils;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static <T> T jsonToObject(String content, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(content, type);
    }


    public static <T> List<T> jsonToObjectList(String s, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(s, clazz);
        if (arr != null)
            return new ArrayList<>(Arrays.asList(arr));
        else
            return new ArrayList<>();
    }

    public static String objectToJson(Object value) {
        Gson gson = new Gson();
        return gson.toJson(value);
    }

}
