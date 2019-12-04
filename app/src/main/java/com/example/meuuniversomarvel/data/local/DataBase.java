package com.example.meuuniversomarvel.data.local;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.meuuniversomarvel.data.local.converters.ComicConverters;
import com.example.meuuniversomarvel.data.local.converters.EventoConverters;
import com.example.meuuniversomarvel.data.local.converters.FavoritosCoverters;
import com.example.meuuniversomarvel.data.local.dao.ComicDAO;
import com.example.meuuniversomarvel.data.local.dao.EventoDAO;
import com.example.meuuniversomarvel.data.local.dao.FavoritosDAO;
//import com.example.meuuniversomarvel.data.local.dao.PersonagemDAO;
import com.example.meuuniversomarvel.model.comics.Result;
import com.example.meuuniversomarvel.model.favoritos.Favoritos;
//
//@androidx.room.Database(entities = {Result.class, com.example.meuuniversomarvel.model.events.Result.class, com.example.meuuniversomarvel.model.events.Result.class, Favoritos.class}, version = 1, exportSchema = false)
//@TypeConverters({ComicConverters.class, EventoConverters.class, PersonagemDAO.class, FavoritosCoverters.class})
//
//public abstract class Database extends RoomDatabase {
//
//    private static volatile Database INSTANCE;
//
//    public abstract ComicDAO comicDAO();
//
//    public abstract EventoDAO eventDAO();
//
//    public abstract PersonagemDAO personagemDAO();
//
//    public abstract FavoritosDAO favoritosDAO();
//
//    public static Database getDatabase(Context context) {
//
//        if (INSTANCE == null) {
//            synchronized (Database.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(context, Database.class, "Meu_db")
//                            .fallbackToDestructiveMigration()
//                            .build();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//}
