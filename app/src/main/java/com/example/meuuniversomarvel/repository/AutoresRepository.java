package com.example.meuuniversomarvel.repository;

import android.content.Context;

import com.example.meuuniversomarvel.model.creators.Criadores;

import java.util.List;

import io.reactivex.Observable;

import static com.example.meuuniversomarvel.data.remote.RetrofitService.getApiService;

public class AutoresRepository {

    public Observable<Criadores> getCriadoresRepositori(

            String orderBy,
            String ts,
            String hash,
            String apikey){

        return getApiService().getALLCriadores(orderBy, ts, hash, apikey);
    }

}
