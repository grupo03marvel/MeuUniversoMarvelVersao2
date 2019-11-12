package com.example.meuuniversomarvel.repository;

import com.example.meuuniversomarvel.model.comics.ComicsResult;

import io.reactivex.Observable;

import static com.example.meuuniversomarvel.data.remote.RetrofitService.getApiService;

public class HqRepository {

    public Observable<ComicsResult> getHqs(String format, String formatType, boolean noVariants, String orderBy, String ts, String hash, String apiKey){
        return getApiService().getAllComics(format, formatType, noVariants, orderBy, ts, hash, apiKey);
    }

}
