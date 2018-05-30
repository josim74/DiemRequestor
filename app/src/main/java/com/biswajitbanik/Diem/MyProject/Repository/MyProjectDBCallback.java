package com.biswajitbanik.Diem.MyProject.Repository;

import java.util.List;



public interface MyProjectDBCallback {
    void getMyProjectList(List<MyProjectModel> myProjectModels);
    void getErrorMsg(String msg);
}
