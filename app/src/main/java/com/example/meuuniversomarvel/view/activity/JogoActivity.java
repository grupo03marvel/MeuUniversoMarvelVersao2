package com.example.meuuniversomarvel.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.jogo.Perguntum;
import com.example.meuuniversomarvel.viewmodel.PerguntaViewModel;

import java.util.ArrayList;
import java.util.List;

public class JogoActivity extends AppCompatActivity {

    private List<Perguntum> perguntaList = new ArrayList<>();
    private TextView txtViewPergunta;
    private Button btResposta1;
    private Button btResposta2;
    private Button btResposta3;
    private Button btResposta4;
    private int qtdeErros;
    private PerguntaViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);


        initViews();
        viewModel.buscaPerguntas();

        viewModel.retornaPerguntas().observe(this, perguntaRetornada ->{

            System.out.println("O que vem da lista: "+perguntaRetornada.get(0).getPergunta().get(0).getRespostas().get(0).getC());

            for (int i = 0; i < perguntaRetornada.size(); i++){



                    txtViewPergunta.setText(perguntaRetornada.get(i).getPergunta().get(i).getTexto());
                    btResposta1.setText(perguntaRetornada.get(i).getPergunta().get(i).getRespostas().get(i).getA());
                    btResposta2.setText(perguntaRetornada.get(i).getPergunta().get(i).getRespostas().get(i).getB());
                    btResposta3.setText(perguntaRetornada.get(i).getPergunta().get(i).getRespostas().get(i).getC());
                    btResposta4.setText(perguntaRetornada.get(i).getPergunta().get(i).getRespostas().get(i).getD());

                    int finalI = i;
                    btResposta1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (perguntaRetornada.get(finalI).getPergunta().get(finalI).getCorreta().equals(perguntaRetornada.get(finalI).getPergunta().get(finalI).getRespostas().get(finalI).getA())){
                                Toast.makeText(JogoActivity.this, "Acertooooou", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(JogoActivity.this, "Erroooou", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    btResposta2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (perguntaRetornada.get(finalI).getPergunta().get(finalI).getCorreta().equals(perguntaRetornada.get(finalI).getPergunta().get(finalI).getRespostas().get(finalI).getB())){
                                Toast.makeText(JogoActivity.this, "Acertooooou", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(JogoActivity.this, "Erroooou", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    btResposta3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (perguntaRetornada.get(finalI).getPergunta().get(finalI).getCorreta().equals(perguntaRetornada.get(finalI).getPergunta().get(finalI).getRespostas().get(finalI).getC())){
                                Toast.makeText(JogoActivity.this, "Acertooooou", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(JogoActivity.this, "Erroooou", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    btResposta4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (perguntaRetornada.get(finalI).getPergunta().get(finalI).getCorreta().equals(perguntaRetornada.get(finalI).getPergunta().get(finalI).getRespostas().get(finalI).getD())){
                                Toast.makeText(JogoActivity.this, "Acertooooou", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(JogoActivity.this, "Erroooou", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });




            }
        });





    }

    private void initViews() {

        txtViewPergunta = findViewById(R.id.textViewPergunta);
        btResposta1 = findViewById(R.id.buttonResposta1);
        btResposta2 = findViewById(R.id.buttonResposta2);
        btResposta3 = findViewById(R.id.buttonResposta3);
        viewModel = ViewModelProviders.of(this).get(PerguntaViewModel.class);
        btResposta4 = findViewById(R.id.buttonResposta4);

    }



}
