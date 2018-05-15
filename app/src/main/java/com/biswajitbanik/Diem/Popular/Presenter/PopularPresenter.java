package com.biswajitbanik.Diem.Popular.Presenter;

import com.biswajitbanik.Diem.Popular.Repository.PopularDBCallback;
import com.biswajitbanik.Diem.Popular.Repository.PopularDBHandler;
import com.biswajitbanik.Diem.Popular.Repository.PopularModel;
import com.biswajitbanik.Diem.Popular.ViewModel.PopularViewModel;

import java.util.List;

/**
 * Created by Omar Faruq on 5/15/2018.
 */

public class PopularPresenter {

    private PopularViewModel mViewModel;
    private PopularDBHandler mDBhandler;
    private List<PopularModel> mPopularModels;

    public PopularPresenter(PopularViewModel mViewModel, PopularDBHandler mDBhandler) {
        this.mViewModel = mViewModel;
        this.mDBhandler = mDBhandler;

        loadPopularList();
    }

    private void loadPopularList() {
        mDBhandler.getPopularModelList(new PopularDBCallback() {
            @Override
            public void getPopularList(List<PopularModel> popularModels) {
                mPopularModels = popularModels;
                mViewModel.showPopularModels();
            }
        });
    }


    public int getPopularModelsListSize() {
        return mPopularModels.size();
    }

    public int getPopularItemIVId(int position) {
        return mPopularModels.get(position).getmPopularPicId();
    }

    public String getPopularItemName(int position) {
        return mPopularModels.get(position).getmPopularName();
    }
}
