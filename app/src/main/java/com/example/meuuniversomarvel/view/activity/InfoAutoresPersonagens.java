package com.example.meuuniversomarvel.view.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meuuniversomarvel.R;

public class InfoAutoresPersonagens extends AppCompatActivity {
    private ImageView imagemBannerPers;
    private ImageView imagemPersonagem;
    private TextView txtInfoDetalhe;
    private TextView txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_autores_personagens);
        initViews();

    }

    private void initViews() {
        imagemBannerPers = findViewById(R.id.imagemBanner);
        imagemPersonagem = findViewById(R.id.imageQuadrinho);
        txtInfoDetalhe = findViewById(R.id.textViewDetalhe1);
        txtTitulo = findViewById(R.id.textViewDetalhe);
    }
}
