package com.tfm.miguel.planetaria.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tfm.miguel.planetaria.Fragments.AlertFragment;
import com.tfm.miguel.planetaria.Fragments.BatallaFragment;
import com.tfm.miguel.planetaria.Fragments.ConquistaFragment;
import com.tfm.miguel.planetaria.Fragments.LogrosFragment;
import com.tfm.miguel.planetaria.Fragments.NaveFragment;
import com.tfm.miguel.planetaria.Fragments.RangoFragment;

/**
 * Created by miguelfernandezvillegas on 31/5/17.
 */

public class ExploradorAdapter extends FragmentStatePagerAdapter {


    private int numberOfTabs;

    public ExploradorAdapter(FragmentManager fm, int numberOfTabs ){
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new NaveFragment();
            case 1:
                return new LogrosFragment();
            case 2:
                return new RangoFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
