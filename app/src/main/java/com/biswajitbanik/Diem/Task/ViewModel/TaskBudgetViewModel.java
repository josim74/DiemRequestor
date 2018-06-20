package com.biswajitbanik.Diem.Task.ViewModel;

/**
 * Created by Omar Faruq on 5/30/2018.
 */

public interface TaskBudgetViewModel {
    void showErrorMsg();

    void removeErrorMsg();

    void setETText(String msg);

    void openSummaryActivity();
}
