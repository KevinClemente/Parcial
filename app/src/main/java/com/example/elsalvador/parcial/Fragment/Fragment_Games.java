package com.example.elsalvador.parcial.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elsalvador.parcial.R;
import com.example.elsalvador.parcial.Adapters.adaptadorViewPager;

public class Fragment_Games extends Fragment {
    private TabLayout TabLayoutMenu;
    private ViewPager AllColumns;
    private  adaptadorViewPager ColumnElements;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragments_games, container, false);

        TabLayoutMenu = (TabLayout) view.findViewById(R.id.tablayout_menu);
        AllColumns = (ViewPager) view.findViewById(R.id.viewpager);
        ColumnElements = new adaptadorViewPager(getChildFragmentManager());

        ColumnElements.AddFragment(new Generals(), "GENERALS");
        ColumnElements.AddFragment(new TopPlayersFragment(), "TOP PLAYERS");
        ColumnElements.AddFragment(new Images(), "IMAGES");
        TabLayoutMenu.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"));


        AllColumns.setAdapter(ColumnElements);
        TabLayoutMenu.setupWithViewPager(AllColumns);

        ActionBar ActionBarMenu = ((AppCompatActivity)getActivity()).getSupportActionBar();
        ActionBarMenu.setElevation(0);

        return view;
    }
}