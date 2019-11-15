package com.example.meuuniversomarvel.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meuuniversomarvel.data.remote.MarvelAPI;
import com.example.meuuniversomarvel.data.remote.RetrofitService;
import com.example.meuuniversomarvel.model.comics.Result;
import com.example.meuuniversomarvel.repository.HqRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.meuuniversomarvel.viewmodel.AppUtils.md5;

public class hqViewModel extends AndroidViewModel {

    private MutableLiveData<List<Result>> listaComics = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private HqRepository repository = new HqRepository();
    public static final String PRIVATE_KEY = "e14bbda3febb4ca26b6dacc098430754cc7e62cc";
    public static final String PUBLIC_KEY = "d374c335eff01bf5809078f9ffbfdf82";
    String ts = Long.toString(System.currentTimeMillis()/1000);
    String hash = md5(ts+PRIVATE_KEY+PUBLIC_KEY);

    public hqViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getListaHqs(){
        return this.listaComics;
    }

    public LiveData<Boolean> getLoading(){
        return this.loading;
    }

    public void getAllComics(){
        disposable.add(
                repository.getHqs("magazine", "comic", true, "focDate", ts, hash, PUBLIC_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

                    listaComics.setValue(response.getData().getResults());
                    Log.i("LOG", "API: " + response.getData().getResults() );

                }, throwable -> {
                    Log.i("LOG", "Error: " + throwable.getMessage());
                })
        );
    }

}
