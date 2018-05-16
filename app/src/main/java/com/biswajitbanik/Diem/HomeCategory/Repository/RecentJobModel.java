package com.biswajitbanik.Diem.HomeCategory.Repository;

/**
 * Created by Omar Faruq on 5/16/2018.
 */

public class RecentJobModel {
    private String mTitle;
    private  String mCurrency;
    private String mTime;
    private int mPicId;

    public RecentJobModel(String mTitle, String mCurrency, String mTime, int mPicId) {
        this.mTitle = mTitle;
        this.mCurrency = mCurrency;
        this.mTime = mTime;
        this.mPicId = mPicId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmCurrency() {
        return mCurrency;
    }

    public void setmCurrency(String mCurrency) {
        this.mCurrency = mCurrency;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public int getmPicId() {
        return mPicId;
    }

    public void setmPicId(int mPicId) {
        this.mPicId = mPicId;
    }
}
