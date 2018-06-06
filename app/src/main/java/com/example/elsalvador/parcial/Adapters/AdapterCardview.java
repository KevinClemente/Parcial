package com.example.elsalvador.parcial.Adapters;

import android.support.v7.widget.RecyclerView;


import android.content.Context;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import com.example.elsalvador.parcial.Object.News;
import com.example.elsalvador.parcial.R;

import java.util.List;

public class AdapterCardview extends RecyclerView.Adapter<AdapterCardview.MyViewHolder>{

        Context context;
        List<News> NewsListData;

        public AdapterCardview(Context context, List<News> NewsListData) {
            this.context = context;
            this.NewsListData = NewsListData;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v;
            v = LayoutInflater.from(context).inflate(R.layout.cardview_news,parent,false);
            MyViewHolder viewHolder = new MyViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.newsTitle.setText(NewsListData.get(position).getTitleOfNews());
            holder.newsSubtitle.setText(NewsListData.get(position).getSubtitleOfNews());

            final ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            if (position == 0 || position%3==0) {
                StaggeredGridLayoutManager.LayoutParams sglp = (StaggeredGridLayoutManager.LayoutParams) lp;
                sglp.setFullSpan(true);
                holder.itemView.setLayoutParams(sglp);
            }

        }

        @Override
        public int getItemCount() {
            return NewsListData.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{

            private TextView newsTitle;
            private TextView newsSubtitle;

            public MyViewHolder(View itemView) {
                super(itemView);

                newsTitle = (TextView) itemView.findViewById(R.id.news_title);
                newsSubtitle = (TextView) itemView.findViewById(R.id.news_subtitle);

            }
        }

    }

