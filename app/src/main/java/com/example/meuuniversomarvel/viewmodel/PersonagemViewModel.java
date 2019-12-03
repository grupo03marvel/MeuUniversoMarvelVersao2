package com.example.meuuniversomarvel.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meuuniversomarvel.data.local.Database;
import com.example.meuuniversomarvel.data.local.dao.PersonagemDAO;
import com.example.meuuniversomarvel.model.characters.Personagens;
import com.example.meuuniversomarvel.model.characters.ResultCharacters;
import com.example.meuuniversomarvel.repository.PersonagemRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.meuuniversomarvel.util.AppUtils.md5;

public class PersonagemViewModel extends AndroidViewModel {

    private MutableLiveData<List<ResultCharacters>> listaPersona = new MutableLiveData<>();
    private PersonagemRepository Repository = new PersonagemRepository();
    private CompositeDisposable disposable = new CompositeDisposable();
    private PersonagemDAO personagemDAO = Database.getDatabase(getApplication()).personagemDAO();


    public static final String PUBLIC_KEY = "fe81c0a4bd6c7f00e3df25d68d8d8a92";

    public static final String PRIVATE_KEY = "ceac13aef2089eaf3c704ba9da60cf2156b60912";

    String ts = Long.toString(System.currentTimeMillis() / 1000);

    String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);

    public PersonagemViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<ResultCharacters>> getListaPersonagem(){
        return this.listaPersona;
    }

    public void getPersonagens() {

        disposable.add(
                Repository.getPersonagemRepositori("name", ts, hash, PUBLIC_KEY)

                        .subscribeOn(Schedulers.newThread())

                        .observeOn(AndroidSchedulers.mainThread())

                        .subscribe(new Consumer<Personagens>() {
                            @Override
                            public void accept(Personagens personagem) throws Exception {

                                listaPersona.setValue(personagem.getData().getResults());
                            }
                        }, throwable -> {

                            Log.i("LOG", "Error: " + throwable.getMessage());
                        }));
    }

    public void insereCharacyers(ResultCharacters characters){
        new Thread(() -> {
            if (characters != null){
                personagemDAO.insert(characters);
            }
        }).start();

        this.listaPersona.setValue(characters);
    }
}
