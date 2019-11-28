/*
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

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public ResultComics getComicsResult() {
        return comicsResult;
    }

    public void setComicsResult(ResultComics comicsResult) {
        this.comicsResult = comicsResult;
    }

    public ResultCharacters getCharactersResult() {
        return charactersResult;
    }

    public void setCharactersResult(ResultCharacters charactersResult) {
        this.charactersResult = charactersResult;
    }

    public ResultEvents getEventsResult() {
        return eventsResult;
    }

    public void setEventsResult(ResultEvents eventsResult) {
        this.eventsResult = eventsResult;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getIdComic() {
        return idComic;
    }

    public void setIdComic(String idComic) {
        this.idComic = idComic;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(String idCharacter) {
        this.idCharacter = idCharacter;
    }

    public Favoritos(long tableId, ResultComics comicsResult, ResultCharacters charactersResult, ResultEvents eventsResult, String loginUser, String idComic, String idEvent, String idCharacter) {
        this.tableId = tableId;
        this.comicsResult = comicsResult;
        this.charactersResult = charactersResult;
        this.eventsResult = eventsResult;
        this.loginUser = loginUser;
        this.idComic = idComic;
        this.idEvent = idEvent;
        this.idCharacter = idCharacter;
    }

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
}*/
