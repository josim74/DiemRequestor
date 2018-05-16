package com.biswajitbanik.Diem.Location.Repository;

import android.content.Context;

import com.biswajitbanik.Diem.ApiEndPoint;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Omar Faruq on 5/14/2018.
 */

public class LocationDBHandler {
    private static final String BASE_URL="https://maps.googleapis.com/maps/api/place/";
    private static final String API_KEY="AIzaSyAuHdQJOZkFEeyBUuaYF6P7b1ksCsd7rC0";
    private ApiEndPoint mApiEndPoint;
    private Context mContext;

    public LocationDBHandler(Context mContext) {
        this.mContext = mContext;
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApiEndPoint=retrofit.create(ApiEndPoint.class);
    }

    public void getLocationList(String locationName, final LocationCallBack callBack){

        Call<LocationResponse> locationResponseCall =mApiEndPoint.getLocationList(locationName,API_KEY);
        locationResponseCall.enqueue(new Callback<LocationResponse>() {
            @Override
            public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {
                if (response.isSuccessful()){
                    callBack.getLocationList(response.body().getPredictions());
                }
            }

            @Override
            public void onFailure(Call<LocationResponse> call, Throwable t) {
                callBack.getErrorMsg(t.getMessage());
            }
        });
    }

    public void getLatLongFromPlaceId(String placeId, final LocationCallBack callBack){
        Call<LocationDetailResponse> locationDetailResponseCall= mApiEndPoint.getLocationDetail(placeId,API_KEY);
        locationDetailResponseCall.enqueue(new Callback<LocationDetailResponse>() {
            @Override
            public void onResponse(Call<LocationDetailResponse> call, Response<LocationDetailResponse> response) {
                if (response.isSuccessful()){
                  Geometry geometry=   response.body().getResult().getGeometry();
                  callBack.getLocationLatLong(geometry.getLocation().getLat(),geometry.getLocation().getLng());
                }
            }

            @Override
            public void onFailure(Call<LocationDetailResponse> call, Throwable t) {
                callBack.getErrorMsg(t.getMessage());
            }
        });
    }
}
