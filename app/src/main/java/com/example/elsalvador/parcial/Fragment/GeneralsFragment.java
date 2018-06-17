package com.example.elsalvador.parcial.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elsalvador.parcial.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GeneralsFragment extends Fragment {


    public GeneralsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragments_generals_fragment, container, false);
    }

}
