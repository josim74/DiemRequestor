package com.biswajitbanik.Diem.Task.Repository;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Omar Faruq on 5/29/2018.
 */

public class TaskPicDBHandler {
//    private Context mContext;

    public TaskPicDBHandler(/*Context mContext*/) {
//        this.mContext = mContext;


    }







    public void getListFiles(TaskPicCallback callback) {
        File parentDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath()+"/Camera/");

        ArrayList<File> inFiles = new ArrayList<File>();
        File[] files = parentDir.listFiles();
        for (File file : files) {

//            if (file.isDirectory()) {
//                inFiles.addAll(getListFiles(file));
//            } else {
//                if(file.getName().endsWith(".csv")){
//                    inFiles.add(file);
//                }
//            }

            inFiles.add(file);
        }
       callback.getPicList(inFiles);
    }

}
