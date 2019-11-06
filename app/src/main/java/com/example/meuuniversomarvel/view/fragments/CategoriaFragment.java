package com.example.meuuniversomarvel.view.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.meuuniversomarvel.view.adapter.ItemAdapter;
import com.example.meuuniversomarvel.viewmodel.ItemHome;
import com.example.meuuniversomarvel.viewmodel.ModeloHome;
import com.example.meuuniversomarvel.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.meuuniversomarvel.view.activity.HomeActivity.MH_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriaFragment extends Fragment {
    private String nomePagina;
    private ImageView imagemCategoria;
    private List<ItemHome> listaItens;
    private ItemAdapter adapter;
    private RecyclerView recyclerView;

    public CategoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categoria, container, false);
        initViews(view);

        if(getArguments() != null){
            ModeloHome modeloHome = getArguments().getParcelable(MH_KEY);

            if(modeloHome != null){

                Drawable drawable = getResources().getDrawable(modeloHome.getImagemCategoria());

                imagemCategoria.setImageDrawable(drawable);

                List<ItemHome> itemHomeLists = new ArrayList<>();

                itemHomeLists = modeloHome.getListaItensHome();

                adapter = new ItemAdapter(itemHomeLists);

                GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 3);

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(linearLayoutManager);

            }

        }



        return view;
    }

    public void initViews(View view){
        //nomePagina como não é um item do XML precisa ser declarado?
        imagemCategoria = view.findViewById(R.id.imagemCategoria);
        recyclerView = view.findViewById(R.id.recyclerItensCat);
    }

    public List<ItemHome> popularLista(){
        listaItens.add(new ItemHome(R.drawable.hq3, "Shrek"));
        listaItens.add(new ItemHome(R.drawable.hq3, "Nois"));
        listaItens.add(new ItemHome(R.drawable.hq3, "lalala"));

        return listaItens;
    }
}
