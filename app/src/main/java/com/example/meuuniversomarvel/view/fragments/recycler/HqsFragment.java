package com.example.meuuniversomarvel.view.fragments.recycler;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.view.adapter.HqAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HqsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private HqAdapter


    public HqsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hqs, container, false);

        return view;
    }

}
