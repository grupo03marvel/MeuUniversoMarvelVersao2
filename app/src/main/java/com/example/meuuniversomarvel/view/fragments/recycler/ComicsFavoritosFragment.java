package com.example.meuuniversomarvel.view.fragments.recycler;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.view.adapter.FavoritosAdapter;
import com.example.meuuniversomarvel.viewmodel.FavoritosViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComicsFavoritosFragment extends Fragment {

    private RecyclerView recyclerView;
    private FavoritosAdapter adapter;
    private FavoritosViewModel viewModel;



    public ComicsFavoritosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comics_favoritos, container, false);

        return view;
    }

}
