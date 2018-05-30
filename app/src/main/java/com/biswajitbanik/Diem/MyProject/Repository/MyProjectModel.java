package com.biswajitbanik.Diem.MyProject.Repository;

/**
 * Created by Omar Faruq on 5/19/2018.
 */

public class MyProjectModel  {
    private int mImageId;
    private String  mTitle,mType,mOffer,mPrice,mPostedDate,mHeadline;


    public MyProjectModel(int mImageId, String mTitle, String mType, String mOffer, String mPrice, String mPostedDate) {
        this.mImageId = mImageId;
        this.mTitle = mTitle;
        this.mType = mType;
        this.mOffer = mOffer;
        this.mPrice = mPrice;
        this.mPostedDate = mPostedDate;
    }

    public int getmImageId() {
        return mImageId;
    }

    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmOffer() {
        return mOffer;
    }

    public void setmOffer(String mOffer) {
        this.mOffer = mOffer;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmPostedDate() {
        return mPostedDate;
    }

    public void setmPostedDate(String mPostedDate) {
        this.mPostedDate = mPostedDate;
    }

    public String getmHeadline() {
        return mHeadline;
    }

    public void setmHeadline(String mHeadline) {
        this.mHeadline = mHeadline;
    }
}
