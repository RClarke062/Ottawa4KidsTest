package com.robboapps.ottawa4kidstest;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.io.IOException;
import java.util.Arrays;

public class CoolSwipeAdaptor extends FragmentStatePagerAdapter {
    private Context context2;

    int numImages;
    String[] imgList;
//testgit
    // get Context from WhatsCoolActivity when it creates a new CoolSwipeAdaptor Class, and assign to
    // context2 as it is required in order to use Asset Manager methods
    public CoolSwipeAdaptor(FragmentManager fm, Context context) {
       super(fm);
       context2 = context;

    }

    @Override
    public Fragment getItem(int i) {
        if(i <= imgList.length)
            return CoolPageFragment.newInstance(i);
        else
            return null;
    }

        @Override
        public int getCount() {


            try {

                AssetManager assetManager = context2.getApplicationContext().getAssets();
                imgList = assetManager.list("trainmuseum");
                System.out.println("XANADU52" + Arrays.toString(imgList));
                numImages = imgList.length;

            }catch (IOException e) {
                e.printStackTrace();
            }

            return imgList.length;

        }
    }
