package com.tfm.miguel.planetaria.Activities;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.tfm.miguel.planetaria.Fragments.BatallaFragment;
import com.tfm.miguel.planetaria.Fragments.ConquistaFragment;
import com.tfm.miguel.planetaria.Fragments.EscuadraFragment;
import com.tfm.miguel.planetaria.Fragments.ExploradorFragment;
import com.tfm.miguel.planetaria.Fragments.SistemaExploracionFragment;
import com.tfm.miguel.planetaria.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navview);

        setFragmentByDefault();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.menu_batalla:
                        fragment = new BatallaFragment();
                        fragmentTransaction = true;

                        break;

                    case R.id.menu_sistema_de_exploracion:
                        fragment = new SistemaExploracionFragment();
                        fragmentTransaction = true;


                        break;

                    case R.id.menu_escuadra:
                        fragment = new EscuadraFragment();
                        fragmentTransaction = true;


                        break;

                    case R.id.menu_explorador:
                        fragment = new ExploradorFragment();
                        fragmentTransaction = true;


                        break;

                    case R.id.menu_conquista:
                        fragment = new ConquistaFragment();
                        fragmentTransaction = true;


                        break;


                    case R.id.menu_alertas:
                        fragment = new BatallaFragment();
                        fragmentTransaction = true;

                        break;


                }

                if(fragmentTransaction){
                    changeFragment(fragment,item);
                    drawerLayout.closeDrawers();
                }



                return true;
            }
        });
    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault(){
        changeFragment(new ConquistaFragment(), navigationView.getMenu().getItem(4));
    }

    private void changeFragment(Fragment fragment, MenuItem item){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame,fragment)
                    .commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
            drawerLayout.closeDrawers();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                //abrir el menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
