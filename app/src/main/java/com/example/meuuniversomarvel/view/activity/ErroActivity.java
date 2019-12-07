package com.example.meuuniversomarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.util.AppJogoUtils;

import java.util.Timer;
import java.util.TimerTask;

public class ErroActivity extends AppCompatActivity {

    private Timer timer = new Timer();
    private AppJogoUtils nroErrosAtual = new AppJogoUtils();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erro);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        },2000);

    }

    private void jump(){
        timer.cancel();

        if (nroErrosAtual.getQtdeErros() < 3){
            startActivity(new Intent(ErroActivity.this, JogoActivity.class));
            finish();
        }else{
            startActivity(new Intent(ErroActivity.this, JogoFinalActivity.class));
            finish();
        }

    }
}
