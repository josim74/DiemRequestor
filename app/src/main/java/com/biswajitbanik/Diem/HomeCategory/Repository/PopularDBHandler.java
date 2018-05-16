package com.biswajitbanik.Diem.HomeCategory.Repository;

import com.codility.introsilder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Omar Faruq on 5/15/2018.
 */

public class PopularDBHandler {



    public void getPopularModelList(PopularDBCallback callback){
        List<CategoryModel> models = generateDummyModels();
        callback.getPopularList(models);
    }

    private List<CategoryModel> generateDummyModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.lawncare,"Lawncare");
        categoryModels.add(model);

         model = new CategoryModel(R.drawable.snow_removal,"Snow Removal");
        categoryModels.add(model);
        categoryModels.add(model);
        categoryModels.add(model);
        categoryModels.add(model);
        categoryModels.add(model);
        categoryModels.add(model);
        categoryModels.add(model);



        return categoryModels;
    }

    public void getOutdoorList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummyOutDoorModels();
        callback.getPopularList(models);
    }

    private List<CategoryModel> generateDummyOutDoorModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.lawncare,"Lawncare");
        categoryModels.add(model);

        model = new CategoryModel(R.drawable.snow_removal,"Snow Removal");
        categoryModels.add(model);
        categoryModels.add(model);
        categoryModels.add(model);
        categoryModels.add(model);
        categoryModels.add(model);
        categoryModels.add(model);
        categoryModels.add(model);



        return categoryModels;
    }

    public void getRecentJobList(PopularDBCallback callback){
        List<RecentJobModel> recentJobModels=generateDummyRecentJobModels();
        callback.getRecentJob(recentJobModels);

    }

    private List<RecentJobModel> generateDummyRecentJobModels() {
        List<RecentJobModel> recentJobModels = new ArrayList<>();
        RecentJobModel model = new RecentJobModel("Lawn Mowing","$10","20 min ago",R.drawable.lawncare);
        recentJobModels.add(model);
        recentJobModels.add(model);
        recentJobModels.add(model);
        recentJobModels.add(model);
        recentJobModels.add(model);


        return recentJobModels;
    }


}
