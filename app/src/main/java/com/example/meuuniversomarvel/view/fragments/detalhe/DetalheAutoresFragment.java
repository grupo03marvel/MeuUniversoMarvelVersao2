package com.example.meuuniversomarvel.view.fragments.detalhe;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.creators.Result;
import com.squareup.picasso.Picasso;

import static com.example.meuuniversomarvel.view.fragments.recycler.AutoresFragment.CRIADOR_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalheAutoresFragment extends Fragment {
    private ImageView imgFundo;
    private ImageView imgFrente;
    private TextView txtNome;


    public DetalheAutoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detalhe_autores, container, false);
        initView(view);

        if (getArguments() != null) {

            Result result = getArguments().getParcelable(CRIADOR_KEY);

            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgFrente);
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgFundo);


            txtNome.setText(result.getFullName());

        }


        return view;
    }

    private void initView(View view) {
        imgFrente = view.findViewById(R.id.imageAutor);
        imgFundo = view.findViewById(R.id.imageBannerAutor);
        txtNome = view.findViewById(R.id.textNomeAutor);

    }

}
