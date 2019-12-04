package com.example.meuuniversomarvel.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meuuniversomarvel.model.characters.Personagens;
import com.example.meuuniversomarvel.model.characters.Result;
import com.example.meuuniversomarvel.repository.PersonagemRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.meuuniversomarvel.util.AppUtils.md5;

public class PersonagemViewModel extends AndroidViewModel {

    private MutableLiveData<List<Result>> listaPersona = new MutableLiveData<>();
    private PersonagemRepository Repository = new PersonagemRepository();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();


    public static final String PUBLIC_KEY = "fe81c0a4bd6c7f00e3df25d68d8d8a92";

    public static final String PRIVATE_KEY = "ceac13aef2089eaf3c704ba9da60cf2156b60912";

    String ts = Long.toString(System.currentTimeMillis() / 1000);

    String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);

    public PersonagemViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getListaPersonagem(){
        return this.listaPersona;
    }

    public LiveData<Boolean> getLoading(){
        return this.loading;
    }

    public void getPersonagens(int pagina) {

        disposable.add(
                Repository.getPersonagemRepositori(pagina,"name", ts, hash, PUBLIC_KEY)

                        .subscribeOn(Schedulers.newThread())

                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(new Consumer<Personagens>() {
                            @Override
                            public void accept(Personagens personagem) throws Exception {

                                listaPersona.setValue(personagem.getData().getResults());
                            }
                        }, throwable -> {

                            Log.i("LOG", "Error: " + throwable.getMessage());
                        }));
    }
}

