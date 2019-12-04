package com.example.meuuniversomarvel.data.local.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.meuuniversomarvel.model.events.Result;

import java.util.List;

import io.reactivex.Flowable;

public interface EventoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Result event);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Result> eventos);

    @Update
    void update(Result event);

    @Delete
    void delete(Result event);

    @Query("DELETE FROM eventos")
    void deleteAll();

    @Query("SELECT * FROM eventos")
    List<Result> getAll();

    @Query("SELECT * FROM eventos")
    Flowable<List<Result>> getAllRxJava();

    @Query("SELECT * FROM eventos WHERE id = :id ORDER BY id")
    Result getById(String id);

    @Query("SELECT * FROM eventos WHERE title = :title")
    Result getByTitle(String title);
}
