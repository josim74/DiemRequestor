package com.biswajitbanik.Diem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.biswajitbanik.Diem.HomeCategory.ViewModel.CategoryFragment;
import com.codility.introsilder.R;

import java.util.ArrayList;
import java.util.List;

//MainActivity
public class RequestorActivity extends AppCompatActivity {

    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    boolean isUserFirstTime;
    ImageView headerImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //If the app is fresh, this will be true and will start an intent to PagerActivity

        //isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(RequestorActivity.this, PREF_USER_FIRST_TIME, "true"));
        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(RequestorActivity.this, PREF_USER_FIRST_TIME, "true"));

        Intent intent = new Intent(RequestorActivity.this, IntroActivity.class);
        intent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);

        if (isUserFirstTime) {
            startActivity(intent);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        CategoryFragment fragment = new CategoryFragment();
        fragment.initFragment(0);
        adapter.addFragment( fragment, "Popular");

        fragment = new CategoryFragment();
        fragment.initFragment(1);
        adapter.addFragment(fragment, "Outdoor");

        fragment = new CategoryFragment();
        fragment.initFragment(2);
        adapter.addFragment(fragment, "Handy & Skilled");

        fragment = new CategoryFragment();
        fragment.initFragment(3);
        adapter.addFragment(fragment, "Cleaning");

        fragment = new CategoryFragment();
        fragment.initFragment(4);
        adapter.addFragment(fragment, "Technology");

        fragment = new CategoryFragment();
        fragment.initFragment(5);
        adapter.addFragment(fragment, "Automobile");

        fragment = new CategoryFragment();
        fragment.initFragment(6);
        adapter.addFragment(fragment, "Food & Event");

        fragment = new CategoryFragment();
        fragment.initFragment(7);
        adapter.addFragment(fragment, "Beauty & Lifestyle");

        fragment = new CategoryFragment();
        fragment.initFragment(8);
        adapter.addFragment(fragment, "Education & Business");

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        headerImg = findViewById(R.id.background);

        final int[] imgIDs = {R.drawable.header1, R.drawable.header2, R.drawable.header3, R.drawable.header4,
                R.drawable.header5, R.drawable.header1, R.drawable.header1, R.drawable.header1, R.drawable.header1};

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if(position > 4)
                    headerImg.setImageResource(R.drawable.header1);
                else
                    headerImg.setImageResource(imgIDs[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    // Adapter for the viewpager using FragmentPagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {

            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
