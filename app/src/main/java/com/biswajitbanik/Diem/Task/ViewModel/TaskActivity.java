package com.biswajitbanik.Diem.Task.ViewModel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.Task.Presenter.TaskPresenter;
import com.biswajitbanik.Diem.databinding.ActivityTaskBinding;

public class TaskActivity extends AppCompatActivity implements TaskViewModel {

    private static final int BASIC_REQUEST_CODE = 1;
    private static final int PIC_REQUEST_CODE = 2;
    private ActivityTaskBinding mBinding;
    private TaskPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_task);
        mPresenter = new TaskPresenter(this);
        mBinding.basicContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(TaskActivity.this,TaskFlowActivity.class),BASIC_REQUEST_CODE);
            }
        });

        mBinding.picContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(TaskActivity.this,TaskPicActivity.class),PIC_REQUEST_CODE);
            }
        });

        mBinding.priceContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TaskActivity.this,TaskBudgetActivity.class));
            }
        });
    }

    @Override
    public void basicCompleteState() {
        mBinding.basicImageView.setVisibility(View.VISIBLE);
        mBinding.basicContinueBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.orange_border_btn));
        mBinding.basicContinueBtn.setText("Edit Info");
        mBinding.basicContinueBtn.setTextColor(ContextCompat.getColor(this,R.color.edit_info_text_color));
    }

    @Override
    public void basicOnProgressState() {
        mBinding.basicImageView.setVisibility(View.GONE);
        mBinding.basicContinueBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.btn_background));
        mBinding.basicContinueBtn.setText("Continue");
        mBinding.basicContinueBtn.setTextColor(ContextCompat.getColor(this,R.color.white));
    }

    @Override
    public void picDisableState() {
        mBinding.picContinueBtn.setVisibility(View.GONE);
        mBinding.picImageView.setVisibility(View.GONE);
        mBinding.picTitleTv.setTextColor(ContextCompat.getColor(this,R.color.disable_title_text_color));
        mBinding.picDetailTv.setTextColor(ContextCompat.getColor(this,R.color.disable_title_text_color));

    }

    @Override
    public void picOnProgressState() {
        mBinding.picContinueBtn.setVisibility(View.VISIBLE);
        mBinding.picTitleTv.setTextColor(ContextCompat.getColor(this,R.color.task_enable_text_color));
        mBinding.picDetailTv.setTextColor(ContextCompat.getColor(this,R.color.task_enable_text_color));

    }

    @SuppressLint("NewApi")
    @Override
    public void picCompleteState() {
        mBinding.picContinueBtn.setVisibility(View.VISIBLE);
        mBinding.picImageView.setVisibility(View.VISIBLE);
        mBinding.picContinueBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.orange_border_btn));
        mBinding.picContinueBtn.setText("Edit Info");
        mBinding.picContinueBtn.setTextColor(ContextCompat.getColor(this,R.color.edit_info_text_color));

        mBinding.picTitleTv.setTextColor(ContextCompat.getColor(this,R.color.task_enable_text_color));
        mBinding.picDetailTv.setTextColor(ContextCompat.getColor(this,R.color.task_enable_text_color));
    }

    @Override
    public void priceDisableState() {
        mBinding.priceContinueBtn.setVisibility(View.GONE);
        mBinding.priceImageView.setVisibility(View.GONE);
        mBinding.priceTitleTv.setTextColor(ContextCompat.getColor(this,R.color.disable_title_text_color));
        mBinding.priceDetailTv.setTextColor(ContextCompat.getColor(this,R.color.disable_title_text_color));
    }

    @Override
    public void priceOnProgressState() {
        mBinding.priceContinueBtn.setVisibility(View.VISIBLE);
        mBinding.priceTitleTv.setTextColor(ContextCompat.getColor(this,R.color.task_enable_text_color));
        mBinding.priceDetailTv.setTextColor(ContextCompat.getColor(this,R.color.task_enable_text_color));
    }

    @Override
    public void priceCompleteState() {
        mBinding.priceContinueBtn.setVisibility(View.VISIBLE);
        mBinding.priceImageView.setVisibility(View.VISIBLE);
        mBinding.priceContinueBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.orange_border_btn));
        mBinding.priceContinueBtn.setText("Edit Info");
        mBinding.priceContinueBtn.setTextColor(ContextCompat.getColor(this,R.color.edit_info_text_color));

        mBinding.priceTitleTv.setTextColor(ContextCompat.getColor(this,R.color.task_enable_text_color));
        mBinding.priceDetailTv.setTextColor(ContextCompat.getColor(this,R.color.task_enable_text_color));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){
            case BASIC_REQUEST_CODE:
                if (resultCode == RESULT_OK){
                    mPresenter.basicResultOk();
                }
                break;

            case PIC_REQUEST_CODE:
                if (resultCode==RESULT_OK){
                    mPresenter.picResultOK();
                }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
