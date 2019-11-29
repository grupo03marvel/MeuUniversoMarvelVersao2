package com.example.meuuniversomarvel.repository;

import com.example.meuuniversomarvel.model.characters.Personagens;

import io.reactivex.Observable;

import static com.example.meuuniversomarvel.data.remote.RetrofitService.getApiService;

public class PersonagemRepository {

    public Observable<Personagens> getPersonagemRepositori(

            int pagina,
            String orderBy,
            String ts,
            String hash,
            String apikey){

        return getApiService().getALLPersonagens(pagina, orderBy, ts, hash, apikey);

    }
}
