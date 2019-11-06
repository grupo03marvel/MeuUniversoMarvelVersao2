package com.example.meuuniversomarvel.view.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.data.remote.OnClickInfo;
import com.example.meuuniversomarvel.viewmodel.ItemHome;
import com.example.meuuniversomarvel.view.activity.InfoAutoresPersonagens;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonagensFragment extends Fragment implements OnClickInfo {


    public PersonagensFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personagens, container, false);
    }

    @Override
    public void onClick(ItemHome itemHome) {
        Intent intent = new Intent(getContext(), InfoAutoresPersonagens.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("ITEMHOME", itemHome);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}