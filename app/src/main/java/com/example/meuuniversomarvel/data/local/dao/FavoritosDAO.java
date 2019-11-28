/*
package com.example.meuuniversomarvel.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.meuuniversomarvel.model.favoritos.Favoritos;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface FavoritosDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Favoritos favorite);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Favoritos> favorites);

    @Update
    void update(Favoritos favorite);

    @Delete
    void delete(Favoritos favorite);

    @Query("DELETE FROM favoritosT WHERE loginUser = :loginUser and idComic = :idComic")
    void deleteByUserComicId(String loginUser, String idComic);

    @Query("DELETE FROM favoritosT WHERE loginUser = :loginUser and idEvent = :idEvent")
    void deleteByUserEventId(String loginUser, String idEvent);

    @Query("DELETE FROM favoritosT WHERE loginUser = :loginUser and idCharacter = :idCharacter")
    void deleteByUserSerieId(String loginUser, String idCharacter);

    @Query("SELECT * FROM favoritosT")
    List<Favoritos> getAll();

    @Query("SELECT * FROM favoritosT")
    Flowable<List<Favoritos>> getAllRxJava();

    @Query("SELECT * FROM favoritosT WHERE loginUser = :loginUser and idComic = :idComic")
    Favoritos getFavoritesByUserComicId(String loginUser, String idComic);

    @Query("SELECT * FROM favoritosT WHERE loginUser = :loginUser and idEvent = :idEvent")
    Favoritos getFavoritesByUserEventId(String loginUser, String idEvent);

    @Query("SELECT * FROM favoritosT WHERE loginUser = :loginUser and idCharacter = :idCharacter")
    Favoritos getFavoritesByUserSerieId(String loginUser, String idCharacter);

    @Query("SELECT * FROM favoritosT WHERE idEvent = :idEvent")
    Favoritos getFavoritesByEventId(String idEvent);

}
*/
