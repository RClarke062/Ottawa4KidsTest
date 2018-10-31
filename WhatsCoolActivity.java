package com.robboapps.ottawa4kidstest;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
//import android.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WhatsCoolActivity extends AppCompatActivity {
    ViewPager viewPager;
    CoolSwipeAdaptor swipeAdaptor;
    static final int ITEMS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_cool);
        viewPager = findViewById(R.id.view_pager);
        System.out.println("XANADU First");
        swipeAdaptor = new CoolSwipeAdaptor(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdaptor);

    }

    public static class CoolSwipeAdaptor extends FragmentStatePagerAdapter {

        public CoolSwipeAdaptor(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {

            System.out.println("XANADU 01");
            return ITEMS;

        }

        @Override
        public Fragment getItem(int pos) {
            System.out.println("XANADU 02  POS IS " + pos);

            switch (pos) {
                case 0:
                    return CoolPageFragment.newInstance(pos);
                case 1:
                    return CoolPageFragment.newInstance(pos);
                    default:
                        return null;
            }

        }
}
}
