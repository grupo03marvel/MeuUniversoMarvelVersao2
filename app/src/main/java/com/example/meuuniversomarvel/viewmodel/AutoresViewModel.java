package com.example.meuuniversomarvel.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meuuniversomarvel.model.creators.Criadores;
import com.example.meuuniversomarvel.model.creators.Result;
import com.example.meuuniversomarvel.repository.AutoresRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.meuuniversomarvel.util.AppUtils.md5;

public class AutoresViewModel extends AndroidViewModel {

    private MutableLiveData<List<Result>> listaCriadores = new MutableLiveData<>();
    private AutoresRepository repositpory = new AutoresRepository();
    private CompositeDisposable disposable = new CompositeDisposable();

    public static final String PUBLIC_KEY = "fe81c0a4bd6c7f00e3df25d68d8d8a92";

    public static final String PRIVATE_KEY = "ceac13aef2089eaf3c704ba9da60cf2156b60912";

    String ts = Long.toString(System.currentTimeMillis() / 1000);

    String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);

    public AutoresViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<Result>> getListaCriadores(){
        return this.listaCriadores;
    }

    public void getCriadores() {

        disposable.add(
                repositpory.getCriadoresRepositori("suffix", ts, hash, PUBLIC_KEY)

                        .subscribeOn(Schedulers.newThread())

                        .observeOn(AndroidSchedulers.mainThread())

                        .subscribe(new Consumer<Criadores>() {
                            @Override
                            public void accept(Criadores criadores) throws Exception {

                                listaCriadores.setValue(criadores.getData().getResults());
                            }
                        }, throwable -> {

                            Log.i("LOG", "Error: " + throwable.getMessage());
                        }));
    }
}

