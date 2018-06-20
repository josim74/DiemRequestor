package com.biswajitbanik.Diem;


import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.biswajitbanik.Diem.databinding.FragmentAboutusBinding;


public class MyAboutusActivity extends AppCompatActivity {

    private FragmentAboutusBinding mBinding;
    private String[] mAboutNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this , R.layout.fragment_aboutus);

        mAboutNames = new String[]{
                "Terms of use",
                "Privacy Policy"
        };

    }


}
