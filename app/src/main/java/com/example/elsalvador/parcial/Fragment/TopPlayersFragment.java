package com.example.elsalvador.parcial.Fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elsalvador.parcial.Adapters.RecyclerViewAdapterTopPlayers;
import com.example.elsalvador.parcial.Interface.RequestHelper;
import com.example.elsalvador.parcial.Object.TopPlayers;
import com.example.elsalvador.parcial.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.elsalvador.parcial.Activities.Login.globalToken;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopPlayersFragment extends Fragment {

    private View view;
    private RequestHelper requestHelper;
    private String baseUrl;
    private Retrofit retrofit;
    private Call<List<TopPlayers>> call;
    private String actualGame;
    private Bundle fromFragment;
    private List<TopPlayers> auxiliarList = null;
    private List<TopPlayers> listOfTopPlayersToSend;
    private RecyclerView topPlayersRecyclerViews;

    private String avatar;
    private String name;
    private String biografia;
    private String game;
    private String __v;

    public TopPlayersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_top_players,container,false);
        loadTopPlayers(view);
        return view;
    }

    public void loadTopPlayers(final View v){

        baseUrl = "http://gamenewsuca.herokuapp.com/";

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        requestHelper = retrofit.create(RequestHelper.class);

        call = requestHelper.getTopPlayersRequest("Bearer "+globalToken);

        call.enqueue(new Callback<List<TopPlayers>>() {
            @Override
            public void onResponse(Call<List<TopPlayers>> call, Response<List<TopPlayers>> response) {
                auxiliarList = response.body();
                listOfTopPlayersToSend = new ArrayList<>();

                for(int i=0;i<auxiliarList.size();i++){

                    if(auxiliarList.get(i).getAvatar() == null){ avatar = "Sin Avatar";}
                    else{ avatar = auxiliarList.get(i).getAvatar(); }

                    if(auxiliarList.get(i).getName() == null){ name = "Sin nombre";}
                    else{ name = auxiliarList.get(i).getName(); }

                    if(auxiliarList.get(i).getBiografia() == null){ biografia = "Sin biografia";}
                    else{ biografia = auxiliarList.get(i).getBiografia(); }

                    if(auxiliarList.get(i).getGame() == null){ game = "Sin juego";}
                    else{ game = auxiliarList.get(i).getGame(); }

                    listOfTopPlayersToSend.add(new TopPlayers(avatar
                            ,auxiliarList.get(i).get_id()
                            ,name
                            ,biografia
                            ,game
                            ,auxiliarList.get(i).get__v()));
                }

                topPlayersRecyclerViews = (RecyclerView) v.findViewById(R.id.top_players_recyclerview);
                RecyclerViewAdapterTopPlayers recyclerViewAdapter = new RecyclerViewAdapterTopPlayers(getContext(), listOfTopPlayersToSend);
                topPlayersRecyclerViews.setLayoutManager(new LinearLayoutManager(getActivity()));
                topPlayersRecyclerViews.setAdapter(recyclerViewAdapter);

            }

            @Override
            public void onFailure(Call<List<TopPlayers>> call, Throwable t) {
            }
        });
    }

}
