package com.example.meuuniversomarvel.data.local.converters;

import androidx.room.TypeConverter;

import com.example.meuuniversomarvel.model.characters.Comics;
import com.example.meuuniversomarvel.model.characters.Data;
import com.example.meuuniversomarvel.model.characters.Events;
import com.example.meuuniversomarvel.model.characters.Item;
import com.example.meuuniversomarvel.model.characters.Personagens;
import com.example.meuuniversomarvel.model.characters.ResultCharacters;
import com.example.meuuniversomarvel.model.characters.Series;
import com.example.meuuniversomarvel.model.characters.Stories;
import com.example.meuuniversomarvel.model.characters.Thumbnail;
import com.example.meuuniversomarvel.model.characters.Url;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import java.util.List;

public class PersonagensConverters {

    @TypeConverter
    public Comics fromCharacters(String value) {
        Type listType = (Type) new TypeToken<Comics>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromCharacters(Comics list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public List<Data> fromListPrice(String value) {
        Type listType = (Type) new TypeToken<List<Data>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListPrice(List<Data> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public Events fromCreators(String value) {
        Type listType = (Type) new TypeToken<Events>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromCreators(Events list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public List<Item> fromListDate(String value) {
        Type listType = (Type) new TypeToken<List<Item>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListDate(List<Item> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public Personagens fromStories(String value) {
        Type listType = (Type) new TypeToken<Personagens>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromStories(Personagens list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public ResultCharacters fromThumbnail(String value) {
        Type listType = (Type) new TypeToken<ResultCharacters>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromThumbnail(ResultCharacters list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public Series fromSeries(String value) {
        Type listType = (Type) new TypeToken<Series>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromSeries(Series list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public Stories fromEvents(String value) {
        Type listType = (Type) new TypeToken<Stories>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromEvents(Stories list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public List<Thumbnail> fromListUrl(String value) {
        Type listType = (Type) new TypeToken<List<Thumbnail>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListUrl(List<Thumbnail> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    // Type converter
    @TypeConverter
    public List<Url> fromListImage(String value) {
        Type listType = (Type) new TypeToken<List<Url>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListImage(List<Url> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

}
