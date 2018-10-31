package com.robboapps.ottawa4kidstest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
//import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CoolPageFragment extends Fragment {

    ImageView imageView;
    int mPosition;

    public static CoolPageFragment newInstance(int pos){
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

        View view = inflater.inflate(R.layout.fragment_cool_page, container, false);
       imageView = view.findViewById(R.id.imageView);
       if (mPosition == 1){
           imageView.setImageResource(R.drawable.b);
       }else {
           imageView.setImageResource(R.drawable.c);
       }
        return view;
    }

}
