package com.example.meuuniversomarvel.repository;

import android.content.Context;

import com.example.meuuniversomarvel.data.local.Database;
import com.example.meuuniversomarvel.data.local.dao.PersonagemDAO;
import com.example.meuuniversomarvel.model.characters.Personagens;
import com.example.meuuniversomarvel.model.characters.Result;

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

    }

    //dados locais
    public Observable<List<Result>> getLocalResults(Context context){
        Database room = Database.getDatabase(context);
        PersonagemDAO personagemDAO = room.personagemDAO();
        return personagemDAO.getAllCharactes();
    }


}
