package com.robboapps.ottawa4kidstest;


import android.app.ListActivity;
import android.app.ListFragment;
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
import java.util.ArrayList;
import java.util.Arrays;

//import static android.media.CamcorderProfile.get;
import static java.lang.String.valueOf;


/**
 * A simple {@link Fragment} subclass.
 */
public class CoolPageFragment extends Fragment {

    ImageView imageView;
    //AssetManager assetManager = getContext().getAssets();
    //Bitmap[] picString;
    Integer numImages;
    String[] imgList;
    static String activityTranslate;
    //should mPosition be private (was in stackoverflow example)
    int mPosition;
    ArrayList<Bitmap> picString = new ArrayList<>();
//empty constructor to make the class available to other classes
    //public CoolPageFragment(){

    //}

    public static CoolPageFragment newInstance(int pos, String WhichActivity) {
        activityTranslate = WhichActivity;
        CoolPageFragment frag = new CoolPageFragment();
        Bundle args = new Bundle();
        args.putInt("pos", pos);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = getArguments() != null ? getArguments().getInt("pos") : 1;
        System.out.println("XANADU 67  position is " + mPosition);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //thiscontext = container.getContext();


        //use getActivity with getApplicationContext to access context based methods such as
        //getAssets in a non activity class

        //old try block that works
/*
        try{
            AssetManager assetManager = getActivity().getApplicationContext().getAssets();
            String[] imgList = assetManager.list("trainmuseum");
            System.out.println("XANADU 9" + Arrays.toString(imgList));
            numImages = imgList.length;
            //for(int i = 0; i < imgList.length; i++){
            //picString.add(String.valueOf(i));
                //picString.add("trainmuseum/" + imgList[i]);
            //System.out.print("XANADU15  " + picString.get(i) + " ");
            //String fred = picString.get(i);



            System.out.println("XANADU10" + "  " + numImages);
            String filename1 = "trainmuseum/" + imgList[0];
            InputStream is1 = assetManager.open(filename1);
            //InputStream is = assetManager.open("trainmuseum/c.png");
            //InputStream is = assetManager.open("c");

            bitmap = BitmapFactory.decodeStream(is1);
        }catch (IOException e) {
            e.printStackTrace();
        }
*/

        //new try block to iterate bitmaps into the switch function

        try {
            AssetManager assetManager = getActivity().getApplicationContext().getAssets();
            imgList = assetManager.list(activityTranslate);
            System.out.println("XANADU 03" + Arrays.toString(imgList));
            numImages = imgList.length;
            for (int i = 0; i < imgList.length; i++) {
                //picString.add(String.valueOf(i));
                //String filename = "trainmuseum/" + imgList[0];
                picString.add(i, BitmapFactory.decodeStream(assetManager.open(activityTranslate +"/" + imgList[i])));
                System.out.print("XANADU15  " + picString.get(i) + " ");
                //String fred = picString.get(i);
            }


            //System.out.println("XANADU 04" + "  " + numImages);
            //String filename1 = "trainmuseum/" + imgList[0];
            //InputStream is1 = assetManager.open(filename1);
            //InputStream is = assetManager.open("trainmuseum/c.png");
            //InputStream is = assetManager.open("c");

            //bitmap = BitmapFactory.decodeStream(is1);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //imageView.setImageBitmap(bitmap);
        //use this if files are in 'drawable' folder
        //imageView.setImageResource(R.drawable.b);
        //Bundle bundle = getArguments();
        //String message = Integer.toString(bundle.getInt("count"));
        //push check

        View view = inflater.inflate(R.layout.fragment_cool_page, container, false);
        //ImageView coolPhotos = (ImageView) view.findViewById(R.id.imageView); no need to cast
        // view.findViewById by putting (ImageView) in front of it according to Android Studio
        // even through the stackoverflow had it
        imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.b);
        if (mPosition == 0){
            imageView.setImageBitmap(picString.get(0));
        }else {
            imageView.setImageBitmap(picString.get(1));
        }
/*
        switch (mPosition) {
            case 0:
                imageView.setImageBitmap(picString.get(0));
                //imageView.setImageBitmap(bitmap);
                //imageView.setImageResource(R.drawable.b);
                //System.out.print("XANADU 05  ");
            case 1:
                imageView.setImageBitmap(picString.get(1));
                //imageView.setImageBitmap(bitmap);
                //imageView.setImageResource(R.drawable.c);
                //System.out.print("XANADU 06  ");
                //default:
                //imageView.setImageResource(R.drawable.d);
                //System.out.print("XANADU 07  ");
            default:
                imageView.setImageBitmap(picString.get(0));

                //}
                //return view;
        }
        */
return view;
    }
}
