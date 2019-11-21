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

