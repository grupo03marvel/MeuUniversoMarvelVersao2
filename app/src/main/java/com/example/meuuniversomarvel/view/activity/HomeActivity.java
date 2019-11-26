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

import com.example.meuuniversomarvel.view.fragments.recycler.AutoresFragment;
import com.example.meuuniversomarvel.view.fragments.recycler.EventosFragment;
import com.example.meuuniversomarvel.view.fragments.recycler.HqsFragment;
import com.example.meuuniversomarvel.view.fragments.recycler.PersonagensFragment;
import com.example.meuuniversomarvel.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;

    public static final String MH_KEY = "modeloHome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        replaceFragment(new HqsFragment());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//oiiiiiii
        BottomNavigationView menuBarra = findViewById(R.id.menu_barra);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_quadrinhos, R.id.nav_sobre, R.id.nav_personagens,
                R.id.nav_favoritos, R.id.nav_series, R.id.nav_autores)
                .setDrawerLayout(drawer)
                .build();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();


                if (id == R.id.nav_quadrinhos) {
                    replaceFragment(new HqsFragment());
                }

                if (id == R.id.nav_personagens) {
                    replaceFragment(new PersonagensFragment());

                }

                if (id == R.id.nav_autores) {
                    replaceFragment(new AutoresFragment());

                }

                if (id == R.id.nav_series) {
                    replaceFragment(new EventosFragment());

                }


                if (id == R.id.nav_favoritos) {

                }


                if (id == R.id.nav_sobre) {
                    Intent intent = new Intent(HomeActivity.this, SobreActivity.class);
                    startActivity(intent);
                }

                if (id == R.id.nav_logout) {
                    Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                }


                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_hqs_barra, R.id.nav_personagens_barra, R.id.nav_autores_barra,
                R.id.nav_eventos_barra)
                        .build();

        menuBarra.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if (id == R.id.nav_hqs_barra) {

                    HomeActivity.this.replaceFragment(new HqsFragment());

                } else if (id == R.id.nav_personagens_barra) {

                    HomeActivity.this.replaceFragment(new PersonagensFragment());

                } else if (id == R.id.nav_autores_barra) {

                    HomeActivity.this.replaceFragment(new AutoresFragment());

                } else if (id == R.id.nav_eventos_barra) {

                    HomeActivity.this.replaceFragment(new EventosFragment());

                }

                return true;
            }
        });


    }





    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{super.onBackPressed();}
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
