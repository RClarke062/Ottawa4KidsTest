package com.robboapps.ottawa4kidstest;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;

public class WhatsCoolActivity extends FragmentActivity {
    ViewPager viewPager;
    //static Context context;
    //context = this.getbaseContext;
    Context context = this;
    //Context context = Fragment.getContext();
    //Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_cool);
        viewPager = findViewById(R.id.view_pager);
        CoolSwipeAdaptor swipeAdaptor = new CoolSwipeAdaptor(getSupportFragmentManager(), context);

        viewPager.setAdapter(swipeAdaptor);

        //Toast.makeText(this, getIntent().getStringExtra("str1"), Toast.LENGTH_SHORT).show();
    }
}
