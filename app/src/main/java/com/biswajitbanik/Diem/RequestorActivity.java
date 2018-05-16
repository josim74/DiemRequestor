package com.biswajitbanik.Diem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.biswajitbanik.Diem.HomeCategory.ViewModel.CategoryFragment;
import com.codility.introsilder.R;

import java.util.ArrayList;
import java.util.List;

//MainActivity
public class RequestorActivity extends Fragment {


    boolean isUserFirstTime;
    ImageView headerImg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_homepage,container,false);

//        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//   ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
//
//
//        if(((AppCompatActivity)getActivity()).getSupportActionBar() != null)
//            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

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

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        headerImg = view.findViewById(R.id.background);

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

        return view;
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
