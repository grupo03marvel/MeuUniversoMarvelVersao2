/*
package com.example.meuuniversomarvel.data.local.converters;

import androidx.room.TypeConverter;

import com.example.meuuniversomarvel.model.characters.ResultCharacters;
import com.example.meuuniversomarvel.model.comics.ResultComics;
import com.example.meuuniversomarvel.model.events.ResultEvents;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class FavoritosCoverters {

    // Type converter
    @TypeConverter
    public ResultCharacters fromResulCharacters(String value) {
        Type listType = (Type) new TypeToken<ResultCharacters>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromResulCharacters(ResultCharacters list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public ResultEvents fromEvents(String value) {
        Type listType = (Type) new TypeToken<ResultEvents>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromEvents(ResultEvents list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public ResultComics fromResultComics(String value) {
        Type listType = (Type) new TypeToken<ResultComics>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromResultComics(ResultComics list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
*/
