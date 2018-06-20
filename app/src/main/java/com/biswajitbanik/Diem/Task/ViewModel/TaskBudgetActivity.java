package com.biswajitbanik.Diem.Task.ViewModel;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.databinding.DataBindingUtil;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.Task.Presenter.TaskBudgetPresenter;
import com.biswajitbanik.Diem.databinding.ActivityTaskBudgetBinding;

public class TaskBudgetActivity extends AppCompatActivity implements TaskBudgetViewModel {
        private ActivityTaskBudgetBinding mBinding;
        private TaskBudgetPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_task_budget);
        mPresenter = new TaskBudgetPresenter(this);

        mBinding.budgetEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                mPresenter.newText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBinding.budgetEt.setSelection(1);

        mBinding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onNextBtnClick();
            }
        });

    }

    @Override
    public void showErrorMsg() {
        mBinding.errorTv.setVisibility(View.VISIBLE);
        ColorStateList colorStateList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.red));
        ViewCompat.setBackgroundTintList(mBinding.budgetEt, colorStateList);
    }

    @Override
    public void removeErrorMsg() {
        mBinding.errorTv.setVisibility(View.INVISIBLE);
        ColorStateList colorStateList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.edit_text_line_color));
        ViewCompat.setBackgroundTintList(mBinding.budgetEt, colorStateList);
    }

    @Override
    public void setETText(String msg) {
        mBinding.budgetEt.setText(msg);
        mBinding.budgetEt.setSelection(msg.length());
    }

    @Override
    public void openSummaryActivity() {
        finish();
        startActivity(new Intent(this,RequestSummaryActivity.class));
    }
}
