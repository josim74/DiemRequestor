package com.biswajitbanik.Diem.Popular.Repository;

/**
 * Created by Omar Faruq on 5/15/2018.
 */

public class PopularModel {

    private int mPopularPicId;
    private  String mPopularName;

    public PopularModel(int mPopularPicId, String mPopularName) {
        this.mPopularPicId = mPopularPicId;
        this.mPopularName = mPopularName;
    }

    public int getmPopularPicId() {
        return mPopularPicId;
    }

    public void setmPopularPicId(int mPopularPicId) {
        this.mPopularPicId = mPopularPicId;
    }

    public String getmPopularName() {
        return mPopularName;
    }

    public void setmPopularName(String mPopularName) {
        this.mPopularName = mPopularName;
    }
}
