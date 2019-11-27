package com.example.meuuniversomarvel.repository;

import com.example.meuuniversomarvel.model.characters.Personagens;

import io.reactivex.Observable;

import static com.example.meuuniversomarvel.data.remote.RetrofitService.getApiService;

public class PersonagemRepository {

    public Observable<Personagens> getPersonagemRepositori(

            String orderBy,
            String ts,
            String hash,
            String apikey){

        return getApiService().getALLPersonagens(orderBy, ts, hash, apikey);

    }
}
