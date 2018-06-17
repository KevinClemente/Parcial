package com.example.elsalvador.parcial.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.elsalvador.parcial.Object.Images;
import com.example.elsalvador.parcial.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterImages extends RecyclerView.Adapter<RecyclerViewAdapterImages.MyViewHolder>{

    private Context context;
    private List<Images> imagesDataList;

    public RecyclerViewAdapterImages(Context context, List<Images> imagesDataList) {
        this.context = context;
        this.imagesDataList = imagesDataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.images_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if(imagesDataList.get(position).getImageUrl() != "Noticia sin imagen"){
            Picasso.with(context).load(imagesDataList.get(position).getImageUrl()).into(holder.imagesImage);
        }


    }

    @Override
    public int getItemCount() {
        return imagesDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagesImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            imagesImage = (ImageView) itemView.findViewById(R.id.images_image);

        }
    }

}
