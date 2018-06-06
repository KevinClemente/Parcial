package com.example.elsalvador.parcial.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elsalvador.parcial.Adapters.AdapterCardview;
import com.example.elsalvador.parcial.Object.News;
import com.example.elsalvador.parcial.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class notice extends Fragment {

    View v;
    private RecyclerView newsRecyclerViews;
    private List<News> listOfNews;

    public notice() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_news,container,false);
        newsRecyclerViews = (RecyclerView) v.findViewById(R.id. news_recyclerview);
        AdapterCardview recyclerViewAdapter = new AdapterCardview(getContext(), listOfNews);
        newsRecyclerViews.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        newsRecyclerViews.setAdapter(recyclerViewAdapter);
        return v;

}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listOfNews = new ArrayList<>();
        listOfNews.add(new News("imagen","TituloNoticia1","SubNoticia1",false,1));
        listOfNews.add(new News("imagen","TituloNoticia2","SubNoticia2",false,2));
        listOfNews.add(new News("imagen","TituloNoticia3","SubNoticia3",false,3));
        listOfNews.add(new News("imagen","TituloNoticia4","SubNoticia4",false,4));
        listOfNews.add(new News("imagen","TituloNoticia5","SubNoticia5",false,5));
        listOfNews.add(new News("imagen","TituloNoticia6","SubNoticia6",false,6));
        listOfNews.add(new News("imagen","TituloNoticia7","SubNoticia7",false,7));
        listOfNews.add(new News("imagen","TituloNoticia8","SubNoticia8",false,8));
        listOfNews.add(new News("imagen","TituloNoticia9","SubNoticia9",false,9));
        listOfNews.add(new News("imagen","TituloNoticia10","SubNoticia10",false,10));


    }


}
