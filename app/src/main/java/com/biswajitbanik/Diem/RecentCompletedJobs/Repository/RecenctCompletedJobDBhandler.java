package com.biswajitbanik.Diem.RecentCompletedJobs.Repository;

import com.biswajitbanik.Diem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Omar Faruq on 6/3/2018.
 */

public class RecenctCompletedJobDBhandler {


    public void getRecentCompltedJobImages(RecentCompletedJobDBCallback callback){
        List<Integer> images = new ArrayList<>();

        images.add(R.drawable.lawncare);
        images.add(R.drawable.snow_removal);
        images.add(R.drawable.moving);
        images.add(R.drawable.painting);

        callback.getListOfImages(images);
    }
}
