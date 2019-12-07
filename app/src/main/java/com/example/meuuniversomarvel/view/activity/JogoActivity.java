package com.example.meuuniversomarvel.view.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.util.AppJogoUtils;
import com.example.meuuniversomarvel.viewmodel.PerguntaViewModel;

import java.util.Random;

public class JogoActivity extends AppCompatActivity {

    private ImageView imgView;
    private TextView txtViewPergunta;
    private Button btResposta1;
    private Button btResposta2;
    private Button btResposta3;
    private Button btResposta4;
    private int qtdeErros;
    private int qtdeAcertos;
    private PerguntaViewModel viewModel;
    private static int numRandom;
    private AppJogoUtils nroAtual = new AppJogoUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        qtdeErros = nroAtual.getQtdeErros();
        qtdeAcertos = nroAtual.getQtdeNumAcertos();

        initViews();
        viewModel.buscaPerguntas();

        viewModel.retornaPerguntas().observe(this, perguntaRetornada ->{
//
//            System.out.println("O que vem da lista qtde erros: "+ nroAtual.getQtdeErros());
//            System.out.println("O que vem da lista qtde acertos: "+ nroAtual.getQtdeNumAcertos());

            int min = 0;
            int max = perguntaRetornada.size()-1;

            Random r = new Random();
            numRandom = r.nextInt(max - min + 1) + min;

            //for (int i = 0; i < perguntaRetornada.size(); i++){

                    Resources res = getResources();
                    String mDrawableName = perguntaRetornada.get(numRandom).getImagem();
                    int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
                    imgView.setImageResource(resID);
                    //imgView.setImageDrawable(perguntaRetornada.get(0).getImagem());
                    txtViewPergunta.setText(perguntaRetornada.get(numRandom).getTexto());
                    btResposta1.setText(perguntaRetornada.get(numRandom).getRespostas().get(0).getA());
                    btResposta2.setText(perguntaRetornada.get(numRandom).getRespostas().get(0).getB());
                    btResposta3.setText(perguntaRetornada.get(numRandom).getRespostas().get(0).getC());
                    btResposta4.setText(perguntaRetornada.get(numRandom).getRespostas().get(0).getD());

                    int finalI = 0;
                    btResposta1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (perguntaRetornada.get(numRandom).getCorreta().equals(perguntaRetornada.get(numRandom).getRespostas().get(0).getA())){
                                qtdeAcertos = 1;
                               metodoAcertou(qtdeAcertos);

                            }else{
                                qtdeErros = 1;
                                metodoErrou(qtdeErros);
                            }
                        }
                    });
                    btResposta2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (perguntaRetornada.get(numRandom).getCorreta().equals(perguntaRetornada.get(numRandom).getRespostas().get(0).getB())){
                                qtdeAcertos = 1;
                                metodoAcertou(qtdeAcertos);
                            }else{
                                qtdeErros = 1;
                                metodoErrou(qtdeErros);
                            }
                        }
                    });
                    btResposta3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (perguntaRetornada.get(numRandom).getCorreta().equals(perguntaRetornada.get(numRandom).getRespostas().get(0).getC())){
                                qtdeAcertos = 1;
                                metodoAcertou(qtdeAcertos);
                            }else{
                                qtdeErros = 1;
                                metodoErrou(qtdeErros);
                            }
                        }
                    });
                    btResposta4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (perguntaRetornada.get(numRandom).getCorreta().equals(perguntaRetornada.get(numRandom).getRespostas().get(0).getD())){
                                qtdeAcertos = 1;
                                metodoAcertou(qtdeAcertos);
                            }else{
                                qtdeErros = 1;
                                metodoErrou(qtdeErros);
                            }
                        }
                    });




           // }
        });





    }

    private void initViews() {

        imgView = findViewById(R.id.imageViewBanner);
        txtViewPergunta = findViewById(R.id.textViewPergunta);
        btResposta1 = findViewById(R.id.buttonResposta1);
        btResposta2 = findViewById(R.id.buttonResposta2);
        btResposta3 = findViewById(R.id.buttonResposta3);
        viewModel = ViewModelProviders.of(this).get(PerguntaViewModel.class);
        btResposta4 = findViewById(R.id.buttonResposta4);

    }

    private void metodoErrou(int erroCount){
        Toast.makeText(JogoActivity.this, "Erroooou", Toast.LENGTH_SHORT).show();
        erroCount+=1;
        nroAtual.setQtdeErros(erroCount);
        System.out.println("O que vem da lista qtde erros: "+ nroAtual.getQtdeErros());
        System.out.println("O que vem da lista qtde acertos: "+ nroAtual.getQtdeNumAcertos());
        startActivity(new Intent(JogoActivity.this, ErroActivity.class));
    }

    private void metodoAcertou(int acertoCount){
        Toast.makeText(JogoActivity.this, "Acertooooou", Toast.LENGTH_SHORT).show();
        acertoCount += 1;
        nroAtual.setQtdeNumAcertos(acertoCount);
        System.out.println("O que vem da lista qtde erros: "+ nroAtual.getQtdeErros());
        System.out.println("O que vem da lista qtde acertos: "+ nroAtual.getQtdeNumAcertos());
        startActivity(new Intent(JogoActivity.this, AcertoActivity.class));
    }

}
