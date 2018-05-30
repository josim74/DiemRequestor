package com.biswajitbanik.Diem.MyProject.Repository;

import com.biswajitbanik.Diem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Omar Faruq on 5/19/2018.
 */

public class MyProjectDBHandler {


    public void getOpenProjectList(MyProjectDBCallback callback) {

        List<MyProjectModel> models = getDummyOpenProject();
        callback.getMyProjectList(models);
    }

    private List<MyProjectModel> getDummyOpenProject() {
        List<MyProjectModel> models = new ArrayList<>();
        MyProjectModel model = new MyProjectModel(R.drawable.lawncare,
                "1000 sf yard needs mowing preferably this Sunday",
                "LAWNCARE & GARDENING",
                "3 offers", "$20",
                "Posted 3 days ago");
        models.add(model);
        model = new MyProjectModel(R.drawable.carcleaning,
                "Our backyard sprinklers aren't working properly",
                "ASSEMBLY",
                "0 offers", "$20",
                "Posted 2 days ago" );
        models.add(model);
        model = new MyProjectModel(R.drawable.carrepair,
                "Our backyard sprinklers aren't working properly",
                "REPAIR & MAINTENANCE",
                "0 offers", "$20",
                "Posted 2 days ago" );
        models.add(model);
        model = new MyProjectModel(R.drawable.fitness,
                "Our backyard sprinklers aren't working properly",
                "REPAIR & MAINTENANCE",
                "0 offers", "$20",
                "Posted 2 days ago" );
        models.add(model);
        model = new MyProjectModel(R.drawable.djmusic,
                "Our backyard sprinklers aren't working properly",
                "REPAIR & MAINTENANCE",
                "0 offers", "$20",
                "Posted 2 days ago" );
        models.add(model);

        return models;
    }


    public void getAssignedList(MyProjectDBCallback callback){
        List<MyProjectModel> models = getDummyAssignedList();
        callback.getMyProjectList(models);
    }

    private List<MyProjectModel> getDummyAssignedList() {
        List<MyProjectModel> models = new ArrayList<>();

        MyProjectModel model = new MyProjectModel(R.drawable.uxuidesign,
                "1000 sf yard needs mowing preferably this Sunday",
                "LAWNCARE & GARDENING",
                "Assigned 25 mins ago", "$20",
                "25 Jan Wed");
        model.setmHeadline("Due");
        models.add(model);


        return models;
    }

    public void getCompletedList(MyProjectDBCallback callback){
        List<MyProjectModel>  models = getDummyCompletedList();
        callback.getMyProjectList(models);
    }

    private List<MyProjectModel> getDummyCompletedList() {
        List<MyProjectModel> models = new ArrayList<>();

        MyProjectModel model = new MyProjectModel(R.drawable.uxuidesign,
                "1000 sf yard needs mowing preferably this Sunday",
                "LAWNCARE & GARDENING",
                "Paid", "$20",
                "25 Jan Wed");
        model.setmHeadline("Completed on");
        models.add(model);

         model = new MyProjectModel(R.drawable.uxuidesign,
                "1000 sf yard needs mowing preferably this Sunday",
                "LAWNCARE & GARDENING",
                "Paid", "$20",
                "20 Jan Wed");
        model.setmHeadline("Completed on");
        models.add(model);


        return models;
    }

    public void getUnfulifedList(MyProjectDBCallback callback){
        List<MyProjectModel>  models = getDummyUnfulifedList();
        callback.getMyProjectList(models);
    }

    private List<MyProjectModel> getDummyUnfulifedList() {
        List<MyProjectModel> models = new ArrayList<>();

        MyProjectModel model = new MyProjectModel(R.drawable.uxuidesign,
                "1000 sf yard needs mowing preferably this Sunday",
                "LAWNCARE & GARDENING",
                "Cancelled by you", "",
                "25 Jan Wed");
        model.setmHeadline("Cancelled on");
        models.add(model);


        return models;
    }

}
