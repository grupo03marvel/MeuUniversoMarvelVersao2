package com.example.meuuniversomarvel.repository;

import com.example.meuuniversomarvel.model.events.Eventos;

import io.reactivex.Observable;

import static com.example.meuuniversomarvel.data.remote.RetrofitService.getApiService;

public class EventosRepository {

    public Observable<Eventos> getEventosRepositori(

            int pagina,
            String orderBy,
            String ts,
            String hash,
            String apikey){

        return getApiService().getALLEventos(pagina, orderBy, ts, hash, apikey);

    }
}
