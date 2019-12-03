package com.example.meuuniversomarvel.view.fragments.detalhe;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.characters.ResultCharacters;
import com.squareup.picasso.Picasso;

import static com.example.meuuniversomarvel.view.fragments.recycler.PersonagensFragment.PERSONAGEM_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalhePersonagemFragment extends Fragment {
    private ImageView imgFundo;
    private ImageView imgFrente;
    private TextView txtDescricao;
    private TextView txtNomePer;


    public DetalhePersonagemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalhe_personagem, container, false);
        initView(view);

        if (getArguments() != null) {

            ResultCharacters result = getArguments().getParcelable(PERSONAGEM_KEY);

            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgFrente);
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgFundo);

            txtDescricao.setText(result.getDescription());
            txtNomePer.setText(result.getName());

        }


        return view;
    }

    private void initView(View view) {
        txtDescricao = view.findViewById(R.id.textViewDetalhePersonagem);
        imgFrente = view.findViewById(R.id.imagePersonagem);
        imgFundo = view.findViewById(R.id.imageBannerPers);
        txtNomePer = view.findViewById(R.id.textNomePersonagem);
    }

}
