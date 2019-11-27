package com.example.meuuniversomarvel.model.favoritos;



import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.meuuniversomarvel.model.characters.ResultCharacters;
import com.example.meuuniversomarvel.model.comics.ResultComics;
import com.example.meuuniversomarvel.model.events.ResultEvents;
import com.google.gson.annotations.Expose;

@Entity(tableName = "favoritosT")

public class Favoritos implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long tableId;

    @Expose
    private ResultComics comicsResult;

    @Expose
    private ResultCharacters charactersResult;

    @Expose
    private ResultEvents eventsResult;

    @Expose
    private String loginUser;


    @Expose
    private String idComic;

    @Expose
    private String idEvent;

    @Expose
    private String idCharacter;


    protected Favoritos(Parcel in) {
        tableId = in.readLong();
        comicsResult = in.readParcelable(ResultComics.class.getClassLoader());
        charactersResult = in.readParcelable(ResultCharacters.class.getClassLoader());
        eventsResult = in.readParcelable(ResultEvents.class.getClassLoader());
        loginUser = in.readString();
        idComic = in.readString();
        idEvent = in.readString();
        idCharacter = in.readString();
    }

    public static final Creator<Favoritos> CREATOR = new Creator<Favoritos>() {
        @Override
        public Favoritos createFromParcel(Parcel in) {
            return new Favoritos(in);
        }

        @Override
        public Favoritos[] newArray(int size) {
            return new Favoritos[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(tableId);
        parcel.writeParcelable(comicsResult, i);
        parcel.writeParcelable(charactersResult, i);
        parcel.writeParcelable(eventsResult, i);
        parcel.writeString(loginUser);
        parcel.writeString(idComic);
        parcel.writeString(idEvent);
        parcel.writeString(idCharacter);
    }
}