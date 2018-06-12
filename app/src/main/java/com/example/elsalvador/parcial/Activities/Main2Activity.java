package com.example.elsalvador.parcial.Activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.elsalvador.parcial.Fragment.Fragment_Games;
import com.example.elsalvador.parcial.Fragment.Generals;
import com.example.elsalvador.parcial.Fragment.notice;
import com.example.elsalvador.parcial.R;
import com.example.elsalvador.parcial.Fragment.Set;
import com.example.elsalvador.parcial.Fragment.Images;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment changefragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
         navigationView.setNavigationItemSelectedListener(this);

         // navigationView.setCheckedItem(R.id.nav_news);
        //changeFragment(new NewsFragment());
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        switch (id) {
            case R.id.News:
                replaceFragment(new notice());
                break;

            case R.id.LOL:
                replaceFragment(new Fragment_Games());
                break;

            case R.id.Dota:
                replaceFragment(new Fragment_Games());
                break;

            case R.id.CSGO:
                replaceFragment(new Fragment_Games());
                break;

            //case R.id.Set:
            // replaceFragment(new GameInfoFragment());
            //    break;

            //case R.id.Fav:
            //    replaceFragment(new GameInfoFragment());
            //    break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    private void replaceFragment(Fragment fragment) {
        if (changefragment == null || !fragment.getClass().getName().equals(changefragment.getClass().getName())) {
            getSupportFragmentManager().beginTransaction().replace(R.id.replacefragment, fragment).commit();
            changefragment = fragment;
        }

    }

}
