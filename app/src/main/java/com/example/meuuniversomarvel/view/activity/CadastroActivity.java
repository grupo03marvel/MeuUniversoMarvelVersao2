package com.example.meuuniversomarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.util.AppUtil;
import com.example.meuuniversomarvel.util.AppUtils;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {


    private TextInputLayout nomeCadastro;
    private TextInputLayout senhaCadastro;
    private TextInputLayout emailCadastro;
    private TextInputLayout idadeCadastro;
    private Button btnCadastrar;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initViews();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer idadenumero;
                String nome= nomeCadastro.getEditText().getText().toString();
                String senha = senhaCadastro.getEditText().getText().toString();
                String email = emailCadastro.getEditText().getText().toString();
                String idade = idadeCadastro.getEditText().getText().toString();

                try{idadenumero = Integer.valueOf(idade);}catch(NumberFormatException ex){
                    idadenumero = -1;
                }

                if (validaCampos(nome, senha, email, idade)){
                    registrarUsuario(nome, senha, email, idade);
                }


            }
        });


    }

    private void registrarUsuario(String nome, String senha, String email, String idade) {

        progressBar.setVisibility(View.VISIBLE);

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(task -> {

                    progressBar.setVisibility(View.GONE);

                    if (task.isSuccessful()){
                        AppUtil.salvarIdUsuario(CadastroActivity.this, FirebaseAuth.getInstance()
                                .getCurrentUser().getUid());
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    }else{

                        Snackbar.make(btnCadastrar, task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }

                });

    }

    private boolean validaCampos(String nome, String senha, String email, String idade) {

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailCadastro.setError("Email inválido");
            emailCadastro.setErrorEnabled(false);
            emailCadastro.requestFocus();
            Snackbar.make(emailCadastro, "Email inválido", Snackbar.LENGTH_LONG).show();
            return false;
        } if (email.isEmpty()) {
            emailCadastro.setError("O campo email não pode ser vazio");
            emailCadastro.setErrorEnabled(false);
            emailCadastro.requestFocus();
            Snackbar.make(emailCadastro, "O campo email não pode ser vazio", Snackbar.LENGTH_LONG).show();
            return false;
        } if (senha.isEmpty()) {
            senhaCadastro.setError("O campo senha não deve ser vazio");
            senhaCadastro.setErrorEnabled(false);
            senhaCadastro.requestFocus();
            Snackbar.make(senhaCadastro, "O campo senha não deve ser vazio", Snackbar.LENGTH_LONG).show();
            return false;
        } if (senha.length() < 6) {
            senhaCadastro.setError("A senha deve ter mais de 6 caracters");
            senhaCadastro.setErrorEnabled(false);
            senhaCadastro.requestFocus();
            Snackbar.make(senhaCadastro, "A senha deve ter mais de 6 caracters", Snackbar.LENGTH_LONG).show();
            return false;
        } if (nome.isEmpty()) {
            nomeCadastro.setError("O campo nome não pode ser vazio");
            nomeCadastro.setErrorEnabled(false);
            nomeCadastro.requestFocus();
            Snackbar.make(nomeCadastro, "O campo nome não pode ser vazio", Snackbar.LENGTH_LONG).show();
            return false;
        }

        return true;

    }

    private void initViews() {

        nomeCadastro =findViewById(R.id.nomeUsuario);
        senhaCadastro = findViewById(R.id.senhaCadastro);
        emailCadastro = findViewById(R.id.EmailDoUsuario);
        idadeCadastro = findViewById(R.id.IdadeDoUsuario);
        btnCadastrar = findViewById(R.id.btnRegistroCadastro);
        progressBar = findViewById(R.id.progress_bar);


    }
}
