package com.example.meuuniversomarvel.repository;

import android.content.Context;

import com.example.meuuniversomarvel.data.local.Database;
import com.example.meuuniversomarvel.data.local.dao.ComicDAO;
import com.example.meuuniversomarvel.model.comics.ComicsResult;
import com.example.meuuniversomarvel.model.comics.ResultComics;

import java.util.List;

import io.reactivex.Observable;

import static com.example.meuuniversomarvel.data.remote.RetrofitService.getApiService;

public class HqRepository {

    public Observable<ComicsResult> getHqs(String format, String formatType, boolean noVariants, String orderBy, String ts, String hash, String apiKey){
        return getApiService().getAllComics(format, formatType, noVariants, orderBy, ts, hash, apiKey);
    }

    public void insertItems(Context context, List<ResultComics> comics) {

        Database database = Database.getDatabase(context);
        ComicDAO comicDAO = database.comicDAO();

        comicDAO.deleteAll();
        comicDAO.insertAll(comics);
    }

}
