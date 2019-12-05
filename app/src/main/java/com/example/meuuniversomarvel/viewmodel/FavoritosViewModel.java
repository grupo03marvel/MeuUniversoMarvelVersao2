package com.example.meuuniversomarvel.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meuuniversomarvel.data.local.Database;
import com.example.meuuniversomarvel.data.local.dao.FavoritosDAO;
import com.example.meuuniversomarvel.data.local.dao.PersonagemDAO;
import com.example.meuuniversomarvel.model.characters.Result;
import com.example.meuuniversomarvel.model.favoritos.Favoritos;
import com.example.meuuniversomarvel.repository.FavoritosRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FavoritosViewModel extends AndroidViewModel {

    private MutableLiveData<List<Result>> favoritoList = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private FavoritosRepository repository = new FavoritosRepository();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    private MutableLiveData<Result> salvado = new MutableLiveData<>();

    private PersonagemDAO personagemDAO = Database.getDatabase(getApplication()).personagemDAO();



    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();

    public LiveData<Throwable> getFavoriteErrorLiveData() {
        return errorLiveData;
    }

    public FavoritosViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> retornaFavoritos(){
        return this.favoritoList;

    }
    public LiveData<Boolean> getFavoriteLoadingLiveData() {
        return loadingLiveData;
    }

    public void buscaFavoritos() {
        disposable.add(
                personagemDAO.getAllCharactes()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<List<Result>>() {
                                       @Override
                                       public void accept(List<Result> filmes) throws Exception {
                                           favoritoList.setValue(filmes);
                                       }
                                   },
                                throwable -> {
                                    Log.i("LOG", "Falha na lista de favoritos" + throwable.getMessage());

                                })
        );
    }
    public void inserePersonagemFavo(Result personagem){
        new Thread(() -> {
            if (personagem != null){
                personagemDAO.insert(personagem);
            }
        }).start();

        this.salvado.setValue(personagem);
    }
}