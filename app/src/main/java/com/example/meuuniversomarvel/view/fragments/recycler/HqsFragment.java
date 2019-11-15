package com.example.meuuniversomarvel.view.fragments.recycler;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.comics.Result;
import com.example.meuuniversomarvel.view.adapter.HqAdapter;
import com.example.meuuniversomarvel.viewmodel.hqViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HqsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private HqAdapter adapter;
    private List<Result> listaComics = new ArrayList<>();
    private hqViewModel viewModel;

    private Result result = new Result();



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
        viewModel = ViewModelProviders.of(this).get(hqViewModel.class);
        adapter = new HqAdapter(listaComics);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 3));

        viewModel.getAllComics();

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


}
