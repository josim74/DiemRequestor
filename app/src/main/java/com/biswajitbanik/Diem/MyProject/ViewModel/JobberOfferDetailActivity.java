package com.biswajitbanik.Diem.MyProject.ViewModel;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.biswajitbanik.Diem.JobberProfileActivity;
import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.ActivityJobberOfferDetailBinding;

public class JobberOfferDetailActivity extends AppCompatActivity {
    private ActivityJobberOfferDetailBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_jobber_offer_detail);

        mBinding.acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JobberOfferDetailActivity.this,PaymentMethodActivity.class));
            }
        });

        mBinding.viewProfileTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JobberOfferDetailActivity.this, JobberProfileActivity.class));
            }
        });
    }
}
