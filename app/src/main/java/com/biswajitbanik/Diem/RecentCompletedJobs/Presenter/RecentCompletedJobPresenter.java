package com.biswajitbanik.Diem.RecentCompletedJobs.Presenter;

import com.biswajitbanik.Diem.RecentCompletedJobs.Repository.RecenctCompletedJobDBhandler;
import com.biswajitbanik.Diem.RecentCompletedJobs.Repository.RecentCompletedJobDBCallback;
import com.biswajitbanik.Diem.RecentCompletedJobs.ViewModel.RecentJobCompleteViewModel;

import java.util.List;

/**
 * Created by Omar Faruq on 6/3/2018.
 */

public class RecentCompletedJobPresenter {
    private RecentJobCompleteViewModel mViewModel;
    private RecenctCompletedJobDBhandler mDBHandler;

    public RecentCompletedJobPresenter(RecentJobCompleteViewModel mViewModel, RecenctCompletedJobDBhandler mDBHandler) {
        this.mViewModel = mViewModel;
        this.mDBHandler = mDBHandler;
        loadImages();
    }

    private void loadImages() {
        mDBHandler.getRecentCompltedJobImages(new RecentCompletedJobDBCallback() {
            @Override
            public void getListOfImages(List<Integer> images) {
                mViewModel.displayImages(images);
            }
        });
    }


}
