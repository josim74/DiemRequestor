package com.biswajitbanik.Diem.HomeCategory.Presenter;

import com.biswajitbanik.Diem.HomeCategory.Repository.PopularDBCallback;
import com.biswajitbanik.Diem.HomeCategory.Repository.PopularDBHandler;
import com.biswajitbanik.Diem.HomeCategory.Repository.CategoryModel;
import com.biswajitbanik.Diem.HomeCategory.Repository.RecentJobModel;
import com.biswajitbanik.Diem.HomeCategory.ViewModel.PopularViewModel;

import java.util.List;

/**
 * Created by Omar Faruq on 5/15/2018.
 */

public class PopularPresenter {

    private PopularViewModel mViewModel;
    private PopularDBHandler mDBhandler;
    private List<CategoryModel> mCategoryModels;
    private List<RecentJobModel> mRecentJobList;
    private int mCategoryIndex;

    public PopularPresenter(PopularViewModel mViewModel, PopularDBHandler mDBhandler, int mCategoryIndex) {
        this.mViewModel = mViewModel;
        this.mDBhandler = mDBhandler;
        this.mCategoryIndex = mCategoryIndex;


        loadCategoryList();
        loadRecentJob();
    }

    private void loadCategoryList(){
        switch (mCategoryIndex){
            case 0:
                loadPopularList();
                break;
            case 1:
                loadOutdoorList();
                break;
            case 2:
                loadHandyandSkilled();
                break;
            case 3:
                loadCleaning();
                break;
            case 4:
                loadTechnology();
                break;
            case 5:
                loadAutomobile();
                break;
            case 6 :
                loadFoodandEvent();
                break;
            case 7:
                loadBeautyandLifestyle();
                break;
            case 8:
                loadEducation();
                break;

        }

    }

    private void loadEducation() {
        mDBhandler.getEducationandbusinessList(new PopularDBCallback() {
            @Override
            public void getPopularList(List<CategoryModel> categoryModels) {
                mCategoryModels = categoryModels;
                mViewModel.showPopularModels();
            }

            @Override
            public void getRecentJob(List<RecentJobModel> recentJobModels) {

            }
        });
    }

    private void loadBeautyandLifestyle() {
        mDBhandler.getBeautyandlifestyleList(new PopularDBCallback() {
            @Override
            public void getPopularList(List<CategoryModel> categoryModels) {
                mCategoryModels = categoryModels;
                mViewModel.showPopularModels();
            }

            @Override
            public void getRecentJob(List<RecentJobModel> recentJobModels) {

            }
        });
    }

    private void loadFoodandEvent() {
        mDBhandler.getFoodandEventList(new PopularDBCallback() {
            @Override
            public void getPopularList(List<CategoryModel> categoryModels) {
                mCategoryModels = categoryModels;
                mViewModel.showPopularModels();
            }

            @Override
            public void getRecentJob(List<RecentJobModel> recentJobModels) {

            }
        });
    }

    private void loadAutomobile() {
        mDBhandler.getAutomobileList(new PopularDBCallback() {
            @Override
            public void getPopularList(List<CategoryModel> categoryModels) {
                mCategoryModels = categoryModels;
                mViewModel.showPopularModels();
            }

            @Override
            public void getRecentJob(List<RecentJobModel> recentJobModels) {

            }
        });
    }

    private void loadTechnology() {
        mDBhandler.getTechnologyList(new PopularDBCallback() {
            @Override
            public void getPopularList(List<CategoryModel> categoryModels) {
                mCategoryModels = categoryModels;
                mViewModel.showPopularModels();
            }

            @Override
            public void getRecentJob(List<RecentJobModel> recentJobModels) {

            }
        });
    }

    private void loadCleaning() {
        mDBhandler.getCleaningList(new PopularDBCallback() {
            @Override
            public void getPopularList(List<CategoryModel> categoryModels) {
                mCategoryModels = categoryModels;
                mViewModel.showPopularModels();
            }
            @Override
            public void getRecentJob(List<RecentJobModel> recentJobModels) {

            }
        });
    }

    private void loadHandyandSkilled() {
        mDBhandler.getHandlyandSkilledList(new PopularDBCallback() {
            @Override
            public void getPopularList(List<CategoryModel> categoryModels) {
                mCategoryModels = categoryModels;
                mViewModel.showPopularModels();
            }
            @Override
            public void getRecentJob(List<RecentJobModel> recentJobModels) {
            }
        });
    }
    private void loadOutdoorList() {
        mDBhandler.getOutdoorList(new PopularDBCallback() {
            @Override
            public void getPopularList(List<CategoryModel> categoryModels) {
                mCategoryModels = categoryModels;
                mViewModel.showPopularModels();
            }
            @Override
            public void getRecentJob(List<RecentJobModel> recentJobModels) {
            }
        });
    }
    private void loadPopularList() {
        mDBhandler.getPopularModelList(new PopularDBCallback() {
            @Override
            public void getPopularList(List<CategoryModel> categoryModels) {
                mCategoryModels = categoryModels;
                mViewModel.showPopularModels();
            }

            @Override
            public void getRecentJob(List<RecentJobModel> recentJobModels) {

            }
        });
    }


    public int getPopularModelsListSize() {
        return mCategoryModels.size();
    }

    public int getPopularItemIVId(int position) {
        return mCategoryModels.get(position).getmPopularPicId();
    }

    public String getPopularItemName(int position) {
        return mCategoryModels.get(position).getmPopularName();
    }



    private void loadRecentJob() {
        mDBhandler.getRecentJobList(new PopularDBCallback() {
            @Override
            public void getPopularList(List<CategoryModel> categoryModels) {

            }

            @Override
            public void getRecentJob(List<RecentJobModel> recentJobModels) {
                mRecentJobList = recentJobModels;
                mViewModel.showRecentJobs();
            }
        });
    }

    public int getTotalRecentJob() {
        return mRecentJobList.size();
    }

    public int getRecentJobPicId(int position) {
        return mRecentJobList.get(position).getmPicId();
    }

    public String getRecentJobCurrency(int position) {
        return mRecentJobList.get(position).getmCurrency();
    }

    public String  getRecentJobTitle(int position) {
        return mRecentJobList.get(position).getmTitle();
    }

    public String getRecentJobTime(int position) {
        return mRecentJobList.get(position).getmTime();
    }

    public void categoryItemClick(int layoutPosition) {
        mViewModel.openTaskActivity();
    }
}
