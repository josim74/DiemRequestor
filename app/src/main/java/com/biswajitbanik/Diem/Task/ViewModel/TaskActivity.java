package com.biswajitbanik.Diem.Task.ViewModel;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.ActivityTaskBinding;

public class TaskActivity extends AppCompatActivity {

    private ActivityTaskBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_task);
        mBinding.basicContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TaskActivity.this,TaskFlowActivity.class));
            }
        });

        mBinding.picContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TaskActivity.this,TaskPicActivity.class));
            }
        });

        mBinding.priceContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TaskActivity.this,TaskBudgetActivity.class));
            }
        });
    }
}
