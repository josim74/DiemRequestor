package com.biswajitbanik.Diem.MyProject.Presenter;

import com.biswajitbanik.Diem.MyProject.ViewModel.OpenDetailViewModel;

/**
 * Created by Omar Faruq on 6/5/2018.
 */

public class OpenDetailPresenter {

    private OpenDetailViewModel mViewModel;

    public OpenDetailPresenter(OpenDetailViewModel mViewModel) {
        this.mViewModel = mViewModel;
    }


    public void taskButtonClick() {
        mViewModel.openTaskFragment();
        mViewModel.taskSelectedStyle();
        mViewModel.offerUnselectedStyle();
    }

    public void offerButtonClick() {
        mViewModel.openOfferFragment();
        mViewModel.offerSelectedStyle();
        mViewModel.taskUnselectedSyle();
    }
}
