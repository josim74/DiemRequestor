package com.biswajitbanik.Diem;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.codility.introsilder.R;

public class PagerActivity extends AppCompatActivity {

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    int page = 0; //tracking page position
    Button mSkipBtn, mFinishBtn, mNextBtn;

    ImageView zero, one, two;
    ImageView[] indicators;

    CoordinatorLayout mCoordinator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        /*
      The {@link android.support.v4.view.PagerAdapter} that will provide
      fragments for each of the sections. We use a
      {@link FragmentPagerAdapter} derivative, which will keep every
      loaded fragment in memory. If this becomes too memory intensive, it
      may be best to switch to a
      {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mSkipBtn = (Button) findViewById(R.id.intro_btn_skip);
        mFinishBtn = (Button) findViewById(R.id.intro_btn_finish);
        mNextBtn = (Button) findViewById(R.id.intro_btn_next);

        zero = (ImageView) findViewById(R.id.intro_indicator_0);
        one = (ImageView) findViewById(R.id.intro_indicator_1);
        two = (ImageView) findViewById(R.id.intro_indicator_2);

        mCoordinator = (CoordinatorLayout) findViewById(R.id.main_content);

        indicators = new ImageView[]{zero, one, two};

        //set up ViewPager
        mViewPager = (ViewPager) findViewById(R.id.container);

        final int slideColor = ContextCompat.getColor(this, R.color.diem_orange);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mViewPager.setBackgroundColor(slideColor);
            }

            @Override
            public void onPageSelected(int position) {
                page = position;
                updateIndicators(page);

                switch (position){
                    case 0:
                        mViewPager.setBackgroundColor(slideColor);
                        break;
                    case 1:
                        mViewPager.setBackgroundColor(slideColor);
                        break;
                    case 2:
                        mViewPager.setBackgroundColor(slideColor);
                        break;
                }

                mNextBtn.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
                mFinishBtn.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
                mSkipBtn.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page += 1;
                mViewPager.setCurrentItem(page, true);
            }
        });

        mSkipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                //  update 1st time pref
                Utils.saveSharedSetting(PagerActivity.this, RequestorActivity.PREF_USER_FIRST_TIME, "false");
            }
        });

    }

    private void updateIndicators(int page) {
        for(int i = 0; i < indicators.length; i++){
            indicators[i].setBackgroundResource(i == page ? R.drawable.indicator_selected : R.drawable.indicator_unselected);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        ImageView img;
        int images[] = new int[]{R.drawable.onboarding1, R.drawable.onboarding2, R.drawable.onboarding3};
        String[] titleTextStrings = {"Post Task Requests", "Pick the right contender", "Seize the day!"};
        String[] subTextStrings = {"Choose among multiple offers on your own terms and at your own convenience", "Easily communicate task details with jobbers in your area", "Outsource chores and focus on things that actually matter."};

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_pager, container, false);
            TextView titleText = (TextView) rootView.findViewById(R.id.section_label);
            TextView subText = (TextView) rootView.findViewById(R.id.section_label2);
            titleText.setText(titleTextStrings[getArguments().getInt(ARG_SECTION_NUMBER)-1]);
            subText.setText(subTextStrings[getArguments().getInt(ARG_SECTION_NUMBER)-1]);

            img = (ImageView) rootView.findViewById(R.id.section_img);
            img.setBackgroundResource(images[getArguments().getInt(ARG_SECTION_NUMBER)-1]);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }

}
