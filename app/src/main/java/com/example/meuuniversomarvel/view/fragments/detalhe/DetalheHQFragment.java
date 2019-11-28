package com.example.meuuniversomarvel.view.fragments.detalhe;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.comics.Result;
import com.squareup.picasso.Picasso;

import static com.example.meuuniversomarvel.view.fragments.recycler.HqsFragment.HQ_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalheHQFragment extends Fragment {

    private ImageView imgViewBannerTopo;
    private ImageView imgViewComic;
    private TextView txtViewTitulo;
    private TextView txtViewDetalhe;
    private TextView txtViewDataPublicacao;
    private TextView txtViewPreco;
    private TextView txtViewPaginas;

    public DetalheHQFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalhe_hq, container, false);

        initViews(view);

        if (getArguments() != null){

            Result result = getArguments().getParcelable(HQ_KEY);
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgViewComic);
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgViewBannerTopo);
            txtViewTitulo.setText(result.getTitle());
            System.out.println("Valor do título: " + result.getTitle());
            txtViewDetalhe.setText(result.getDescription());
            System.out.println("Valor da descricao: " + result.getDescription());



        }
        return view;
    }

    private void initViews(View view) {


        imgViewComic = view.findViewById(R.id.imageQuadrinho);
        txtViewTitulo = view.findViewById(R.id.textViewTitulo);
        txtViewDetalhe = view.findViewById(R.id.textViewDetalhe);
        //txtViewDataPublicacao = view.findViewById(R.id.textViewDataPublicacao);
        //txtViewPreco = view.findViewById(R.id.textViewPreco);
        //txtViewPaginas = view.findViewById(R.id.textViewPaginas);
        imgViewBannerTopo = view.findViewById(R.id.imagemBanner);
    }

}
