package com.biswajitbanik.Diem;

import com.biswajitbanik.Diem.Location.Repository.LocationDetailResponse;
import com.biswajitbanik.Diem.Location.Repository.LocationResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Omar Faruq on 5/14/2018.
 */

public interface ApiEndPoint {
    @GET("autocomplete/json")
    Call<LocationResponse> getLocationList(@Query("input") String input, @Query("key") String key);

    @GET("details/json")
    Call<LocationDetailResponse> getLocationDetail(@Query("placeid") String placeId,@Query("key") String key);
}
