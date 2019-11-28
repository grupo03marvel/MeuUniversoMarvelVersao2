package com.example.meuuniversomarvel.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.meuuniversomarvel.model.comics.ResultComics;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface ComicDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ResultComics comic);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ResultComics> comics);

    @Update
    void update(ResultComics comic);

    @Delete
    void delete(ResultComics comic);

    @Query("DELETE FROM Comics")
    void deleteAll();

    @Query("SELECT * FROM Comics")
    List<ResultComics> getAll();

  /*  @Query("SELECT * FROM Comics")
    Observable<List<ResultComics>> getAllComics();
*/
    @Query("SELECT * FROM Comics WHERE id = :id ORDER BY id")
    ResultComics getById(String id);

    @Query("SELECT * FROM Comics WHERE title = :title")
    ResultComics getByTitle(String title);
}
