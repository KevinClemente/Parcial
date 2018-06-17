package com.example.elsalvador.parcial.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elsalvador.parcial.Adapters.RecyclerViewAdapterNews;
import com.example.elsalvador.parcial.Object.News;
import com.example.elsalvador.parcial.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.elsalvador.parcial.Fragment.NewsFragment.listOfNewsToSend;


/**
 * A simple {@link Fragment} subclass.
 */
public class GeneralsFragment extends Fragment {

    private View view;
    private List<News> listofNewsRecieved;
    private RecyclerView generalsRecyclerView;
    private String actualGame;

    private String title;
    private String body;
    private String game;
    private String coverImage;
    private String description;
    private String created_date;


    public GeneralsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragments_generals_fragment, container, false);
        loadGenerals(view);
        return view;
    }

    public void loadGenerals(View view){

        listofNewsRecieved = new ArrayList<>();

        for(int i=0;i<listOfNewsToSend.size();i++){
            if (listOfNewsToSend.get(i).getGame().equals(actualGame)) {
                listofNewsRecieved.add(listOfNewsToSend.get(i));
            }
            }


        generalsRecyclerView = (RecyclerView) view.findViewById(R.id.generals_recyclerview);
        RecyclerViewAdapterNews recyclerViewAdapter = new RecyclerViewAdapterNews(getContext(), listofNewsRecieved);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
            @Override
            public int getSpanSize(int position) {

                if ( position%3 == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });

        generalsRecyclerView.setLayoutManager(gridLayoutManager);
        generalsRecyclerView.setAdapter(recyclerViewAdapter);

    }


    public String newInstance(String indicateActualGame){
        actualGame = indicateActualGame;
        return actualGame;
    }

}
