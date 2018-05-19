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

import com.codility.introsilder.R;
import com.codility.introsilder.databinding.FragmentMyProjectBinding;


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

        



        return mBinding.getRoot();
    }



    public class MyProjectStatePagerAdapter extends FragmentStatePagerAdapter {


        public MyProjectStatePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }
    }

}
