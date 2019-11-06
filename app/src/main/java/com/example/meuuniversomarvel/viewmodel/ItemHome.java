package com.example.meuuniversomarvel.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemHome implements Parcelable {
    private int imagemItemHome;
    private String nomeItemHome;

    //construtor

    public ItemHome(int imagemItemHome, String nomeItemHome) {
        this.imagemItemHome = imagemItemHome;
        this.nomeItemHome = nomeItemHome;
    }

    public ItemHome() {
    }

    //getters and setters

    protected ItemHome(Parcel in) {
        imagemItemHome = in.readInt();
        nomeItemHome = in.readString();
    }

    public static final Creator<ItemHome> CREATOR = new Creator<ItemHome>() {
        @Override
        public ItemHome createFromParcel(Parcel in) {
            return new ItemHome(in);
        }

        @Override
        public ItemHome[] newArray(int size) {
            return new ItemHome[size];
        }
    };

    public int getImagemItemHome() {
        return imagemItemHome;
    }

    public void setImagemItemHome(int imagemItemHome) {
        this.imagemItemHome = imagemItemHome;
    }

    public String getNomeItemHome() {
        return nomeItemHome;
    }

    public void setNomeItemHome(String nomeItemHome) {
        this.nomeItemHome = nomeItemHome;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagemItemHome);
        dest.writeString(nomeItemHome);
    }
}
