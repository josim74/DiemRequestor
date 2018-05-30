package com.biswajitbanik.Diem.MyProject.Presenter;

import com.biswajitbanik.Diem.MyProject.Repository.MyProjectDBCallback;
import com.biswajitbanik.Diem.MyProject.Repository.MyProjectDBHandler;
import com.biswajitbanik.Diem.MyProject.Repository.MyProjectModel;
import com.biswajitbanik.Diem.MyProject.ViewModel.MyProjectViewModel;

import java.util.List;



public class MyProjectPreseneter {
    private MyProjectViewModel mViewModel;
    private MyProjectDBHandler mDBHandler;
    private List<MyProjectModel> myProjectModelList;
    private int mIndex;


    public MyProjectPreseneter(MyProjectViewModel mViewModel, MyProjectDBHandler mDBHandler, int mIndex) {
        this.mViewModel = mViewModel;
        this.mDBHandler = mDBHandler;
        this.mIndex = mIndex;
        switch (mIndex){
            case 0:
                getOpenProject();
                break;
            case 1:
                getAssigned();
                break;
            case 2:
                getCompletedProject();
                break;
            case 3:
                getunfulfilledProject();
                break;


        }
    }

    private void getAssigned() {
        mDBHandler.getAssignedList(new MyProjectDBCallback() {
            @Override
            public void getMyProjectList(List<MyProjectModel> myProjectModels) {
                myProjectModelList = myProjectModels;
                mViewModel.showList();
            }

            @Override
            public void getErrorMsg(String msg) {

            }
        });
    }

    private void getOpenProject() {
        mDBHandler.getOpenProjectList(new MyProjectDBCallback() {
            @Override
            public void getMyProjectList(List<MyProjectModel> myProjectModels) {
                mDBHandler.getOpenProjectList(new MyProjectDBCallback() {
                    @Override
                    public void getMyProjectList(List<MyProjectModel> myProjectModels) {
                        myProjectModelList = myProjectModels;
                        mViewModel.showList();
                    }

                    @Override
                    public void getErrorMsg(String msg) {

                    }
                });
            }

            @Override
            public void getErrorMsg(String msg) {

            }
        });
    }
    private void getCompletedProject(){
        mDBHandler.getCompletedList(new MyProjectDBCallback() {
            @Override
            public void getMyProjectList(List<MyProjectModel> myProjectModels) {
                myProjectModelList = myProjectModels;
                mViewModel.showList();
            }

            @Override
            public void getErrorMsg(String msg) {

            }
        });
    }

    private void getunfulfilledProject(){
        mDBHandler.getUnfulifedList(new MyProjectDBCallback() {
            @Override
            public void getMyProjectList(List<MyProjectModel> myProjectModels) {
                myProjectModelList = myProjectModels;
                mViewModel.showList();
            }

            @Override
            public void getErrorMsg(String msg) {

            }
        });
    }

    public int getItemViewType() {

        if (mIndex == 0)
            return 0;
        else return 1;
    }

    public String getTitle(int position) {
        return myProjectModelList.get(position).getmTitle();
    }

    public String getTypeTV(int position) {
        return myProjectModelList.get(position).getmType();
    }

    public String getOffer(int position) {
        return myProjectModelList.get(position).getmOffer();
    }

    public String getPrice(int position) {
        return myProjectModelList.get(position).getmPrice();
    }

    public String getPostedTime(int position) {
        return myProjectModelList.get(position).getmPostedDate();
    }

    public int getTotalModelList() {
        return myProjectModelList.size();
    }

    public int getPicId(int position) {
        return myProjectModelList.get(position).getmImageId();
    }

    public String  getSubject(int position) {
        return myProjectModelList.get(position).getmHeadline();
    }

    public String getDayOfMonth(int position) {

        String date =  myProjectModelList.get(position).getmPostedDate();
        return date.split(" ")[0];
    }

    public String getMonth(int position) {


        String date =  myProjectModelList.get(position).getmPostedDate();
        return date.split(" ")[1];
    }

    public String getDayName(int position) {
        String date =  myProjectModelList.get(position).getmPostedDate();
        return date.split(" ")[2];
    }
}
