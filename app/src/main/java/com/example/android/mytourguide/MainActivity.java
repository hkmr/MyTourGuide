package com.example.android.mytourguide;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);

        TourFragmentPageAdapter tourFragmentPageAdapter = new TourFragmentPageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(tourFragmentPageAdapter);

        TabLayout tabLayout = findViewById(R.id.sibiling_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.BLUE);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_near_me);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_restaurant);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_hotel);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_event);
    }
}
