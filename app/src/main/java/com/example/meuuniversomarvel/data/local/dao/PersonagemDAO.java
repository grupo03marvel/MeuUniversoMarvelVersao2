package com.example.meuuniversomarvel.data.local.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.meuuniversomarvel.model.characters.Result;

import java.util.List;

import io.reactivex.Flowable;

public interface PersonagemDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Result person);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Result> perso);

    @Update
    void update(Result person);

    @Delete
    void delete(Result person);

    @Query("DELETE FROM perso")
    void deleteAll();

    @Query("SELECT * FROM perso")
    List<Result> getAll();

    @Query("SELECT * FROM perso")
    Flowable<List<Result>> getAllRxJava();

    @Query("SELECT * FROM comics WHERE id = :id ORDER BY id")
    Result getById(String id);

    @Query("SELECT * FROM comics WHERE title = :title")
    Result getByTitle(String title);
}

