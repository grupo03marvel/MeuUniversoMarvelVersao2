package com.example.meuuniversomarvel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.view.fragments.recycler.AutoresFragment;
import com.example.meuuniversomarvel.view.fragments.recycler.ComicsFavoritosFragment;
import com.example.meuuniversomarvel.view.fragments.recycler.EventosFragment;
import com.example.meuuniversomarvel.view.fragments.recycler.HqsFragment;
import com.example.meuuniversomarvel.view.fragments.recycler.PersonagemFavoritosFragment;
import com.example.meuuniversomarvel.view.fragments.recycler.PersonagensFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class FavoritosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        BottomNavigationView navView = findViewById(R.id.nav_viewFavoritos);

        replaceFragment(new ComicsFavoritosFragment());


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.HQs_Favoritos, R.id.personagens_Favoritos, R.id.VoltarMenu)
                .build();

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if (id == R.id.HQs_Favoritos) {

                    FavoritosActivity.this.replaceFragment(new ComicsFavoritosFragment());

                } else if (id == R.id.personagens_Favoritos) {

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

