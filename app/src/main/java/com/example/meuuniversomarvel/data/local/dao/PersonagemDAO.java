package com.example.meuuniversomarvel.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.meuuniversomarvel.model.characters.ResultCharacters;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

@Dao
public interface PersonagemDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ResultCharacters person);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ResultCharacters> perso);

    @Update
    void update(ResultCharacters person);

    @Delete
    void delete(ResultCharacters person);

    @Query("DELETE FROM perso")
    void deleteAll();

    @Query("SELECT * FROM perso")
    List<ResultCharacters> getAll();

    @Query("SELECT * FROM perso")
    Observable<List<ResultCharacters>> getAllCharactes();

    @Query("SELECT * FROM perso WHERE id = :id ORDER BY id")
    ResultCharacters getById(String id);

    @Query("SELECT * FROM perso WHERE name = :name")
    ResultCharacters getByTitle(String name);
}

