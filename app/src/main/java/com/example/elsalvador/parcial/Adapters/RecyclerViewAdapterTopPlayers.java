package com.example.elsalvador.parcial.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elsalvador.parcial.Object.TopPlayers;
import com.example.elsalvador.parcial.R;

import java.util.List;

public class RecyclerViewAdapterTopPlayers extends RecyclerView.Adapter<RecyclerViewAdapterTopPlayers.MyViewHolder>{

    private Context context;
    private List<TopPlayers> TopPlayersDataList;

    public RecyclerViewAdapterTopPlayers(Context context, List<TopPlayers> topPlayersDataList) {
        this.context = context;
        TopPlayersDataList = topPlayersDataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.top_player_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.TopPlayerName.setText(TopPlayersDataList.get(position).getName());
        holder.TopPlayerGame.setText(TopPlayersDataList.get(position).getGame());

    }

    @Override
    public int getItemCount() {
        return TopPlayersDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView TopPlayerName;
        private TextView TopPlayerGame;

        public MyViewHolder(View itemView) {
            super(itemView);

            TopPlayerName = (TextView) itemView.findViewById(R.id.top_players_name);
            TopPlayerGame = (TextView) itemView.findViewById(R.id.top_players_game);

        }
    }

}
