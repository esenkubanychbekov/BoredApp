package com.example.boredapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

public class IntroActivity extends AppCompatActivity {

    private final static String ARG_TITLE_RES_ID = "title_res";

    public static void start(Context context){
        Intent intent = new Intent(context, IntroActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ViewPager pager = findViewById(R.id.pager);
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

    }


    public  static class  SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return newInstance(position);
        }

        @Override
        public int getCount() {
            return 3;
        }

        public static Fragment newInstance(@StringRes int titleRes){
            Bundle args = new Bundle();
            args.putInt(ARG_TITLE_RES_ID,titleRes);
            IntroFragment fragment = new IntroFragment();
            fragment.setArguments(args);
            return fragment;
        }
    }

}
