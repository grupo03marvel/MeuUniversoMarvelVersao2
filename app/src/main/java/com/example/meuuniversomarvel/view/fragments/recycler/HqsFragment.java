package com.example.meuuniversomarvel.view.fragments.recycler;


import android.content.Intent;
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

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.comics.Result;
import com.example.meuuniversomarvel.view.adapter.HqAdapter;
import com.example.meuuniversomarvel.view.fragments.detalhe.DetalheHQFragment;
import com.example.meuuniversomarvel.view.interfaces.HqsOnClick;
import com.example.meuuniversomarvel.viewmodel.HqViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HqsFragment extends Fragment implements HqsOnClick {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private HqAdapter adapter;
    private List<Result> listaComics = new ArrayList<>();
    private HqViewModel viewModel;
    public static final String HQ_KEY = "hq";

    private int pagina = 0;

    public HqsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hqs, container, false);

        recyclerView = view.findViewById(R.id.recyclerItensCat);
        progressBar = view.findViewById(R.id.progress_bar);
        viewModel = ViewModelProviders.of(this).get(HqViewModel.class);
        adapter = new HqAdapter(listaComics, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 3));
        setScrollView();

        viewModel.getAllComics(pagina);

        viewModel.getListaHqs().observe(this, resultaLista -> {
            adapter.atualizaLista(resultaLista);
        });

        viewModel.getLoading().observe(this, loading -> {
            if (loading){
                progressBar.setVisibility(View.VISIBLE);
            }else {
                progressBar.setVisibility(View.GONE);
            }
        });

        return view;
    }

    @Override
    public void click(Result result){
        Bundle bundle = new Bundle();
        bundle.putParcelable(HQ_KEY, result);
        Fragment detalheFragment = new DetalheHQFragment();
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

                boolean ultimoItem = lastVisible + 19 >= totalItemCount;

                if (totalItemCount > 0 && ultimoItem){
                    pagina++;
                    viewModel.getAllComics(pagina);
                }
            }

        });

    }

}
