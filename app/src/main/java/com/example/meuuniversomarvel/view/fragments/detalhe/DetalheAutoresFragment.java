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
public class DetalheAutoresFragment extends Fragment {


    public DetalheAutoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detalhe_autores, container, false);

        return view;
    }

}
