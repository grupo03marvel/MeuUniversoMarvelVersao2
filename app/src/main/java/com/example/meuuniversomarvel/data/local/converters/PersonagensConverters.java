package com.example.meuuniversomarvel.data.local.converters;

import androidx.room.TypeConverter;

import com.example.meuuniversomarvel.model.characters.Comics;
import com.example.meuuniversomarvel.model.characters.Data;
import com.example.meuuniversomarvel.model.characters.Events;
import com.example.meuuniversomarvel.model.characters.Item;
import com.example.meuuniversomarvel.model.characters.Personagens;
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
    public Comics fromComics(String value) {
        Type listType = (Type) new TypeToken<Comics>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromComics(Comics list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Thumbnail fromThumbnail(String value) {
        Type listType = (Type) new TypeToken<Thumbnail>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromThumbnail(Thumbnail list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Stories fromStories(String value) {
        Type listType = (Type) new TypeToken<Stories>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromStories(Stories list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    @TypeConverter
    public List<Data> fromData(String value) {
        Type listType = (Type) new TypeToken<List<Data>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromData(List<Data> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public Events fromEvents(String value) {
        Type listType = (Type) new TypeToken<Events>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromEvents(Events list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public List<Item> fromItem(String value) {
        Type listType = (Type) new TypeToken<List<Item>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromItem(List<Item> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public Personagens fromPersonagens(String value) {
        Type listType = (Type) new TypeToken<Personagens>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromPersonagens(Personagens list) {
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
    public List<Url> fromUrl(String value) {
        Type listType = (Type) new TypeToken<List<Url>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromUrl(List<Url> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

}
