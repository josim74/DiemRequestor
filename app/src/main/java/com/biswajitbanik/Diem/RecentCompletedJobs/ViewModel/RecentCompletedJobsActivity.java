package com.biswajitbanik.Diem.RecentCompletedJobs.ViewModel;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.biswajitbanik.Diem.MyProject.ViewModel.MyProjectOpenTaskFragment;
import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.RecentCompletedJobs.Presenter.RecentCompletedJobPresenter;
import com.biswajitbanik.Diem.RecentCompletedJobs.Repository.RecenctCompletedJobDBhandler;
import com.biswajitbanik.Diem.databinding.ActivityRecentCompletedJobsBinding;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.List;

public class RecentCompletedJobsActivity extends AppCompatActivity implements RecentJobCompleteViewModel {
    private ActivityRecentCompletedJobsBinding mBinding;
    private RecentCompletedJobPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recent_completed_jobs);
        mPresenter = new RecentCompletedJobPresenter(this, new RecenctCompletedJobDBhandler());

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = new MyProjectOpenTaskFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }


    }

    @Override
    public void displayImages(List<Integer> images) {
        for (Integer id :
                images) {
            DefaultSliderView sliderView = new DefaultSliderView(this);
            sliderView.image(id)
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            mBinding.slider.addSlider(sliderView);
        }
        mBinding.slider.stopAutoCycle();
//        mBinding.slider.getPagerIndicator().setDefaultIndicatorColor(R.color.indicator_selected_color,R.color.indicator_unselected_color);
    }
}
