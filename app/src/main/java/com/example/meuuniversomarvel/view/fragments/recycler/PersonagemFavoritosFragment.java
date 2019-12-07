package com.example.meuuniversomarvel.view.fragments.recycler;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import com.example.meuuniversomarvel.util.AppUtil;
import com.example.meuuniversomarvel.view.adapter.FavoritosAdapter;
import com.example.meuuniversomarvel.view.fragments.detalhe.DetalhePersonagemFragment;
import com.example.meuuniversomarvel.view.interfaces.FavoriteItemRemoveClick;
import com.example.meuuniversomarvel.view.interfaces.PersonagensOnClick;
import com.example.meuuniversomarvel.viewmodel.FavoritosViewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.meuuniversomarvel.view.fragments.recycler.PersonagensFragment.PERSONAGEM_KEY;


public class PersonagemFavoritosFragment extends Fragment implements PersonagensOnClick, FavoriteItemRemoveClick {

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

        adapter = new FavoritosAdapter(favortosList, this, this);

        viewModel = ViewModelProviders.of(this).get(FavoritosViewModel.class);

        recyclerView = view.findViewById(R.id.recycler_personagem_favorito);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        viewModel.buscaFavoritos();

        carregarFavorites();


        return view;

    }


    @Override
    public void personagemOnClick(Result result) {

    }


    private void carregarFavorites() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(AppUtil.getIdUsuario(getContext()) + "/favoritos");
        reference.orderByKey().addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Result> results = new ArrayList<>();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Result result = child.getValue(Result.class);
                    results.add(result);
                }

                adapter.update(results);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void addFavoriteClickListener(Result result) {


    }

    @Override
    public void removeFavoriteClickListener(Result result) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(AppUtil.getIdUsuario(getContext()) + "/favoritos");
        reference.orderByChild("id").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot resultSnapshot : dataSnapshot.getChildren()) {
                    Result resultFirebase = resultSnapshot.getValue(Result.class);

                    if (result.getId().equals(resultFirebase.getId())) {
                        resultSnapshot.getRef().removeValue();
                        adapter.removeItem(result);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}