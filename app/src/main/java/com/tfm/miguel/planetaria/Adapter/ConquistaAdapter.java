package com.tfm.miguel.planetaria.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tfm.miguel.planetaria.Fragments.Space1Fragment;
import com.tfm.miguel.planetaria.Fragments.Space2Fragment;

/**
 * Created by miguelfernandezvillegas on 31/5/17.
 */

public class ConquistaAdapter extends FragmentStatePagerAdapter {


    private int numberOfTabs;

    public ConquistaAdapter(FragmentManager fm, int numberOfTabs ){
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new Space1Fragment();
            case 1:
                return new Space2Fragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
