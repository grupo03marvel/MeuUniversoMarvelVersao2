package com.example.meuuniversomarvel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.util.AppJogoUtils;

public class JogoFinalActivity extends AppCompatActivity {

    private TextView resultadoFinal;
    private Button btIrHome;
    private Button btJogarNovamente;
    private AppJogoUtils nroAcertos = new AppJogoUtils();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_final);

        initViews();

        resultadoFinal.setText("SEU RESULTADO FOI: " + nroAcertos.getQtdeNumAcertos());

        btIrHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nroAcertos.setQtdeErros(0);
                nroAcertos.setQtdeNumAcertos(0);
                startActivity(new Intent(JogoFinalActivity.this, HomeActivity.class));
            }
        });

        btJogarNovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nroAcertos.setQtdeErros(0);
                nroAcertos.setQtdeNumAcertos(0);
                startActivity(new Intent(JogoFinalActivity.this, JogoActivity.class));
            }
        });


    }

    private void initViews() {
        resultadoFinal = findViewById(R.id.textViewResultado);
        btIrHome = findViewById(R.id.buttonIrHome);
        btJogarNovamente = findViewById(R.id.buttonJogarNovamente);
    }
}
