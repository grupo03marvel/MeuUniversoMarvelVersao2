package com.example.meuuniversomarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.util.AppUtil;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

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
    private SignInButton btnLoginGoogle;
    private CallbackManager callbackManager;
    private static final int RC_SIGN_IN = 1001;
    public static final String GOOGLE_ACCOUNT = "google_account";
    private GoogleSignInClient googleSignInClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        initViews();

        callbackManager = CallbackManager.Factory.create();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        //Faz o login com email e senha
        buttonEntrar.setOnClickListener(v -> loginEmail());

        loginButtonFace.setOnClickListener(v -> loginFacebook());

        btnLoginGoogle.setOnClickListener(view -> {

            //Intent de logar
            Intent signInIntent = googleSignInClient.getSignInIntent();

            //chamada do método startActivityForResult passando a intent de login e um codigo de identificação para identificação da onde os dados estão vindo
            //na sobrescrita do método onActivityResult
            startActivityForResult(signInIntent, 101);

        });


        AppUtil.printKeyHash(this);

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

    }

    private void initViews() {

        textViewLogin = findViewById(R.id.textViewlogin);
        imageViewLogin = findViewById(R.id.imageViewLogin);
        textInputLogin = findViewById(R.id.textInputLayoutUsuario);
        textInputSenha = findViewById(R.id.textInputLayoutSenha);
        buttonEntrar = findViewById(R.id.buttonEntrar);
        buttonEsqueciSenha = findViewById(R.id.buttonEsqueciSenha);
        buttonCriarConta = findViewById(R.id.buttonCriarConta);
        loginButtonFace = findViewById(R.id.login_button_facebook);
        btnLoginGoogle = findViewById(R.id.sign_in_button);


    }

    public void loginEmail() {

        String email = textInputLogin.getEditText().getText().toString();
        String password = textInputSenha.getEditText().getText().toString();

       if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            textInputLogin.setError("O usuário digitado não é válido");
            textInputLogin.setErrorEnabled(false);
            Snackbar.make(textInputLogin, "O usuário digitado não é válido", Snackbar.LENGTH_LONG).show();
            return;
        } if (password.isEmpty() || email.isEmpty() ){

            textInputSenha.setError("Campos não podem ser vazios");
            textInputSenha.setErrorEnabled(false);
            Snackbar.make(textInputSenha, "Campos não podem ser vazios", Snackbar.LENGTH_LONG).show();
            return;
        }


        // tentamos fazer o login com o email e senha no firebase
        FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        irParaHome(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    } else {
                        Snackbar.make(buttonEntrar, task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
                    }
                });
    }


    public void loginFacebook() {
        // TODO: Login facebook
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {


                AuthCredential credential = FacebookAuthProvider
                        .getCredential(loginResult.getAccessToken().getToken());

                FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener(task -> {
                            irParaHome(loginResult.getAccessToken().getUserId());
                        });
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Verifica se o valor do resultCode é igual a constante RESULT_OK
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                //Caso o codigo seja 101 ele recupera a conta logada e passa para o método concluirLogin
                //Caso contrario pega a exceção
                case 101:
                    try {

                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                        GoogleSignInAccount conta = task.getResult(ApiException.class);
                        concluirLogin(conta);

                    } catch (ApiException e) {

                        Log.i("LOG", "Error: " + e.getMessage());

                        Toast.makeText(getApplicationContext(), "Erro", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }


    //Método que conclui o Login e envia o objeto com os dados do usuario logado para a tela MainActivity
    private void concluirLogin(GoogleSignInAccount googleSignInAccount) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(GOOGLE_ACCOUNT, googleSignInAccount);
        startActivity(intent);
        finish();
    }

    //A sobrescrita do onStart verifica se ja possuim um usuario logado se ja possuir um usuario logado ele já vai para a tela MainActivity
    //Senão ele mostra um toast dizendo que precisa de uma conta a ser logada
    @Override
    public void onStart() {
        super.onStart();

        GoogleSignInAccount alreadyloggedAccount = GoogleSignIn.getLastSignedInAccount(this);

        if (alreadyloggedAccount != null) {

            Toast.makeText(this, "Você já está logado", Toast.LENGTH_SHORT).show();
            concluirLogin(alreadyloggedAccount);

        } else {
            Toast.makeText(this, "Entre em alguma conta", Toast.LENGTH_LONG).show();
        }
    }

    private void irParaHome(String uiid) {
        AppUtil.salvarIdUsuario(getApplication().getApplicationContext(), uiid);
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        finish();
    }


}
