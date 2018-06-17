package com.example.elsalvador.parcial.Activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import com.example.elsalvador.parcial.Fragment.GameInfoFragment;
import com.example.elsalvador.parcial.Fragment.NewsFragment;
import com.example.elsalvador.parcial.R;

import java.lang.reflect.GenericArrayType;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment actualFragment;
    private String actualGame = null;
    private GameInfoFragment gameInfoFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.News);
        changeFragment(new NewsFragment());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.News:
                changeFragment(new NewsFragment());
                break;

            case R.id.LOL:
                actualGame = "lol";
                gameInfoFragment = new GameInfoFragment();
                gameInfoFragment.indicateActualGame(actualGame);
                changeFragment(gameInfoFragment);
                break;

            case R.id.Dota:
                actualGame = "overwatch";
                gameInfoFragment = new GameInfoFragment();
                gameInfoFragment.indicateActualGame(actualGame);
                changeFragment(gameInfoFragment);
                break;

            case R.id.CSGO:
                actualGame = "csgo";
                gameInfoFragment = new GameInfoFragment();
                gameInfoFragment.indicateActualGame(actualGame);
                changeFragment(gameInfoFragment);
                break;

            //case R.id.nav_settings:
              //  changeFragment(new GameInfoFragment());
                //break;

            //case R.id.nav_favorites:
              //  changeFragment(new GameInfoFragment());
                //break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    private void changeFragment(Fragment fragment) {
        if (actualFragment == null || !fragment.getClass().getName().equals(actualFragment.getClass().getName())) {
            getSupportFragmentManager().beginTransaction().replace(R.id.replacefragment, fragment).commit();
            actualFragment = fragment;
        }else if(fragment.getClass().getName().equals(actualFragment.getClass().getName())){
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.replacefragment,fragment).commit();
            actualFragment = fragment;
        }

    }

}









