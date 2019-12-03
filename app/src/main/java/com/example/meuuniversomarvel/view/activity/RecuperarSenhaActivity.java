package com.example.meuuniversomarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.meuuniversomarvel.R;
import com.google.android.material.textfield.TextInputLayout;

public class RecuperarSenhaActivity extends AppCompatActivity {
    Button btnRecuperar;
    TextInputLayout email;


    public static final String END_EMAIL_KEY = "email";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recuperar_senha_tela);

        btnRecuperar = findViewById(R.id.botaoRecuperar);
        email = findViewById(R.id.digitarEmail);



        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String endemail = email.getEditText().getText().toString();


                if (!endemail.isEmpty() ){
                    //Criando uma nova instancia do tipo Intent
                    Intent intent = new Intent(RecuperarSenhaActivity.this, LoginActivity.class);

                    //Criando uma nova instancia do bundle
                    Bundle bundle = new Bundle();

                    //Passando os dados para o bundle
                    bundle.putString(END_EMAIL_KEY,endemail);


                    intent.putExtras(bundle);

                    //toast
                    Context context = getApplicationContext();
                    CharSequence text = "Instruções enviada para o email!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();


                    //Passo a intent para a startActivity
                    startActivity(intent);

                }
                else{

                    email.setError("Preencha o campo com seu endereço de email");


                }


            }
        });

    }
}
