package com.biswajitbanik.Diem.Task.ViewModel;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.biswajitbanik.Diem.Task.Presenter.TaskFlowPresenter;
import com.biswajitbanik.Diem.Task.Repository.QuestionDBHandler;
import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.ActivityTaskFlowBinding;

public class TaskFlowActivity extends AppCompatActivity implements TaskFlowViewModel , TaskLocationFragment.LocationFragmentCallback {

    private ActivityTaskFlowBinding mBinding;
    private TaskFlowPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_task_flow);
        mPresenter = new TaskFlowPresenter(this,new QuestionDBHandler());

        mBinding.viewpager.setAdapter(new TaskFlowStatePagerAdapter(getSupportFragmentManager()));


        mBinding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewpager.setCurrentItem(mBinding.viewpager.getCurrentItem()+1);
                mBinding.progressBar.setProgress(mBinding.viewpager.getCurrentItem());
            }
        });

        mBinding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               mPresenter.selectedPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void setNextButtonVisibility(int visibility) {
        mBinding.nextBtn.setVisibility(visibility);
    }

    @Override
    public void returnSuccessfullyCompleted() {
        Intent returnIntent = new Intent();
        setResult(RESULT_OK,returnIntent);
        finish();
    }

    @Override
    public void onSuccessfulComplete() {
        mPresenter.successfullyCompleted();
    }


    public class TaskFlowStatePagerAdapter extends FragmentStatePagerAdapter{

        public TaskFlowStatePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {



            return  mPresenter.getFragment(position);
        }

        @Override
        public int getCount() {
            return mPresenter.getTotalQuestion();
        }
    }
}
