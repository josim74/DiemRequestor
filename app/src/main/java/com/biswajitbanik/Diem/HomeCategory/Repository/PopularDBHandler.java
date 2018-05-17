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

        List<CategoryModel> models = generateDummyHandlyandSkilledModels();
        callback.getPopularList(models);
    }
    private List<CategoryModel> generateDummyHandlyandSkilledModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.lawncare,"Home & Reno Repair");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.snow_removal,"Assembly & Installation");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.plumbing,"Plumbing");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.electrical,"Electrical & Appliance");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.hvac,"HVAC");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.deliveryservice,"Delivery Service");
        categoryModels.add(model);


        return categoryModels;
    }



    public void getCleaningList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummycleaningModels();
        callback.getPopularList(models);
    }
    private List<CategoryModel> generateDummycleaningModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.officecleaning,"Office Cleanup");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.housecleaning,"House Cleanup");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.eventcleanup,"Event Cleanup");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.wasteremoval,"Waste & Junk Removal");
        categoryModels.add(model);


        return categoryModels;
    }

    public void getTechnologyList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummyTechnologyModels();
        callback.getPopularList(models);
    }
    private List<CategoryModel> generateDummyTechnologyModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.mobilerepair,"Computer Repair");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.mobilerepair,"Mobile Repair");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.tvav,"TV & AV");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.wirelessnetworking,"Wireless & Networking");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.graphicdesign,"Graphic Design");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.uxuidesign,"UX/UI Design");
        categoryModels.add(model);


        return categoryModels;
    }

    public void getAutomobileList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummyAutomobileModels();
        callback.getPopularList(models);
    }
    private List<CategoryModel> generateDummyAutomobileModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.carcleaning,"Car Cleaning");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.carrepair,"Car Detailing");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.repair,"Maintainence & Repair");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.towingservices,"Towing Services");
        categoryModels.add(model);


        return categoryModels;
    }


    public void getFoodandEventList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummyFoodandEventModels();
        callback.getPopularList(models);
    }
    private List<CategoryModel> generateDummyFoodandEventModels() {
        List<CategoryModel> categoryModels =new ArrayList<>();

        CategoryModel model = new CategoryModel(R.drawable.cookingcatering,"Cooking & Catering");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.eventswedding,"Events & Weddings");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.djmusic,"DJ & Music");
        categoryModels.add(model);
        model = new CategoryModel(R.drawable.moving,"Photography & Video");
        categoryModels.add(model);


        return categoryModels;
    }



    public void getBeautyandlifestyleList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummyBeautyandlifestyleModels();
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

    //Education

    public void getEducationandbusinessList (PopularDBCallback callback){

        List<CategoryModel> models = generateDummyEducationandbusinessModels();
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
