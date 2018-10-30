package com.robboapps.ottawa4kidstest;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;

public class WhatsCoolActivity extends FragmentActivity {
    ViewPager viewPager;
    CoolSwipeAdaptor swipeAdaptor;
    static final int ITEMS = 2;
    //static Context context;
    //context = this.getbaseContext;
    //Context context = this;
    //Context context = this;
    //Context context = Fragment.getContext();
    //Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_cool);
        viewPager = findViewById(R.id.view_pager);
        System.out.println("XANADU First");
        //CoolSwipeAdaptor swipeAdaptor = new CoolSwipeAdaptor(getSupportFragmentManager(), context);
        swipeAdaptor = new CoolSwipeAdaptor(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdaptor);
        //viewPager.setCurrentItem(0);

        //Toast.makeText(this, getIntent().getStringExtra("str1"), Toast.LENGTH_SHORT).show();
    }
// from: https://developer.android.com/training/animation/screen-slide#java
    //@Override
    //public void onBackPressed() {
    //if (viewPager.getCurrentItem() == 0) {
    //System.out.println("XANADU Second");
    // If the user is currently looking at the first step, allow the system to handle the
    // Back button. This calls finish() on this activity and pops the back stack.
    //super.onBackPressed();
    //} else {
    // Otherwise, select the previous step.
    //System.out.println("XANADU Third");
    //viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    //}
    //}

    public static class CoolSwipeAdaptor extends FragmentStatePagerAdapter {
        //private Context context2;

        //int numImages;
        //String[] imgList;

        //testgit23
        // get Context from WhatsCoolActivity when it creates a new CoolSwipeAdaptor Class, and assign to
        // context2 as it is required in order to use Asset Manager methods
        //public CoolSwipeAdaptor(FragmentManager fm, Context context) {
        public CoolSwipeAdaptor(FragmentManager fm) {
            super(fm);
            //context2 = context;
        }

        @Override
        public int getCount() {
/*
        try {

                AssetManager assetManager = context2.getApplicationContext().getAssets();
                imgList = assetManager.list("trainmuseum");
                System.out.println("XANADU 02" + Arrays.toString(imgList));
                //numImages = imgList.length;

            }catch (IOException e) {
                e.printStackTrace();
            }
*/
            //return imgList.length;
            System.out.println("XANADU 01");
            return ITEMS;

        }

        @Override
        public Fragment getItem(int pos) {
            System.out.println("XANADU 02  POS IS " + pos);
            //if(pos < imgList.length);
            //return CoolPageFragment.newInstance(pos);

            //else
            //return null;
            switch (pos) {
                case 0:
                    return CoolPageFragment.newInstance(0);
                case 1:
                    return CoolPageFragment.newInstance(1);
                    default:
                        return null;
            }

        }
}
}
