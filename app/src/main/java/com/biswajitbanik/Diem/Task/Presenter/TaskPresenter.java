package com.biswajitbanik.Diem.Task.Presenter;

import com.biswajitbanik.Diem.Task.ViewModel.TaskViewModel;

/**
 * Created by Omar Faruq on 6/2/2018.
 */

public class TaskPresenter {

    private TaskViewModel mViewModel;

    public TaskPresenter(TaskViewModel mViewModel) {
        this.mViewModel = mViewModel;
        mViewModel.basicOnProgressState();
        mViewModel.picDisableState();
        mViewModel.priceDisableState();
    }

    public void basicResultOk() {
        mViewModel.basicCompleteState();
        mViewModel.picOnProgressState();
    }

    public void picResultOK() {
        mViewModel.picCompleteState();
        mViewModel.priceOnProgressState();
    }
}
