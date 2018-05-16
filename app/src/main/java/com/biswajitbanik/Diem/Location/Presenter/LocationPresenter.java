package com.biswajitbanik.Diem.Location.Presenter;

import android.util.Log;

import com.biswajitbanik.Diem.Location.Repository.LocationCallBack;
import com.biswajitbanik.Diem.Location.Repository.LocationDBHandler;
import com.biswajitbanik.Diem.Location.Repository.Prediction;
import com.biswajitbanik.Diem.Location.ViewModel.LocationViewModel;

import java.util.List;

/**
 * Created by Omar Faruq on 5/14/2018.
 */

public class LocationPresenter {

    private LocationViewModel mViewModel;
    private LocationDBHandler mDBHandler;
    private List<Prediction> mPredictions;
    private boolean mIsSearchItemClick;
    private Prediction mSelectedPrediction;

    public LocationPresenter(LocationViewModel mViewModel, LocationDBHandler mDBHandler) {
        this.mViewModel = mViewModel;
        this.mDBHandler = mDBHandler;
    }

    public void getLocationList(String locationName){

        if (mIsSearchItemClick)
            return;

        mViewModel.setSearchBtnTxt("Search");

        if (locationName.length()<1){
            if (mPredictions!=null){
                mPredictions.clear();
                mViewModel.refreshList();
                mViewModel.hideList();

            }}else{

                mDBHandler.getLocationList(locationName, new LocationCallBack() {
                    @Override
                    public void getLocationList(List<Prediction> predictionList) {
                        if (mPredictions != null){
                            mPredictions.clear();
                            mPredictions.addAll(predictionList);
                        }else {
                            mPredictions = predictionList;
                        }
                        mViewModel.showList();
                        mViewModel.refreshList();
                    }

                    @Override
                    public void getLocationLatLong(double latitude, double longitude) {

                    }

                    @Override
                    public void getErrorMsg(String msg) {

                    }
                });
            }







    }

    public int getLocationListSize() {
        Log.i("prediction_size", mPredictions.size()+"");
        return mPredictions.size();

    }

    public String getPrimaryLocationText(int position) {
        return mPredictions.get(position).getStructuredFormatting().getMainText();
    }

    public String getSecondaryLocationText(int position) {
        return mPredictions.get(position).getStructuredFormatting().getSecondaryText();

    }

    public void onSearchItemClick(int position) {
       // mViewModel.setSearchBtnTxt("Search");
        mIsSearchItemClick=true;
        mViewModel.hideList();
        mSelectedPrediction=mPredictions.get(position);
        mViewModel.setSearchEditText(mSelectedPrediction.getStructuredFormatting().getMainText());
        mViewModel.searchETLostFocus();
        mViewModel.hideKeypad();
    }

    public void onTouchSearchET() {
        mIsSearchItemClick=false;
    }

    public void onSearchBtnClick() {
        if(!mViewModel.getSearchBtnText().equals("Confirm")){

            mDBHandler.getLatLongFromPlaceId(mSelectedPrediction.getPlaceId(), new LocationCallBack() {
                @Override
                public void getLocationList(List<Prediction> predictionList) {

                }

                @Override
                public void getLocationLatLong(double latitude, double longitude) {
                    mViewModel.drawMap(latitude,longitude);
                }

                @Override
                public void getErrorMsg(String msg) {

                }
            });

            mViewModel.setSearchBtnTxt("Confirm");
        } else {
            mViewModel.openHomeActivity();
        }
    }
}
