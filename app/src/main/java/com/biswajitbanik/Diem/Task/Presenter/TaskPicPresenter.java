package com.biswajitbanik.Diem.Task.Presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.biswajitbanik.Diem.Task.Repository.TaskPicCallback;
import com.biswajitbanik.Diem.Task.Repository.TaskPicDBHandler;
import com.biswajitbanik.Diem.Task.ViewModel.TaskPicViewModel;

import java.io.File;
import java.util.List;

/**
 * Created by Omar Faruq on 5/29/2018.
 */

public class TaskPicPresenter {
    private TaskPicViewModel mViewModel;
    private TaskPicDBHandler mDBHandler;

    private List<File> mFiles;

    public TaskPicPresenter(TaskPicViewModel mViewModel, TaskPicDBHandler mDBHandler) {
        this.mViewModel = mViewModel;
        this.mDBHandler = mDBHandler;

        mViewModel.disableNextButton();
    }


    public void onGallaryBtnClick() {
        mDBHandler.getListFiles(new TaskPicCallback() {
            @Override
            public void getPicList(List<File> files) {
                mFiles = files;

                mViewModel.showPicRecyclerview();
                mViewModel.enableNextButton();
                mViewModel.hidePhotoPickButton();
            }
        });

    }

    public int countTotalPic() {

        if (mFiles.size()>7)
        return 7;
        else {
          return   mFiles.size();
        }
    }

    public Bitmap getPicBitmap(int position) {

//        if (mFiles.size()<=position)

        File file = mFiles.get(position);

        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = 8;
        return BitmapFactory.decodeFile(file.getAbsolutePath(), opts);
    }

    public String getPicCount(int position) {
        return String.valueOf(position);
    }

    public int getPicItemViewType(int position) {
        if (position==0){
            return 0;
        }else return 1;


    }

    public void onNextButtonClick() {
        mViewModel.exit();
    }
}

