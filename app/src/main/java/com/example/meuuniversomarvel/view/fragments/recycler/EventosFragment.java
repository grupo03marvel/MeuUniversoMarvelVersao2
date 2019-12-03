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
import com.example.meuuniversomarvel.model.events.ResultEvents;
import com.example.meuuniversomarvel.view.adapter.EventosAdapter;
import com.example.meuuniversomarvel.view.fragments.detalhe.DetalhesEventosFragment;
import com.example.meuuniversomarvel.view.interfaces.EventosOnClick;
import com.example.meuuniversomarvel.viewmodel.EventosViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventosFragment extends Fragment implements EventosOnClick {
    private List<ResultEvents> results = new ArrayList<>();
    private EventosViewModel viewModel;
    private RecyclerView recyclerView;
    private EventosAdapter adapter;
    public static final String EVENTOS_KEY = "Eventos";


    public EventosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eventos, container, false);

        initViews(view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));


        viewModel.getEventos();
        viewModel.getListaEventos().observe(this, results1 -> {
            adapter.atualizaListaE(results1);

        });


        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_eventos);
        viewModel = ViewModelProviders.of(this).get(EventosViewModel.class);
        adapter = new EventosAdapter(results, this);
    }

    @Override
    public void eventosOnClick(ResultEvents resultEvents) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(EVENTOS_KEY, resultEvents);

        Fragment detalheFragment = new DetalhesEventosFragment();
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
