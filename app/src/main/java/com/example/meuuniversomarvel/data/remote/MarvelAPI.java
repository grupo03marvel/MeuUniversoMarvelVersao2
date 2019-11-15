package com.example.meuuniversomarvel.data.remote;

import com.example.meuuniversomarvel.model.comics.ComicsResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelAPI {

    @GET("comics")
    Observable<ComicsResult> getAllComics(@Query("format")String format,
                                          @Query("formatType")String formatType,
                                          @Query("noVariants")boolean noVariants,
                                          @Query("orderBy") String orderBy,
                                          @Query("ts") String ts,
                                          @Query("hash") String hash,
                                          @Query("apiKey") String apikey);

}
