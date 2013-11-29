package com.example.tabslider;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;

import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends Activity {

    final String[] page_titles = new String[]{"Home", "Me", "Apps", "Android", "About"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiating Adapter
        MyAdapter myAdapter = new MyAdapter(this);

        // Intantiate the Views
        ViewPager mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(myAdapter);

        TabPageIndicator mIndicator = (TabPageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }

    private class MyAdapter extends PagerAdapter {

        Context context;

        public MyAdapter(Context c) {
            this.context = c;
        }

        @Override
        public int getCount() {
            return page_titles.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view.equals(o);
        }

        // This is the title of the page that will appear on the "tab"
        public CharSequence getPageTitle(int position) {
            return page_titles[position];
        }


        @Override
        public void restoreState(Parcelable p, ClassLoader c) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public Object instantiateItem(View pager, int position) {
            final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.page, null, false);


            //This is very important
            ( (ViewPager) pager ).addView( v, 0 );

            return v;
        }

        @Override
        public void destroyItem(View pager, int position, Object view) {
            ((ViewPager) pager).removeView((View) view);
        }

        @Override
        public void finishUpdate(View view) {
        }

        @Override
        public void startUpdate(View view) {
        }

    }


}
