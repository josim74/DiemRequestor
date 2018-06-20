package com.biswajitbanik.Diem.Task.ViewModel;

/**
 * Created by Omar Faruq on 6/1/2018.
 */

public interface TaskViewModel {

    void basicCompleteState();
    void basicOnProgressState();

    void picDisableState();
    void picOnProgressState();
    void picCompleteState();


    void priceDisableState();
    void priceOnProgressState();
    void priceCompleteState();


}
