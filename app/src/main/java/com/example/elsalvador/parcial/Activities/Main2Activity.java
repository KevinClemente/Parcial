package com.example.elsalvador.parcial.Activities;

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
import com.example.elsalvador.parcial.Fragment.Top;
import com.example.elsalvador.parcial.Fragment.News;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.News) {
            replaceFragment(new News());
        }  else if (id == R.id.LOL) {
            replaceFragment(new Top());
        } else if (id == R.id.Dota) {
            replaceFragment(new Generals());
        } else if (id == R.id.CSGO) {
            replaceFragment(new Fragment_Games());
        } else if (id == R.id.Set) {
            replaceFragment(new Set());
        }else if (id == R.id.Fav) {
            replaceFragment(new Images());
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
