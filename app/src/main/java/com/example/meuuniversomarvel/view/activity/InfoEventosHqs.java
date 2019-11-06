package com.example.meuuniversomarvel.view.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meuuniversomarvel.R;

public class InfoEventosHqs extends AppCompatActivity {
    private ImageView imagemBanner;
    private ImageView imagemQuadrinho;
    private TextView txtInfoDetalhe1;
    private TextView txtInfoDetalhe2;
    private TextView txtTitulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_eventos_hqs);
        initViews();
    }

    private void initViews() {
        imagemBanner =findViewById(R.id.imagemBanner);
        imagemQuadrinho = findViewById(R.id.imageQuadrinho);
        txtInfoDetalhe1 = findViewById(R.id.textViewDetalhe1);
        txtInfoDetalhe2 = findViewById(R.id.textViewDetalhe);
        txtTitulo = findViewById(R.id.textViewTitulo);
    }

}
