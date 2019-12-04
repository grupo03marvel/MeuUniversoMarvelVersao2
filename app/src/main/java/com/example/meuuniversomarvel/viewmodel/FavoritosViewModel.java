package com.example.meuuniversomarvel.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meuuniversomarvel.data.local.Database;
import com.example.meuuniversomarvel.data.local.dao.FavoritosDAO;
import com.example.meuuniversomarvel.model.favoritos.Favoritos;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class FavoritosViewModel extends AndroidViewModel {
    private MutableLiveData<List<Favoritos>> favoritoList = new MutableLiveData<>();
    private FavoritosDAO favoritosDAO = Database.getDatabase(getApplication()).favoritosDAO();
    private CompositeDisposable disposable = new CompositeDisposable();

    public FavoritosViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Favoritos>> retornaFavoritos(){
        return this.favoritoList;
    }

}
