package com.robboapps.ottawa4kidstest;


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
import java.util.ArrayList;
import java.util.Arrays;

public class CoolPageFragment extends Fragment {

    ImageView imageView;
    Integer numImages;
    String[] imgList;
    static String activityTranslate;
    int mPosition;
    ArrayList<Bitmap> picString = new ArrayList<>();

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
        try {
            AssetManager assetManager = getActivity().getApplicationContext().getAssets();
            imgList = assetManager.list(activityTranslate);
            System.out.println("XANADU 03" + Arrays.toString(imgList));
            numImages = imgList.length;
            for (int i = 0; i < imgList.length; i++) {
                picString.add(i, BitmapFactory.decodeStream(assetManager.open(activityTranslate +"/" + imgList[i])));
                System.out.print("XANADU15  " + picString.get(i) + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        View view = inflater.inflate(R.layout.fragment_cool_page, container, false);
        imageView = view.findViewById(R.id.imageView);

        //how to set image reousrce if file is in the drawable folder
        //imageView.setImageResource(R.drawable.b);

        if (mPosition == 0){
            imageView.setImageBitmap(picString.get(0));
        }else {
            imageView.setImageBitmap(picString.get(1));
        }

/* switch as alternative to if else (does not add photos to individual swipe screens)
        switch (mPosition) {
            case 0:
                imageView.setImageBitmap(picString.get(0));
            case 1:
                imageView.setImageBitmap(picString.get(1));
            default:
                imageView.setImageBitmap(picString.get(0));
                //}
                //return view;
        }
        */
return view;
    }
}
