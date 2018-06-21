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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThirdActivity extends ListActivity {

    String[] outsidestuffchoice;
    String[] Options = new String[7];
    String[] Row = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lstView = getListView();
        lstView.setTextFilterEnabled(true);
        outsidestuffchoice = getResources().getStringArray(R.array.outsidestuff_array);
        for (int i = 0; i < outsidestuffchoice.length; i++) {
            Options = outsidestuffchoice[i].split(",");
            //Row[i] = Options[0];
            if (Options[1].equals(getIntent().getStringExtra("str1"))) {
                Row[i] = Options[2];
            }
        }

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Row));


        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent,View v, int position, long id){
                String  itemValue    = (String) lstView.getItemAtPosition(position);
                Intent i = new Intent("com.robboapps.ottawa4kidstest.FourthActivity");
                //---use putExtra() to add new nam/value pairs---
                i.putExtra("str1", itemValue);
                startActivity(i);
            }
        });
    }

    public void onListItemClick(ListView parent, View v, int position, long id){
        Toast.makeText(this, "You have selected " + outsidestuffchoice[position], Toast.LENGTH_SHORT).show();
    }

}
