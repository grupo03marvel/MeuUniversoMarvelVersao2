package com.example.meuuniversomarvel.view.fragments.recycler;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.data.local.CharactersDao;
import com.example.meuuniversomarvel.model.characters.Result;
import com.example.meuuniversomarvel.view.adapter.PersonagemAdapter;
import com.example.meuuniversomarvel.view.fragments.detalhe.DetalhePersonagemFragment;
import com.example.meuuniversomarvel.view.interfaces.PersonagensOnClick;
import com.example.meuuniversomarvel.viewmodel.PersonagemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonagensFragment extends Fragment implements PersonagensOnClick {

    private List<Result> results = new ArrayList<>();
    private PersonagemAdapter adapter;
    private RecyclerView recyclerView;
    private PersonagemViewModel viewModel;
    public static final String PERSONAGEM_KEY = "Personagem";


    public PersonagensFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personagens, container, false);
        initViews(view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));


        viewModel.getPersonagens();
        viewModel.getListaPersonagem().observe(this, results1 -> {
            adapter.atualizaListaP(results1);

        });


        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_personagens);
        viewModel = ViewModelProviders.of(this).get(PersonagemViewModel.class);
        adapter = new PersonagemAdapter(results, this);
    }


    @Override
    public void personagemOnClick(Result result) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(PERSONAGEM_KEY, result);

        Fragment detalheFragment = new DetalhePersonagemFragment();
        detalheFragment.setArguments(bundle);
        replaceFragment(detalheFragment);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerPrincipal, fragment);
        transaction.commit();
    }

    private void BuscaTodosPersonagens () {

        CharactersDao.todosPersonagens()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(personagens -> {
                            adapter.atualizaListaP(personagens);
                        },
                        throwable -> {
                            Log.i("TAG", "método getAllProdutos" + throwable.getMessage());
                        });
    }

}

