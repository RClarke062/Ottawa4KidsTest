package com.robboapps.ottawa4kidstest;


import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class CoolPageFragment extends Fragment {

    ImageView imageView;
    //AssetManager assetManager = getContext().getAssets();
    Bitmap bitmap;
    Integer numImages;
    MainActivity getMainActivity = new MainActivity();

    public CoolPageFragment() {
        //Required empty public constructor
        Context context;
        context = getMainActivity.grabContext();
    }
// how to call an intent from a non activity class??????
    //Intent intent = new Intent(context, FourthActivity.class)
            //.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    //context.startActivity(intent);
    //String path = getIntent().getStringExtra("str1");



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cool_page, container, false);
        imageView = view.findViewById(R.id.imageView);
        try{
            AssetManager assetManager = getContext().getAssets();
            String[] imgList = assetManager.list("trainmuseum");
            System.out.println("XANADU 9" + Arrays.toString(imgList));
            numImages = imgList.length;
            System.out.println("XANADU10" + numImages);

            InputStream is = assetManager.open("trainmuseum/sam_ralph - Copy.png");
            bitmap = BitmapFactory.decodeStream(is);
        }catch (IOException e) {
            e.printStackTrace();
        }
        imageView.setImageBitmap(bitmap);
        //imageView.setImageResource(R.drawable.b);
        Bundle bundle = getArguments();
        //String message = Integer.toString(bundle.getInt("count"));
        return view;
    }

}
