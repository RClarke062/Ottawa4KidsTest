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

    public CoolSwipeAdaptor(FragmentManager fm, Context context) {
        super(fm);
        context2 = context;

    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new CoolPageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("count", i + 1);
        fragment.setArguments(bundle);
        return fragment;
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
