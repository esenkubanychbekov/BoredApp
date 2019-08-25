package com.example.boredapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {
    private final static String ARG_TITLE_RES_ID = "title_res";


    public IntroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro, container, false);
        TextView textView = view.findViewById(R.id.text1);
        ImageView imageView = view.findViewById(R.id.imageView);
        Button skip = view.findViewById(R.id.button1);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        int pos = getArguments().getInt(ARG_TITLE_RES_ID);

        switch (pos){
            case 0:
                textView.setText("Fragment1");
                imageView.setImageResource(R.drawable.ic_work);
                break;
            case 1:
                textView.setText("Fragment2");
                imageView.setImageResource(R.drawable.ic_work);
                break;
            case 2:
                textView.setText("Fragment3");
                imageView.setImageResource(R.drawable.ic_work);
                break;

        }

        return view;
    }


}
