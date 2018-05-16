package com.biswajitbanik.Diem.Location.Repository;

import java.util.List;

/**
 * Created by Omar Faruq on 5/14/2018.
 */

public interface LocationCallBack {

    void getLocationList(List<Prediction> predictionList);
    void getLocationLatLong(double latitude, double longitude);

    void getErrorMsg(String msg);
}
