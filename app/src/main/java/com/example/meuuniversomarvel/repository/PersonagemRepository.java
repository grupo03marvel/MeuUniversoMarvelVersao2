package com.example.meuuniversomarvel.repository;

import android.content.Context;

import com.example.meuuniversomarvel.data.local.Database;
import com.example.meuuniversomarvel.data.local.dao.PersonagemDAO;
import com.example.meuuniversomarvel.model.characters.Personagens;
import com.example.meuuniversomarvel.model.characters.ResultCharacters;

import java.util.List;

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

        return getApiService().getALLPersonagens(orderBy, ts, hash, apikey);
    }

    public void insertItems(Context context, List<ResultCharacters> perso) {

        Database database = Database.getDatabase(context);
        PersonagemDAO personagemDAO = database.personagemDAO();

        personagemDAO.deleteAll();
        personagemDAO.insertAll(perso);
    }
}
