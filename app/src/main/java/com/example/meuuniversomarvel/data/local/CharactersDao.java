package com.example.meuuniversomarvel.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverter;

import com.example.meuuniversomarvel.model.characters.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
@Dao
public interface CharactersDao {

    @Insert
    void insert(Result personagem);

    @Query("SELECT * FROM  personagens")
    Observable<List<Result>> todosPersonagens();

    public class Converters {
        @TypeConverter
        public static ArrayList<String> fromString(String value) {
            Type listType = new TypeToken<ArrayList<String>>() {
            }.getType();
            return new Gson().fromJson(value, listType);
        }

        @TypeConverter
        public static String fromArrayLisr(ArrayList<String> list) {
            Gson gson = new Gson();

            String json = gson.toJson(list);
            return json;

        }
    }
}
