package com.tfm.miguel.planetaria.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tfm.miguel.planetaria.Adapter.ConquistaAdapter;
import com.tfm.miguel.planetaria.R;


public class ExploradorFragment extends Fragment {

    public ExploradorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_explorador, container, false);

        // Inflate the layout for this fragment
        return view;
    }
}
