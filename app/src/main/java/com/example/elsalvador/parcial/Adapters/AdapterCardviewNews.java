package com.example.elsalvador.parcial.Adapters;

import android.support.v7.widget.RecyclerView;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elsalvador.parcial.Object.News;
import com.example.elsalvador.parcial.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterCardviewNews extends RecyclerView.Adapter<AdapterCardviewNews.MyViewHolder>{

    Context context;
    List<News> NewsListData;

    public AdapterCardviewNews(Context context, List<News> NewsListData) {
        this.context = context;
        this.NewsListData = NewsListData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.newsTitle.setText(NewsListData.get(position).getTitle());
        holder.newsSubtitle.setText(NewsListData.get(position).getGame());

        if(NewsListData.get(position).getCoverImage() != "Noticia sin imagen"){
            Picasso.with(context).load(NewsListData.get(position).getCoverImage()).into(holder.imageView);
        }


    }

    @Override
    public int getItemCount() {
        return NewsListData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView newsTitle;
        private TextView newsSubtitle;
        private ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            newsTitle = (TextView) itemView.findViewById(R.id.news_title);
            newsSubtitle = (TextView) itemView.findViewById(R.id.news_subtitle);
            imageView = (ImageView) itemView.findViewById(R.id.newsimage);
        }
    }

}

