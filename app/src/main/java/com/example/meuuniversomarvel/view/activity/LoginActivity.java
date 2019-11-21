package com.example.meuuniversomarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meuuniversomarvel.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextView textViewLogin;
    private ImageView imageViewLogin;
    private TextInputLayout textInputLogin;
    private TextInputLayout textInputSenha;
    private Button buttonEntrar;
    private Button buttonEsqueciSenha;
    private Button buttonCriarConta;
    private TextView textViewAcessarContaFaceGoogle;
    private LoginButton loginButtonFace;
    private ImageButton imageButtonGoogle;
    //private GoogleSignInOptions loginGoogle = new GoogleSignInOptions(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail;
    public static CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        textViewLogin = findViewById(R.id.textViewlogin);
        imageViewLogin = findViewById(R.id.imageViewLogin);
        textInputLogin = findViewById(R.id.textInputLayoutUsuario);
        textInputSenha = findViewById(R.id.textInputLayoutSenha);
        buttonEntrar = findViewById(R.id.buttonEntrar);
        buttonEsqueciSenha = findViewById(R.id.buttonEsqueciSenha);
        buttonCriarConta = findViewById(R.id.buttonCriarConta);
        loginButtonFace = findViewById(R.id.login_button_facebook);
        callbackManager = CallbackManager.Factory.create();
        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = textInputLogin.getEditText().getText().toString();
                String senha = textInputSenha.getEditText().getText().toString();

                if (Patterns.EMAIL_ADDRESS.matcher(email).matches() && !senha.isEmpty()){
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    textInputLogin.setError("O usuário digitado não é válido");
                    textInputLogin.setErrorEnabled(false);
                    Snackbar.make(view, "O usuário digitado não é válido", Snackbar.LENGTH_LONG).show();
                } else if (senha.isEmpty()){
                    textInputSenha.setError("O campo senha deve ser preenchido");
                    textInputSenha.setErrorEnabled(false);
                    Snackbar.make(view, "O campo senha deve ser preenchido", Snackbar.LENGTH_LONG).show();
                }



            }
        });

        buttonEsqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RecuperarSenhaActivity.class));
            }
        });

        buttonCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, CadastroActivity.class));
            }
        });


        loginButtonFace.setPermissions("email");

        loginButtonFace.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                startActivity(new Intent(LoginActivity.this, CadastroActivity.class));
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

}
