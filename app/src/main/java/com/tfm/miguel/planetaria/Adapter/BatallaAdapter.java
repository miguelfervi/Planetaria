package com.tfm.miguel.planetaria.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tfm.miguel.planetaria.Fragments.BescaramuzaFragment;
import com.tfm.miguel.planetaria.Fragments.ConquistaFragment;
import com.tfm.miguel.planetaria.Fragments.IndividualFragment;

/**
 * Created by miguelfernandezvillegas on 31/5/17.
 */

public class BatallaAdapter extends FragmentStatePagerAdapter {


    private int numberOfTabs;

    public BatallaAdapter(FragmentManager fm, int numberOfTabs ){
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new IndividualFragment();
            case 1:
                return new BescaramuzaFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
