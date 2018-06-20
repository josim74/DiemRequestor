package com.biswajitbanik.Diem.Task.Presenter;

import com.biswajitbanik.Diem.Task.ViewModel.TaskBudgetViewModel;

/**
 * Created by Omar Faruq on 5/30/2018.
 */

public class TaskBudgetPresenter {
    private TaskBudgetViewModel mViewModel;
    private int mBudget;

    public TaskBudgetPresenter(TaskBudgetViewModel mViewModel) {
        this.mViewModel = mViewModel;
    }

    public void newText(String text) {
        if (text.length() == 0){
            mViewModel.setETText("$");
        }
        if (text.length() <= 1 )
            return;
        text = text.substring(1);
        int budget = Integer.parseInt(text);
        if (budget<15){
            mViewModel.showErrorMsg();
        }else {
            mViewModel.removeErrorMsg();
            mBudget = budget;
        }

    }

    public void onNextBtnClick() {
        if (mBudget>0){
            mViewModel.openSummaryActivity();
        }
    }
}
