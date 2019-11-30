package com.example.meuuniversomarvel.view.fragments.recycler;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.creators.Result;
import com.example.meuuniversomarvel.view.adapter.CriadoresAdapter;
import com.example.meuuniversomarvel.view.fragments.detalhe.DetalheAutoresFragment;
import com.example.meuuniversomarvel.view.interfaces.CriadoresOnClick;
import com.example.meuuniversomarvel.viewmodel.AutoresViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AutoresFragment extends Fragment {
public class AutoresFragment extends Fragment implements CriadoresOnClick {
    private List<Result> results = new ArrayList<>();
    private AutoresViewModel viewModel;
    private RecyclerView recyclerView;
    private CriadoresAdapter adapter;
    public static final String CRIADOR_KEY = "Criador";

    public AutoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_autores, container, false);
        initViews(view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));


        viewModel.getCriadores();
        viewModel.getListaCriadores().observe(this, results1 -> {
            adapter.atualizaListaC(results1);

        });


        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_autores);
        viewModel = ViewModelProviders.of(this).get(AutoresViewModel.class);
        adapter = new CriadoresAdapter(results, this);
    }


    @Override
    public void criadoresOnClick(Result result) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CRIADOR_KEY, result);

        Fragment detalheFragment = new DetalheAutoresFragment();
        detalheFragment.setArguments(bundle);
        replaceFragment(detalheFragment);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerPrincipal, fragment);
        transaction.commit();
    }

}
