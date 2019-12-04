package com.example.meuuniversomarvel.view.fragments.detalhe;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.events.ResultEvents;
import com.example.meuuniversomarvel.viewmodel.EventosViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import static com.example.meuuniversomarvel.view.fragments.recycler.EventosFragment.EVENTOS_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalhesEventosFragment extends Fragment {
    private ImageView imgFundo;
    private TextView txtNome;
    private TextView txtDescricao;
    private ImageView icoonFavoritos;
    private EventosViewModel viewModel;


    public DetalhesEventosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detalhes_eventos, container, false);
        initView(view);

        if (getArguments() != null) {

            ResultEvents result = getArguments().getParcelable(EVENTOS_KEY);

            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgFundo);

            txtDescricao.setText(result.getDescription());
            txtNome.setText(result.getTitle());

        }

        icoonFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getArguments() != null) {

                    ResultEvents result = getArguments().getParcelable(EVENTOS_KEY);

                    Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgFundo);
                    txtNome.setText(result.getTitle());

                    viewModel.insereEventos(result);

                }
            }
        });


        return view;
    }

    private void initView(View view) {

        icoonFavoritos = view.findViewById(R.id.icone_de_favoritar);
        txtDescricao = view.findViewById(R.id.textDetalheEventos);
        imgFundo = view.findViewById(R.id.imagemBannerEventos);
        txtNome = view.findViewById(R.id.textEventos);
    }

}

