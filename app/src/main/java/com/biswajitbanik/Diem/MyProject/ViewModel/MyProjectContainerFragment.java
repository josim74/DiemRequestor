package com.biswajitbanik.Diem.MyProject.ViewModel;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.FragmentMyProjectBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProjectContainerFragment extends Fragment {
    private FragmentMyProjectBinding mBinding;

    public MyProjectContainerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_project, container, false);
        MyProjectStatePagerAdapter adapter = new MyProjectStatePagerAdapter(getChildFragmentManager());
        mBinding.viewpager.setAdapter(adapter);
        mBinding.tablayout.setupWithViewPager(mBinding.viewpager);

        return mBinding.getRoot();
    }



    public class MyProjectStatePagerAdapter extends FragmentStatePagerAdapter {


        public MyProjectStatePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           MyProjectFragment fragment = new MyProjectFragment();
           fragment.initFragment(position);

            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0:
                    return  "OPEN";
                case 1:
                    return   "ASSIGNED";
                case 2:
                    return "COMPLETED";
               default:
                    return  "UNFULFILLED";
            }


        }

        @Override
        public int getCount() {
            return 4;
        }
    }

}
