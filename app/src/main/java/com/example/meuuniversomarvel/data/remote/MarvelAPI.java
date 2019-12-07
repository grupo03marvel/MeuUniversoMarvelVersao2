package com.example.meuuniversomarvel.data.remote;

import com.example.meuuniversomarvel.model.characters.Personagens;
import com.example.meuuniversomarvel.model.charactersId.Characterid;
import com.example.meuuniversomarvel.model.comics.ComicsResult;
import com.example.meuuniversomarvel.model.creators.Criadores;
import com.example.meuuniversomarvel.model.events.Eventos;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelAPI {

    @GET("comics?")
    Observable<ComicsResult> getAllComics(@Query("offset")int pagina,
                                          @Query("format")String format,
                                          @Query("formatType")String formatType,
                                          @Query("noVariants")boolean noVariants,
                                          @Query("orderBy") String orderBy,
                                          @Query("ts") String ts,
                                          @Query("hash") String hash,
                                          @Query("apikey") String apikey);

    @GET ("characters?")
    Observable<Personagens> getALLPersonagens(
            @Query("offset")int pagina,
            @Query("orderBy") String orderBy,
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey

    );

    @GET ("creators?")
    Observable<Criadores> getALLCriadores(

            @Query("orderBy") String orderBy,
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey

    );

    @GET ("events?")
    Observable<Eventos> getALLEventos(
            @Query("offset")int pagina,
            @Query("orderBy") String orderBy,
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey

    );


    @GET("characters/{charactersId}")
    Observable<Characterid> getIdCharacter(
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey
    );

}
