package com.example.meuuniversomarvel.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.meuuniversomarvel.model.favoritos.Favoritos;
import com.example.meuuniversomarvel.view.fragments.recycler.AutoresFragment;
import com.example.meuuniversomarvel.view.fragments.recycler.EventosFragment;
import com.example.meuuniversomarvel.view.fragments.recycler.HqsFragment;
import com.example.meuuniversomarvel.view.fragments.recycler.PersonagensFragment;
import com.example.meuuniversomarvel.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    private GoogleSignInClient googleSignInClient;


    int menu = R.id.nav_quadrinhos;

    public static final String MH_KEY = "modeloHome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        replaceFragment(new HqsFragment());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView menuBarra = findViewById(R.id.menu_barra);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_quadrinhos, R.id.nav_sobre, R.id.nav_personagens, R.id.nav_favoritos)
                R.id.nav_quadrinhos, R.id.nav_sobre, R.id.nav_personagens, R.id.nav_favoritos, R.id.nav_jogo)
                .setDrawerLayout(drawer)
                .build();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //Ação que traz os dados Default do usuário selecionado na hora do login
                GoogleSignInOptions gso = new GoogleSignInOptions
                        .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .build();

                //Atribuição paraa  o objeto o valor do login recebido
                googleSignInClient = GoogleSignIn.getClient(HomeActivity.this, gso);

                int id = menuItem.getItemId();
                menu = menuItem.getItemId();

                if (id == R.id.nav_quadrinhos) {
                    replaceFragment(new HqsFragment());
                }

                if (id == R.id.nav_personagens) {
                    replaceFragment(new PersonagensFragment());

                }


                if (id == R.id.nav_series) {
                    replaceFragment(new EventosFragment());

                }


                if (id == R.id.nav_favoritos) {
                    startActivity(new Intent(HomeActivity.this, FavoritosActivity.class));

                }

                if (id == R.id.nav_jogo) {
                    startActivity(new Intent(HomeActivity.this, JogoActivity.class));

                }

                if (id == R.id.nav_sobre) {
                    Intent intent = new Intent(HomeActivity.this, SobreActivity.class);
                    startActivity(intent);
                }

                if (id == R.id.nav_logout) {
                    googleSignInClient.signOut().addOnCompleteListener(task -> {
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    });
                }


                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_hqs_barra, R.id.nav_personagens_barra, R.id.nav_favoritos_barra,
                R.id.nav_eventos_barra)
                        .build();

        menuBarra.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                menu = menuItem.getItemId();

                if (id == R.id.nav_hqs_barra) {
                    menu = R.id.nav_quadrinhos;
                    HomeActivity.this.replaceFragment(new HqsFragment());


                } else if (id == R.id.nav_personagens_barra) {
                    menu = R.id.nav_personagens;
                    HomeActivity.this.replaceFragment(new PersonagensFragment());


                } else if (id == R.id.nav_eventos_barra) {

                    menu = R.id.nav_series;
                    HomeActivity.this.replaceFragment(new EventosFragment());

                } else if (id == R.id.nav_favoritos_barra) {
                    startActivity(new Intent(HomeActivity.this, FavoritosActivity.class));
                }

                return true;
            }
        });


    }


    @Override
    public void onBackPressed() {
        if (menu == R.id.nav_quadrinhos) {
            replaceFragment(new HqsFragment());
        }

        if (menu == R.id.nav_personagens) {
            replaceFragment(new PersonagensFragment());

        }



        if (menu == R.id.nav_series) {
            replaceFragment(new EventosFragment());

        }


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerPrincipal, fragment);
        transaction.commit();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



}
