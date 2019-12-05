package com.example.meuuniversomarvel.view.fragments.detalhe;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.characters.Result;
import com.example.meuuniversomarvel.viewmodel.FavoritosViewModel;
import com.example.meuuniversomarvel.viewmodel.PersonagemViewModel;
import com.squareup.picasso.Picasso;

import static com.example.meuuniversomarvel.view.fragments.recycler.PersonagensFragment.PERSONAGEM_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalhePersonagemFragment extends Fragment {
    private ImageView imgFundo;
    private TextView txtDescricao;
    private TextView txtNomePer;
    private ImageView btnFavoritos;
    private FavoritosViewModel viewModel;


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

            Result result = getArguments().getParcelable(PERSONAGEM_KEY);

            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgFundo);

            txtDescricao.setText(result.getDescription());
            txtNomePer.setText(result.getName());

            btnFavoritos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewModel.inserePersonagemFavo(result);
                }
            });

        }

        return view;
    }

    private void initView(View view) {
        btnFavoritos = view.findViewById(R.id.btnImageFavoritos);
        txtDescricao = view.findViewById(R.id.textViewDetalhe);
        imgFundo = view.findViewById(R.id.imagemBanner);
        txtNomePer = view.findViewById(R.id.textViewTitulo);
    }

}
