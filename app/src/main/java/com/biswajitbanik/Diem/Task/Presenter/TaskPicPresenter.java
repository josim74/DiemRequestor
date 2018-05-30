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

            }
        });
    }

    public int countTotalPic() {
        return 7;
    }

    public Bitmap getPicBitmap(int position) {

//        if (mFiles.size()<=position)

        File file = mFiles.get(position);

        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public String getPicCount(int position) {
        return String.valueOf(position + 1);
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
