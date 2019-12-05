package com.example.meuuniversomarvel.view.fragments.recycler;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.characters.Result;
import com.example.meuuniversomarvel.model.favoritos.Favoritos;
import com.example.meuuniversomarvel.view.adapter.FavoritosAdapter;
import com.example.meuuniversomarvel.view.interfaces.PersonagensOnClick;
import com.example.meuuniversomarvel.viewmodel.FavoritosViewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;



public class PersonagemFavoritosFragment extends Fragment implements PersonagensOnClick{

    private RecyclerView recyclerView;
    private FavoritosAdapter adapter;
    private FavoritosViewModel viewModel;

    private List<Result> favortosList = new ArrayList<>();


    public PersonagemFavoritosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personagem_favoritos, container, false);

        adapter = new FavoritosAdapter(favortosList, this );

        viewModel = ViewModelProviders.of(this).get(FavoritosViewModel.class);

        recyclerView = view.findViewById(R.id.recycler_personagem_favorito);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        viewModel.buscaFavoritos();


        return view;

    }


    @Override
    public void personagemOnClick(Result result) {

    }
}
