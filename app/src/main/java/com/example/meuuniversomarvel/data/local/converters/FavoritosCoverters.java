package com.example.meuuniversomarvel.data.local.converters;

import androidx.room.TypeConverter;

import com.example.meuuniversomarvel.model.characters.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class FavoritosCoverters {

    // Type converter
    @TypeConverter
    public Result fromResulCharacters(String value) {
        Type listType = (Type) new TypeToken<Result>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromResulCharacters(Result list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
