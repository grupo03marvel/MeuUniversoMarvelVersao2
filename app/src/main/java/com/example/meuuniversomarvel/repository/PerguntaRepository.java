package com.example.meuuniversomarvel.repository;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.meuuniversomarvel.model.jogo.Pergunta;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import io.reactivex.Observable;

public class PerguntaRepository {

    public Observable<Pergunta> obterListaPerguntar(Context context){

        try {
            AssetManager manager = context.getAssets();
            InputStream inputStream = manager.open("perguntas.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            Gson gson = new Gson();

            Pergunta pergunta = gson.fromJson(reader, Pergunta.class);

            return Observable.just(pergunta);
        }catch (Exception ex){
            ex.printStackTrace();
            return Observable.error(ex.getCause());
        }

    }


}
