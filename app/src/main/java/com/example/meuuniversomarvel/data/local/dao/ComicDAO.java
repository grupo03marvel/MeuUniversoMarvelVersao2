package com.example.meuuniversomarvel.data.local.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.meuuniversomarvel.model.comics.Result;

import java.util.List;

import io.reactivex.Flowable;

public interface ComicDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Result comic);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Result> comics);

    @Update
    void update(Result comic);

    @Delete
    void delete(Result comic);

    @Query("DELETE FROM comics")
    void deleteAll();

    @Query("SELECT * FROM comics")
    List<Result> getAll();

    @Query("SELECT * FROM comics")
    Flowable<List<Result>> getAllRxJava();

    @Query("SELECT * FROM comics WHERE id = :id ORDER BY id")
    Result getById(String id);

    @Query("SELECT * FROM comics WHERE title = :title")
    Result getByTitle(String title);
}
