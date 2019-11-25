/*package com.example.meuuniversomarvel.data.local;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.facebook.stetho.inspector.protocol.module.Database;

public abstract class DataBase extends RoomDatabase {

    private static volatile Database INSTANCE;


    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "produtos_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}*/

package com.example.meuuniversomarvel.data.local;


import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.meuuniversomarvel.model.comics.Result;


@Database(entities = {Result.class}, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase implements Database {

    private static volatile Database INSTANCE;

    public abstract CharactersDao comicDao();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, DataBase.class, "characters_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}


