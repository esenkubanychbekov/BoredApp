package com.example.boredapp.intro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.boredapp.R;
import com.example.boredapp.main.IntroPageFragment;
import com.example.boredapp.main.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private final static String ARG_TITLE_RES_ID = "title_res";

    IntroPagerAdapter adapter;
    ViewPager pager;

    public static void start(Context context){
        Intent intent = new Intent(context, IntroActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ArrayList<IntroPageConfig> pages = new ArrayList<>();

        pages.add(new IntroPageConfig(
                R.string.page1,
                R.drawable.ic_work));

        pages.add(new IntroPageConfig(
                R.string.page2,
                R.drawable.ic_work));

        pages.add(new IntroPageConfig(
                R.string.page3,
                R.drawable.ic_work));

        pages.add(new IntroPageConfig(
                R.string.page4,
                R.drawable.ic_work));

       adapter = new IntroPagerAdapter(getSupportFragmentManager(),pages);
        pager = findViewById(R.id.pager);
        pager.setAdapter(adapter);
    }

    public class IntroPagerAdapter extends FragmentPagerAdapter{

        List<IntroPageConfig> pages;

        public IntroPagerAdapter(FragmentManager fm, List<IntroPageConfig> pages) {
            super(fm);
            this.pages = pages;
        }

        @Override
        public Fragment getItem(int position) {
            return IntroPageFragment.newInstance(pages.get(position));
        }

        @Override
        public int getCount() {
            return pages.size();
        }
    }

    private void nextClick(){
        if (adapter.getCount() - 1 >= pager.getCurrentItem()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            pager.setCurrentItem(pager.getCurrentItem() + 1);
        }
    }

}
