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

        model = new CategoryModel(R.drawable.repair,"Home & Reno Repair");

        categoryModels.add(model);
        model = new CategoryModel(R.drawable.housecleaning,"House Cleaning");

        categoryModels.add(model);
        model = new CategoryModel(R.drawable.moving,"Moving");

        categoryModels.add(model);
        model = new CategoryModel(R.drawable.vacumming,"Vacumming");

        categoryModels.add(model);
        model = new CategoryModel(R.drawable.painting,"Painting");

        categoryModels.add(model);
        model = new CategoryModel(R.drawable.carrepair,"Car Repair");

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
        model = new CategoryModel(R.drawable.repair,"Repair & Maintenanc");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.landscapingreno,"Landscaping & Reno");
        categoryModels.add(model);
        

        return categoryModels;
    }


    public void getHandlyandSkilledList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummyOutDoorModels();
        callback.getPopularList(models);
    }
    private List<CategoryModel> generateDummyHandlyandSkilledModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.lawncare,"Home & Reno Repair");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.snow_removal,"Assembly & Installation");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.snow_removal,"Plumbing");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.landscapingreno,"Electrical & Appliance");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.landscapingreno,"HVAC");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.landscapingreno,"Delivery Service");
        categoryModels.add(model);


        return categoryModels;
    }



    public void getCleaningList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummyOutDoorModels();
        callback.getPopularList(models);
    }
    private List<CategoryModel> generateDummycleaningModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.lawncare,"Lawncare");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.snow_removal,"Snow Removal");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.repair,"Repair & Maintenanc");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.landscapingreno,"Landscaping & Reno");
        categoryModels.add(model);


        return categoryModels;
    }

    public void getTechnologyList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummyOutDoorModels();
        callback.getPopularList(models);
    }
    private List<CategoryModel> generateDummyTechnologyModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.lawncare,"Lawncare");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.snow_removal,"Snow Removal");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.repair,"Repair & Maintenanc");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.landscapingreno,"Landscaping & Reno");
        categoryModels.add(model);


        return categoryModels;
    }

    public void getAutomobileList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummyOutDoorModels();
        callback.getPopularList(models);
    }
    private List<CategoryModel> generateDummyAutomobileModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.lawncare,"Lawncare");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.snow_removal,"Snow Removal");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.repair,"Repair & Maintenanc");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.landscapingreno,"Landscaping & Reno");
        categoryModels.add(model);


        return categoryModels;
    }


    public void getFoodandEventList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummyOutDoorModels();
        callback.getPopularList(models);
    }
    private List<CategoryModel> generateDummyFoodandEventModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.lawncare,"Cooking & Catering");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.snow_removal,"Snow Removal");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.repair,"Repair & Maintenanc");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.landscapingreno,"Landscaping & Reno");
        categoryModels.add(model);


        return categoryModels;
    }



    public void getBeautyandlifestyleList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummyOutDoorModels();
        callback.getPopularList(models);
    }
    private List<CategoryModel> generateDummyBeautyandlifestyleModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.hairmakeup,"Hair & Makeup");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.nailsspa,"Nail & Spa");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.fitness,"Fitness");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.petcare,"Pet Care");
        categoryModels.add(model);


        return categoryModels;
    }


    public void getEducationandbusinessList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummyOutDoorModels();
        callback.getPopularList(models);
    }
    private List<CategoryModel> generateDummyEducationandbusinessModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.accountingtax,"Accounting & Tax");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.legalservices,"Legal Services");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.tutoring,"Tutoring");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.classeslessons,"Classes & Lessons");
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
