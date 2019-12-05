package com.example.meuuniversomarvel.repository;

import android.content.Context;

import com.example.meuuniversomarvel.data.local.Database;
import com.example.meuuniversomarvel.data.local.dao.FavoritosDAO;
import com.example.meuuniversomarvel.model.favoritos.Favoritos;

import java.util.List;

import io.reactivex.Flowable;

public class FavoritosRepository {

    public Flowable<List<Favoritos>> getFavoriteLocal(Context context) {

        Database database = Database.getDatabase(context);

        FavoritosDAO favoritosDAO = database.favoritosDAO();

        return favoritosDAO.getAllRxJava();
    }
}
