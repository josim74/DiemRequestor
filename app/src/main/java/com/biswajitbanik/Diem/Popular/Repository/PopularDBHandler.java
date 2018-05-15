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
        popularModels.add(model);
        popularModels.add(model);
        popularModels.add(model);
        popularModels.add(model);
        popularModels.add(model);
        popularModels.add(model);



        return popularModels;
    }
}
