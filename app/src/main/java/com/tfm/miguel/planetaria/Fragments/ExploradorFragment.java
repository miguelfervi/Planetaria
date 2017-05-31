package com.tfm.miguel.planetaria.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tfm.miguel.planetaria.Adapter.ExploradorAdapter;
import com.tfm.miguel.planetaria.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExploradorFragment extends Fragment {


    public ExploradorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_explorador, container, false);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabMenu);
        tabLayout.addTab(tabLayout.newTab().setText("Nave"));
        tabLayout.addTab(tabLayout.newTab().setText("Logros"));
        tabLayout.addTab(tabLayout.newTab().setText("Notificaciones"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        ExploradorAdapter adapter = new ExploradorAdapter(getFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        // Inflate the layout for this fragment
        return view;
    }


}
