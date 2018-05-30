package com.biswajitbanik.Diem.Task.Presenter;

import android.support.v4.app.Fragment;
import android.view.View;

import com.biswajitbanik.Diem.Task.Repository.QuestionDBCallback;
import com.biswajitbanik.Diem.Task.Repository.QuestionDBHandler;
import com.biswajitbanik.Diem.Task.Repository.QuestionModel;
import com.biswajitbanik.Diem.Task.ViewModel.TaskFlowViewModel;
import com.biswajitbanik.Diem.Task.ViewModel.TaskLocationFragment;
import com.biswajitbanik.Diem.Task.ViewModel.TaskObjectiveFragment;
import com.biswajitbanik.Diem.Task.ViewModel.TaskPicFragment;
import com.biswajitbanik.Diem.Task.ViewModel.TaskTextFragment;

import java.util.List;

/**
 * Created by Omar Faruq on 5/22/2018.
 */

public class TaskFlowPresenter {
    private TaskFlowViewModel mViewModel;
    private QuestionDBHandler mDBHandler;
    private List<QuestionModel> mQuestionModels;

    public TaskFlowPresenter(TaskFlowViewModel mViewModel, QuestionDBHandler mDBHandler) {
        this.mViewModel = mViewModel;
        this.mDBHandler = mDBHandler;
        getQuestions();

    }

    private void getQuestions(){
        mDBHandler.getQuestions(new QuestionDBCallback() {
            @Override
            public void getQuestion(List<QuestionModel> questionModels) {
                mQuestionModels = questionModels;
            }
        });
    }


    public int getTotalQuestion() {
        return mQuestionModels.size()+1;
    }

    public Fragment getFragment(int position) {

        if (position == mQuestionModels.size()){
            TaskLocationFragment taskLocationFragment = new TaskLocationFragment();
//            mViewModel.setNextButtonVisibility(View.GONE);
          return taskLocationFragment;
        }else {
//            mViewModel.setNextButtonVisibility(View.VISIBLE);
        }

            QuestionModel question=mQuestionModels.get(position);

         if (question.getmObjectives() == null && !question.isHasPicture()){
           TaskTextFragment taskTextFragment= new TaskTextFragment();
           taskTextFragment.initFragment(question);
           return taskTextFragment;
         }else if(question.getmObjectives() != null){
             TaskObjectiveFragment objectiveFragment = new TaskObjectiveFragment();
             objectiveFragment.initFragment(question);
             return objectiveFragment;
         }else {
             TaskPicFragment taskPicFragment =new TaskPicFragment();
             taskPicFragment.initFragment(question);
             return taskPicFragment;
         }





    }

    public void selectedPage(int position) {
        if (position == mQuestionModels.size()){

            mViewModel.setNextButtonVisibility(View.GONE);

        }else {
            mViewModel.setNextButtonVisibility(View.VISIBLE);
        }
    }
}
