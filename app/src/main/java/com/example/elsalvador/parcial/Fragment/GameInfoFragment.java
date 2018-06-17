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

import com.example.elsalvador.parcial.Adapters.ViewPagerAdapter;
import com.example.elsalvador.parcial.R;


public class GameInfoFragment extends Fragment {

    private View view;
    private TabLayout TabLayoutMenu;
    private ViewPager AllColumns;
    private ViewPagerAdapter ColumnElements;
    private String actualGame = null;
    private GeneralsFragment generalsFragment;
    private TopPlayersFragment topPlayersFragment;
    private ImagesFragment imagesFragment;
    private ActionBar ActionBarMenu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.game_info_fragment, container, false);

        TabLayoutMenu = (TabLayout) view.findViewById(R.id.tablayout_menu);
        AllColumns = (ViewPager) view.findViewById(R.id.viewpager);
        ColumnElements = new ViewPagerAdapter(getChildFragmentManager());

        generalsFragment = new GeneralsFragment();
        generalsFragment.newInstance(actualGame);
        ColumnElements.AddFragment(generalsFragment, "GENERALS");

        topPlayersFragment = new TopPlayersFragment();
        topPlayersFragment.newInstance(actualGame);
        ColumnElements.AddFragment(topPlayersFragment, "TOP PLAYERS");

        imagesFragment = new ImagesFragment();
        imagesFragment.newInstance(actualGame);
        ColumnElements.AddFragment(imagesFragment, "IMAGES");

        TabLayoutMenu.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"));


        AllColumns.setAdapter(ColumnElements);
        TabLayoutMenu.setupWithViewPager(AllColumns);

        ActionBarMenu = ((AppCompatActivity)getActivity()).getSupportActionBar();
        ActionBarMenu.setElevation(0);

        return view;
    }

    public String indicateActualGame(String indicateActualGame){
        actualGame = indicateActualGame;
        return actualGame;
    }


}
