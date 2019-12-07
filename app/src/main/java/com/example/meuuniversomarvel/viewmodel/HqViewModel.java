package com.example.meuuniversomarvel.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meuuniversomarvel.model.comics.ComicsResult;
import com.example.meuuniversomarvel.model.comics.Result;
import com.example.meuuniversomarvel.repository.HqRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.meuuniversomarvel.util.AppUtils.md5;

public class HqViewModel extends AndroidViewModel {

    private MutableLiveData<List<Result>> listaComics = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private HqRepository repository = new HqRepository();
    public static final String PRIVATE_KEY = "ceac13aef2089eaf3c704ba9da60cf2156b60912";
    public static final String PUBLIC_KEY = "fe81c0a4bd6c7f00e3df25d68d8d8a92";
    String ts = Long.toString(System.currentTimeMillis()/1000);
    String hash = md5(ts+PRIVATE_KEY+PUBLIC_KEY);

    public HqViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getListaHqs(){
        return this.listaComics;
    }

    public LiveData<Boolean> getLoading(){
        return this.loading;
    }

    public void getAllComics(int pagina){
        disposable.add(
                repository.getHqs(pagina, "magazine", "comic", true, "focDate", ts, hash, PUBLIC_KEY)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(response -> {

                            listaComics.setValue(response.getData().getResults());
                            Log.i("LOG", "API: " + response.getData().getResults() );

                        }, throwable -> {
                            Log.i("LOG", "Error: " + throwable.getMessage());
                        })
        );
    }

    public void getAllComics(int pagina, String texto){
        disposable.add(
                repository.getHqs(pagina, "magazine", "comic", true, "focDate", ts, hash, PUBLIC_KEY)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(response -> {

                            List<Result> listaFitrada = new ArrayList<>();
                            for (Result result1 : response.getData().getResults()) {
                                String _name = result1.getTitle().toLowerCase();
                                String _texto = texto.toLowerCase();
                                if(_name.contains(_texto)){
                                    listaFitrada.add(result1);
                                }
                            }
                            listaComics.setValue(listaFitrada);

                        }, throwable -> {
                            Log.i("LOG", "Error: " + throwable.getMessage());
                        })
        );
    }

}
