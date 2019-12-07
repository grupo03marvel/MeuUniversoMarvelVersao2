package com.example.meuuniversomarvel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.view.fragments.recycler.ComicsFavoritosFragment;
import com.example.meuuniversomarvel.view.fragments.recycler.PersonagemFavoritosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FavoritosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        BottomNavigationView navView = findViewById(R.id.nav_viewFavoritos);

        replaceFragment(new PersonagemFavoritosFragment());


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                 R.id.personagens_Favoritos, R.id.VoltarMenu)
                .build();

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if (id == R.id.personagens_Favoritos) {

                    FavoritosActivity.this.replaceFragment(new PersonagemFavoritosFragment());

                } else if (id == R.id.VoltarMenu) {

                    FavoritosActivity.this.startActivity(new Intent(FavoritosActivity.this, HomeActivity.class));

                }

                return true;
            }
        });


    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerFavoritos, fragment);
        transaction.commit();
    }

}

