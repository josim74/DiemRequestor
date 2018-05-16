package com.biswajitbanik.Diem.Popular.Repository;

import com.codility.introsilder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Omar Faruq on 5/15/2018.
 */

public class PopularDBHandler {



    public void getPopularModelList(PopularDBCallback callback){
        List<PopularModel> models = generateDummyModels();
        callback.getPopularList(models);
    }

    private List<PopularModel> generateDummyModels() {
        List<PopularModel> popularModels=new ArrayList<>();

        PopularModel model = new PopularModel(R.drawable.lawncare,"Lawncare");
        popularModels.add(model);

        model = new PopularModel(R.drawable.snow_removal,"Snow Removal");
        popularModels.add(model);

        model = new PopularModel(R.drawable.repair,"Home & Reno Repair");

        popularModels.add(model);
        model = new PopularModel(R.drawable.housecleaning,"House Cleaning");

        popularModels.add(model);
        model = new PopularModel(R.drawable.moving,"Moving");

        popularModels.add(model);
        model = new PopularModel(R.drawable.vacumming,"Vacumming");

        popularModels.add(model);
        model = new PopularModel(R.drawable.painting,"Painting");

        popularModels.add(model);
        model = new PopularModel(R.drawable.carrepair,"Car Repair");

        popularModels.add(model);



        return popularModels;
    }
}
