package com.robboapps.ottawa4kidstest;


import android.app.ListActivity;
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
    private int mPosition;
//empty constructor to make the class available to other classes
    public CoolPageFragment(){

    }

    public static CoolPageFragment newInstance(int pos){
        CoolPageFragment frag = new CoolPageFragment();
        Bundle args = new Bundle();
        args.putInt("pos", pos);
        frag.setArguments(args);
        return frag;
    }

    //Context thiscontext;
    //@Override
   // public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //thiscontext = container.getContext();
    //}
    //Context context2 = getMainActivity.grabContext();
    //private Context context2;
    //MainActivity getMainActivity = new MainActivity();
    //context2 = getMainActivity.grabContext();

    //public CoolPageFragment() {
        //Required empty public constructor
        //Context context;
        //context = MainActivity.getMainActivity.grabContext();
    //}
// how to call an intent from a non activity class??????
    //Intent intent = new Intent(context, FourthActivity.class)
            //.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    //context.startActivity(intent);
    //String path = getIntent().getStringExtra("str1");

    //ListActivity activity = new MainActivity(getContext());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = getArguments().getInt("pos");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //thiscontext = container.getContext();


        //use getActivity with getApplicationContext to access context based methods such as
        //getAssets in a non activity class
        try{
            AssetManager assetManager = getActivity().getApplicationContext().getAssets();
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
        //use this if files are in 'drawable' folder
        //imageView.setImageResource(R.drawable.b);
        //Bundle bundle = getArguments();
        //String message = Integer.toString(bundle.getInt("count"));

        View view = inflater.inflate(R.layout.fragment_cool_page, container, false);
        //ImageView coolPhotos = (ImageView) view.findViewById(R.id.imageView); no need to cast
        // view.findViewById by putting (ImageView) in front of it according to Android Studio
        // even through the stackoverflow had it
        ImageView coolPhotos = view.findViewById(R.id.imageView);
        switch (mPosition){
            case 0:
                coolPhotos = imageView;
            case 1:
                coolPhotos = imageView;
            case 2:
                coolPhotos = imageView;
        }
        return view;
    }

}
