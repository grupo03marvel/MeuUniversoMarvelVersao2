package com.example.meuuniversomarvel.repository;

import android.content.Context;

import com.example.meuuniversomarvel.data.local.Database;
import com.example.meuuniversomarvel.data.local.dao.EventoDAO;
import com.example.meuuniversomarvel.model.events.Eventos;
import com.example.meuuniversomarvel.model.events.ResultEvents;

import java.util.List;

import io.reactivex.Observable;

import static com.example.meuuniversomarvel.data.remote.RetrofitService.getApiService;

public class EventosRepository {

    public Observable<Eventos> getEventosRepositori(

            String orderBy,
            String ts,
            String hash,
            String apikey){

        return getApiService().getALLEventos(orderBy, ts, hash, apikey);

    }

    public void insertItems(Context context, List<ResultEvents> eventos) {

        Database database = Database.getDatabase(context);
         EventoDAO eventoDAO = database.eventDAO();

        eventoDAO.deleteAll();
        eventoDAO.insertAll(eventos);
    }
}
