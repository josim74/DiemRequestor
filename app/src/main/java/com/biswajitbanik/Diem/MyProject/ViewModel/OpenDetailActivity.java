package com.biswajitbanik.Diem.MyProject.ViewModel;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.transition.Fade;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.biswajitbanik.Diem.MyProject.Presenter.OpenDetailPresenter;
import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.ActivityOpenDetailBinding;


public class OpenDetailActivity extends AppCompatActivity implements OpenDetailViewModel {
private ActivityOpenDetailBinding mBinding;
private OpenDetailPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this, R.layout.activity_open_detail);
        mPresenter = new OpenDetailPresenter(this);

        Fragment  fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = new MyProjectOpenOfferFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }


        mBinding.taskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mPresenter.taskButtonClick();

            }
        });

        mBinding.offerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.offerButtonClick();

            }
        });
    }

    @Override
    public void openOfferFragment() {
        MyProjectOpenOfferFragment offerFragment  = new MyProjectOpenOfferFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,offerFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void openTaskFragment() {
        MyProjectOpenTaskFragment taskFragment = new MyProjectOpenTaskFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,taskFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void offerSelectedStyle() {
        mBinding.offerBtn.setTextColor(ContextCompat.getColor(this,R.color.my_project_offer_selected_color));
        mBinding.offerBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.offers_selected));

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void offerUnselectedStyle() {
        mBinding.offerBtn.setTextColor(ContextCompat.getColor(this,R.color.my_project_offer_unselected_color));
        mBinding.offerBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.offer_unselected));
    }

    @Override
    public void taskSelectedStyle() {
        mBinding.taskBtn.setTextColor(ContextCompat.getColor(this,R.color.my_project_offer_selected_color));
        mBinding.taskBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.task_selected));
    }

    @Override
    public void taskUnselectedSyle() {
        mBinding.taskBtn.setTextColor(ContextCompat.getColor(this,R.color.my_project_offer_unselected_color));
        mBinding.taskBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.task_unselected));
    }
}
