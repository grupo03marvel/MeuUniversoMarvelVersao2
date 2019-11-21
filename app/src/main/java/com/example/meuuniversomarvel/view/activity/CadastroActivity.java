package com.example.meuuniversomarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meuuniversomarvel.R;
import com.google.android.material.textfield.TextInputLayout;

public class CadastroActivity extends AppCompatActivity {


    private TextInputLayout Nomecad;
    private TextInputLayout SenhaCad;
    private TextInputLayout EmailCad;
    private TextInputLayout IdadeCad;
    private Button btnCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);



        Nomecad =findViewById(R.id.nomeUsuario);
        SenhaCad = findViewById(R.id.senhaCadastro);
        EmailCad = findViewById(R.id.EmailDoUsuario);
        IdadeCad = findViewById(R.id.IdadeDoUsuario);
        btnCad = findViewById(R.id.btnRegistroCadastro);

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer idadenumero;
                String nome= Nomecad.getEditText().getText().toString();
                String senha = SenhaCad.getEditText().getText().toString();
                String email = EmailCad.getEditText().getText().toString();
                String idade = IdadeCad.getEditText().getText().toString();

                try{idadenumero = Integer.valueOf(idade);}catch(NumberFormatException ex){
                    idadenumero = -1;
            }


                if(!nome.isEmpty() && idadenumero>-1 && !senha.isEmpty() && !email.isEmpty()){

                    // Adicionar Activit de destino **********
                    Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                    Bundle bundle = new Bundle();

                    bundle.putString("NOME", nome);
                    bundle.putString("SENHA", senha);
                    bundle.putString("EMAIL", email);
                    bundle.putInt("IDADE", idadenumero);


                    intent.putExtras(bundle);
                    startActivity(intent);

                } else {
                    Nomecad.setError("O campo não pode estar vazio");
                    SenhaCad.setError("O campo não pode estar vazio");
                    EmailCad.setError("O campo não pode estar vazio");
                    IdadeCad.setError("O campo não pode estar vazio");
                }

            }
        });


    }
}
