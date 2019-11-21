package com.example.meuuniversomarvel.view.fragments.detalhe;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meuuniversomarvel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalhePersonagemFragment extends Fragment {


    public DetalhePersonagemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalhe_personagem, container, false);
    }

}
