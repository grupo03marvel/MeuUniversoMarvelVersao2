package com.example.meuuniversomarvel.view.fragments.recycler;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.characters.Result;
import com.example.meuuniversomarvel.view.adapter.PersonagemAdapter;
import com.example.meuuniversomarvel.view.fragments.detalhe.DetalhePersonagemFragment;
import com.example.meuuniversomarvel.view.interfaces.PersonagensOnClick;
import com.example.meuuniversomarvel.viewmodel.PersonagemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonagensFragment extends Fragment implements PersonagensOnClick {

    private List<Result> results = new ArrayList<>();
    private PersonagemAdapter adapter;
    private RecyclerView recyclerView;
    private PersonagemViewModel viewModel;
    public static final String PERSONAGEM_KEY = "Personagem";
    private ProgressBar progressBar;
    private SearchView searchView;
    private String bandName = "Spider";

    private int pagina = 0;

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
        setScrollView();

        viewModel.getPersonagens(pagina);
        viewModel.getListaPersonagem().observe(this, results1 -> {
            adapter.atualizaListaP(results1);
        });

        viewModel.getLoading().observe(this, loading -> {
            if (loading){
                progressBar.setVisibility(View.VISIBLE);
            }else {
                progressBar.setVisibility(View.GONE);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                bandName = text;
                adapter.clear();
                viewModel.getPersonagens(1, bandName);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                if (text.length() > 2) {
                    bandName = text;
                    adapter.clear();
                    viewModel.getPersonagens(1, bandName);
                }
                return false;
            }
        });

        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_personagens);
        viewModel = ViewModelProviders.of(this).get(PersonagemViewModel.class);
        adapter = new PersonagemAdapter(results, this);
        progressBar = view.findViewById(R.id.progress_bar);
        searchView = view.findViewById(R.id.searchView);

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

    private void setScrollView(){

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState){
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy){
                super.onScrolled(recyclerView, dx, dy);

                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();

                int totalItemCount = gridLayoutManager.getItemCount();

                int lastVisible = gridLayoutManager.findLastVisibleItemPosition();

                boolean ultimoItem = lastVisible + 5 >= totalItemCount;

                if (totalItemCount > 0 && ultimoItem){
                    pagina++;
                    viewModel.getPersonagens(pagina);
                }
            }

        });

    }

}

