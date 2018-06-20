package com.biswajitbanik.Diem.Task.Presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.biswajitbanik.Diem.Task.Repository.TaskPicCallback;
import com.biswajitbanik.Diem.Task.Repository.TaskPicDBHandler;
import com.biswajitbanik.Diem.Task.ViewModel.RequestSummaryViewModel;

import java.io.File;
import java.util.List;


/**
 * Created by Omar Faruq on 5/31/2018.
 */

public class RequestSummaryPresenter {
    private RequestSummaryViewModel mViewModel;
    private TaskPicDBHandler mDBHandler;
    private List<File> mFiles;

    public RequestSummaryPresenter(RequestSummaryViewModel mViewModel, TaskPicDBHandler mDBHandler) {
        this.mViewModel = mViewModel;
        this.mDBHandler = mDBHandler;
        getListOfSelectedPic();
    }


    public void getListOfSelectedPic(){
        mDBHandler.getListFiles(new TaskPicCallback() {
            @Override
            public void getPicList(List<File> files) {
                mFiles = files;

                mViewModel.showPicRecyclerview();

            }
        });
    }


    public Bitmap getPicBitmap(int position) {
        File file = mFiles.get(position);

        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = 4;
       return BitmapFactory.decodeFile(file.getAbsolutePath(), opts);


    }


    public int countTotalPic() {
        if (mFiles.size()>6)
            return 6;
        else {
            return   mFiles.size();
        }
    }
}
