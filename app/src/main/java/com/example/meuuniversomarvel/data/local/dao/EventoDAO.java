package com.example.meuuniversomarvel.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.meuuniversomarvel.model.events.ResultEvents;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface EventoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ResultEvents event);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ResultEvents> eventos);

    @Update
    void update(ResultEvents event);

    @Delete
    void delete(ResultEvents event);

    @Query("DELETE FROM eventos")
    void deleteAll();

    @Query("SELECT * FROM eventos")
    List<ResultEvents> getAll();

    @Query("SELECT * FROM eventos")
    Flowable<List<ResultEvents>> getAllRxJava();

    @Query("SELECT * FROM eventos WHERE id = :id ORDER BY id")
    ResultEvents getById(String id);

    @Query("SELECT * FROM eventos WHERE title = :title")
    ResultEvents getByTitle(String title);
}
