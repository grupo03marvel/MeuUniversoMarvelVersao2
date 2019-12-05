package com.example.meuuniversomarvel.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meuuniversomarvel.model.jogo.Pergunta;
import com.example.meuuniversomarvel.repository.PerguntaRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PerguntaViewModel extends AndroidViewModel {

    private MutableLiveData<List<Pergunta>> listaPerguntas = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private PerguntaRepository repository = new PerguntaRepository();
    private CompositeDisposable disposable = new CompositeDisposable();


    public PerguntaViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Pergunta>> retornaPerguntas(){
        return this.listaPerguntas;
    }

    public LiveData<Boolean> retornaValorLoading(){
        return this.loading;
    }

    public void buscaPerguntas(){
        disposable.add(
                repository.obterListaPerguntar(getApplication().getApplicationContext())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable1 -> loading.setValue(true))
                    .doAfterTerminate(() -> loading.setValue(false))
                    .subscribe(resposta -> listaPerguntas.setValue(resposta.getPerguntas()),
                        throwable -> {
                            Log.i("LOG", "busca perguntas" + throwable.getMessage());
                        })

        );
    }

    protected void onCleared(){
        super.onCleared();
        disposable.clear();
    }

}
