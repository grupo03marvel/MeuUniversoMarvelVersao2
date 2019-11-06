package com.example.meuuniversomarvel.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ModeloHome implements Parcelable {
    private String nomePagina;
    private int imagemCategoria;
    private List<ItemHome> listaItensHome;

    //construtor

    public ModeloHome(String nomePagina, int imagemCategoria, List<ItemHome> listaItensHome) {
        this.nomePagina = nomePagina;
        this.imagemCategoria = imagemCategoria;
        this.listaItensHome = listaItensHome;
    }

    public ModeloHome() {
    }

    //getters and setters


    protected ModeloHome(Parcel in) {
        nomePagina = in.readString();
        imagemCategoria = in.readInt();
        listaItensHome = in.createTypedArrayList(ItemHome.CREATOR);
    }

    public static final Creator<ModeloHome> CREATOR = new Creator<ModeloHome>() {
        @Override
        public ModeloHome createFromParcel(Parcel in) {
            return new ModeloHome(in);
        }

        @Override
        public ModeloHome[] newArray(int size) {
            return new ModeloHome[size];
        }
    };

    public String getNomePagina() {
        return nomePagina;
    }

    public void setNomePagina(String nomePagina) {
        this.nomePagina = nomePagina;
    }

    public int getImagemCategoria() {
        return imagemCategoria;
    }

    public void setImagemCategoria(int imagemCategoria) {
        this.imagemCategoria = imagemCategoria;
    }

    public List<ItemHome> getListaItensHome() {
        return listaItensHome;
    }

    public void setListaItensHome(List<ItemHome> listaItensHome) {
        this.listaItensHome = listaItensHome;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomePagina);
        dest.writeInt(imagemCategoria);
        dest.writeList(listaItensHome);
    }
}
