package com.example.android.mytourguide;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TourFragmentPageAdapter extends FragmentPagerAdapter {

    private String[] tabsTitle = {"Places", "Foods","Hotels","Events"};

    public TourFragmentPageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PlaceFragment();
            case 1:
                return new FoodFragment();
            case 2:
                return new HotelFragment();
            case 3:
                return new EventFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabsTitle[position];
    }
}
