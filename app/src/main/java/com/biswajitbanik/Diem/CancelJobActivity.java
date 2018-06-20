package com.biswajitbanik.Diem;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.biswajitbanik.Diem.databinding.ActivityCancelJobBinding;

public class CancelJobActivity extends AppCompatActivity {
    private ActivityCancelJobBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mBinding = DataBindingUtil.setContentView(this,R.layout.activity_cancel_job);
       mBinding.confirmButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(CancelJobActivity.this,ThanksFeedbackActivity.class));
               finish();
           }
       });
    }
}
