package com.biswajitbanik.Diem.MyProject.ViewModel;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codility.introsilder.R;
import com.codility.introsilder.databinding.FragmentMyProject2Binding;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProjectFragment extends Fragment implements MyProjectViewModel {
    private FragmentMyProject2Binding mBinding;
    public MyProjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_project2, container, false);
        return mBinding.getRoot();
    }

}
