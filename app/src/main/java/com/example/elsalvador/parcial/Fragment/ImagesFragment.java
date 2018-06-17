package com.example.elsalvador.parcial.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elsalvador.parcial.Adapters.RecyclerViewAdapterImages;
import com.example.elsalvador.parcial.Object.Images;
import com.example.elsalvador.parcial.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.elsalvador.parcial.Fragment.NewsFragment.listOfNewsToSend;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImagesFragment extends Fragment {

    private View view;
    private List<Images> listOfImagesToSend = null;
    private RecyclerView imagesRecyclerView;
    private String actualGame;
    private String imageUrl;


    public ImagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragments_images_fragment,container,false);
        loadImages(view);
        return view;
    }


    public void loadImages(View view){

        listOfImagesToSend = new ArrayList<>();

        for(int i = 0; i< listOfNewsToSend.size(); i++) {

            if (listOfNewsToSend.get(i).getGame().equals(actualGame)) {
                if (listOfNewsToSend.get(i).getCoverImage().equals("Noticia sin imagen")) {
                    imageUrl = "Noticia sin imagen";
                } else {
                    imageUrl = listOfNewsToSend.get(i).getCoverImage();
                }
                listOfImagesToSend.add(new Images(imageUrl));
            }
        }

        imagesRecyclerView = (RecyclerView) view.findViewById(R.id.images_recycler_view);
        RecyclerViewAdapterImages recyclerViewAdapterImages = new RecyclerViewAdapterImages(getContext(),listOfImagesToSend);
        imagesRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        imagesRecyclerView.setAdapter(recyclerViewAdapterImages);

    }

    public String newInstance(String indicateActualGame){
        actualGame = indicateActualGame;
        return actualGame;
    }

}

