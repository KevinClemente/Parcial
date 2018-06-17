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
import com.example.elsalvador.parcial.Interface.Conexion;
import com.example.elsalvador.parcial.Object.News;
import com.example.elsalvador.parcial.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.elsalvador.parcial.Activities.Login.globalToken;

public class NewsFragment extends Fragment {

    private View view;
    private Conexion conexion;
    private String baseUrl;
    private Retrofit retrofit;
    private Call<List<News>> call;
    private List<News> auxiliarList = null;
    public static List<News> listOfNewsToSend;
    private RecyclerView newsRecyclerViews;

    private String title;
    private String body;
    private String game;
    private String coverImage;
    private String description;
    private String created_date;


    public NewsFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_fragment,container,false);

        loadNews(view);

        return view;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void loadNews(final View v){

        baseUrl = "http://gamenewsuca.herokuapp.com/";

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        conexion = retrofit.create(Conexion.class);

        call = conexion.getNewsRequest("Bearer "+globalToken,"desc");

        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                auxiliarList = response.body();
                listOfNewsToSend = new ArrayList<>();

                for(int i=0;i<auxiliarList.size();i++){

                    if(auxiliarList.get(i).getTitle() == null){ title = "Noticia sin titulo";}
                    else{ title = auxiliarList.get(i).getTitle(); }

                    if(auxiliarList.get(i).getBody() == null){ body = "Noticia sin cuerpo";}
                    else{ body = auxiliarList.get(i).getBody(); }

                    if(auxiliarList.get(i).getGame() == null){ game = "Noticia sin juego";}
                    else{ game = auxiliarList.get(i).getGame(); }

                    if(auxiliarList.get(i).getCoverImage() == null){ coverImage = "Noticia sin imagen";}
                    else{ coverImage = auxiliarList.get(i).getCoverImage(); }

                    if(auxiliarList.get(i).getDescription() == null){ description = "Noticia sin descripcion";}
                    else{ description = auxiliarList.get(i).getDescription(); }

                    if(auxiliarList.get(i).getCreated_date() == null){ created_date = "Noticia sin fecha de creacion";}
                    else{ created_date = auxiliarList.get(i).getCreated_date(); }

                    listOfNewsToSend.add(new News(auxiliarList.get(i).get_id()
                            ,title
                            ,body
                            ,game
                            ,coverImage
                            ,description
                            ,created_date
                            ,auxiliarList.get(i).get__v()));
                }


                newsRecyclerViews = (RecyclerView) v.findViewById(R.id.news_recyclerview);
                RecyclerViewAdapterNews recyclerViewAdapter = new RecyclerViewAdapterNews(getContext(), listOfNewsToSend);


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

                newsRecyclerViews.setLayoutManager(gridLayoutManager);
                newsRecyclerViews.setAdapter(recyclerViewAdapter);

            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
            }

        });
    }



}
