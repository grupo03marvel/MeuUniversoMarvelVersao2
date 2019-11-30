package com.example.meuuniversomarvel.data.local.converters;

import androidx.room.TypeConverter;

import com.example.meuuniversomarvel.model.events.Characters;
import com.example.meuuniversomarvel.model.events.Comics;
import com.example.meuuniversomarvel.model.events.Creators;
import com.example.meuuniversomarvel.model.events.Data;
import com.example.meuuniversomarvel.model.events.Eventos;
import com.example.meuuniversomarvel.model.events.Next;
import com.example.meuuniversomarvel.model.events.Previous;
import com.example.meuuniversomarvel.model.events.Series;
import com.example.meuuniversomarvel.model.events.Stories;
import com.example.meuuniversomarvel.model.events.Thumbnail;
import com.example.meuuniversomarvel.model.events.Url;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class EventoConverters {

    @TypeConverter
    public Characters fromCharacters(String value) {
        Type listType = (Type) new TypeToken<Characters>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromCharacters(Characters list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public List<Comics> fromListPrice(String value) {
        Type listType = (Type) new TypeToken<List<Comics>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListPrice(List<Comics> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public Creators fromCreators(String value) {
        Type listType = (Type) new TypeToken<Creators>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromCreators(Creators list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public List<Next> fromListDate(String value) {
        Type listType = (Type) new TypeToken<List<Next>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListDate(List<Next> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
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

    // Type converter
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
    public Eventos fromEvents(String value) {
        Type listType = (Type) new TypeToken<Eventos>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromEvents(Eventos list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public List<Url> fromListUrl(String value) {
        Type listType = (Type) new TypeToken<List<Url>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListUrl(List<Url> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter
    @TypeConverter
    public List<Collection> fromListCollection(String value) {
        Type listType = (Type) new TypeToken<List<Collection>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListCollection(List<Collection> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    // Type converter
    @TypeConverter
    public List<Data> fromListImage(String value) {
        Type listType = (Type) new TypeToken<List<Data>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListImage(List<Data> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    // Type converter
    @TypeConverter
    public List<Previous> fromListTextObject(String value) {
        Type listType = (Type) new TypeToken<List<Previous>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListTextObject(List<Previous> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

}



