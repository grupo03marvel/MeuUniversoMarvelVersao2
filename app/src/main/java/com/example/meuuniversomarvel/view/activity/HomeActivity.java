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
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.meuuniversomarvel.view.adapter.ItemAdapter;
import com.example.meuuniversomarvel.viewmodel.ItemHome;
import com.example.meuuniversomarvel.viewmodel.ModeloHome;
import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.data.remote.Comunicador;
import com.example.meuuniversomarvel.view.fragments.CategoriaFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements Comunicador {
    private Comunicador comunicador;
    private FrameLayout container;
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<ItemHome> listaItens = new ArrayList<>();
    private AppBarConfiguration mAppBarConfiguration;


    private DrawerLayout drawer;

    public static final String MH_KEY = "modeloHome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ModeloHome modeloHome = new ModeloHome("Fragment", R.drawable.autores, popularLista());
        setBundleToFragment(modeloHome, MH_KEY);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_quadrinhos, R.id.nav_sobre, R.id.nav_personagens,
                R.id.nav_favoritos, R.id.nav_series, R.id.nav_autores, R.id.nav_eventos)
                .setDrawerLayout(drawer)
                .build();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();


                if (id == R.id.nav_quadrinhos) {
                    //replaceFragment(new fragmento());
                    ModeloHome quadrinhos = new ModeloHome("Quadrinhos", R.drawable.series, popularLista());
                }

                if (id == R.id.nav_personagens) {

                    ModeloHome personagens = new ModeloHome("Personagens", R.drawable.personagem, popularLista());
                }

                if (id == R.id.nav_autores) {
                    ModeloHome autores = new ModeloHome("Autores", R.drawable.autores, popularLista());
                }

                if (id == R.id.nav_series) {
                    ModeloHome series = new ModeloHome("Quadrinhos", R.drawable.series, popularLista());
                }

                if (id == R.id.nav_favoritos) {
                    ModeloHome favoritos = new ModeloHome("Quadrinhos", R.drawable.series, popularLista());
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
        //replaceFragment(R.id.container, new CategoriaFragment());
    }


    public List<ItemHome> popularLista() {
        listaItens.add(new ItemHome(R.drawable.hq3, "Shrek"));
        listaItens.add(new ItemHome(R.drawable.hq3, "Nois"));
        listaItens.add(new ItemHome(R.drawable.hq3, "lalala"));

        return listaItens;
    }

    @Override
    public void receberMensagem(ModeloHome modeloHome) {
        setBundleToFragment(modeloHome, MH_KEY);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{super.onBackPressed();}
    }

    private void replaceFragment(int container, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    private void setBundleToFragment(ModeloHome modeloHome, String CHAVE) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE, modeloHome);
        Fragment outraCategoria = new CategoriaFragment();
        outraCategoria.setArguments(bundle);
        replaceFragment(R.id.container, outraCategoria);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
