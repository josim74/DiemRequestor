package com.biswajitbanik.Diem.MyProject.ViewModel;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.biswajitbanik.Diem.CancelJobActivity;
import com.biswajitbanik.Diem.JobCompleteActivity;
import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.ActivityMyProjectOtherDetailBinding;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.ArrayList;
import java.util.List;

public class MyProjectOtherDetailActivity extends AppCompatActivity {

    private ActivityMyProjectOtherDetailBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_my_project_other_detail);

        mBinding.markJobCompleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyProjectOtherDetailActivity.this, JobCompleteActivity.class));
            }
        });

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.lawncare);
        images.add(R.drawable.snow_removal);
        images.add(R.drawable.moving);
        images.add(R.drawable.painting);


        for (Integer id :
                images) {
            DefaultSliderView sliderView = new DefaultSliderView(this);
            sliderView.image(id)
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            mBinding.slider.addSlider(sliderView);
        }
        mBinding.slider.stopAutoCycle();


        mBinding.cancelIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyProjectOtherDetailActivity.this, CancelJobActivity.class));
            }
        });

        mBinding.cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyProjectOtherDetailActivity.this, CancelJobActivity.class));

            }
        });

    }
}
