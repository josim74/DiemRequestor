package com.biswajitbanik.Diem;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.biswajitbanik.Diem.MyProject.ViewModel.MyProjectFragment;
import com.biswajitbanik.Diem.MyProject.ViewModel.MyProjectOpenOfferFragment;
import com.biswajitbanik.Diem.databinding.ActivityPopularRequestBinding;

public class PopularRequestActivity extends AppCompatActivity {
    private ActivityPopularRequestBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mBinding = DataBindingUtil. setContentView(this,R.layout.activity_popular_request);

       setSupportActionBar(mBinding.toolbar);
       getSupportActionBar().setTitle("Popular Request");
       mBinding.toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white));




        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        if (fragment == null){
            MyProjectFragment fragment1 = new MyProjectFragment();

            fragment1.initFragment(0);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container,fragment1)
                    .commit();

        }
    }
}
