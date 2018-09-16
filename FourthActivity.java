package com.robboapps.ottawa4kidstest;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class FourthActivity extends ListActivity {

    String[] details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lstView = getListView();
        lstView.setTextFilterEnabled(true);
        details = getResources().getStringArray(R.array.details_array);

        //Toast.makeText(this, getIntent().getStringExtra("str1"), Toast.LENGTH_SHORT).show();

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, details));

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                String itemValue = (String) lstView.getItemAtPosition(position);

                switch (itemValue) {
                    case "WebSite":
                        Intent i = new Intent("com.robboapps.ottawa4kidstest.WebSiteActivity");
                        //---use putExtra() to send the ThirdActivity choice to the WebSite Activity---
                        i.putExtra("str1", getIntent().getStringExtra("str1"));
                        startActivity(i);
                        break;
                    case "Where is It":
                        Intent a = new Intent("com.robboapps.ottawa4kidstest.WhereActivity");
                        //---use putExtra() to send the ThirdActivity choice to the Where Activity---
                        a.putExtra("str1", getIntent().getStringExtra("str1"));
                        startActivity(a);
                        break;
                    case "Side Trips for Adults":
                        Intent b = new Intent("com.robboapps.ottawa4kidstest.SideTripsActivity");
                        //---use putExtra() to send the ThirdActivity choice to the SideTrips Activity---
                        b.putExtra("str1", getIntent().getStringExtra("str1"));
                        startActivity(b);
                        break;
                    case "Whats Cool":
                        Intent c = new Intent("com.robboapps.ottawa4kidstest.WhatsCoolActivity");
                        //---use putExtra() to send the ThirdActivity choice to the WhatsCool Activity---
                        c.putExtra("str1", getIntent().getStringExtra("str1"));
                        startActivity(c);
                        break;
                }
            }

        });

    }
}
