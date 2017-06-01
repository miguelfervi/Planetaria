package com.tfm.miguel.planetaria.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tfm.miguel.planetaria.Fragments.ConquistaFragment;
import com.tfm.miguel.planetaria.Fragments.EventosFragment;
import com.tfm.miguel.planetaria.Fragments.MapFragment;
import com.tfm.miguel.planetaria.Fragments.NFCFragment;

/**
 * Created by miguelfernandezvillegas on 31/5/17.
 */

public class SistemaNavegacionAdapter extends FragmentStatePagerAdapter {


    private int numberOfTabs;

    public SistemaNavegacionAdapter(FragmentManager fm, int numberOfTabs ){
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new NFCFragment();
            case 1:
                return new MapFragment();
            case 2:
                return new EventosFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
