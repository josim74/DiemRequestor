package com.biswajitbanik.Diem.Task.ViewModel;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biswajitbanik.Diem.Task.Repository.QuestionModel;
import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.FragmentTaskPicBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskPicFragment extends Fragment {

    private FragmentTaskPicBinding mBinding;
    private QuestionModel mQuestionModel;
    public TaskPicFragment() {
        // Required empty public constructor
    }

    public void initFragment(QuestionModel questionModel){
        mQuestionModel = questionModel;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_task_pic, container, false);
        mBinding.taskTitleTv.setText(mQuestionModel.getmTitle());
        mBinding.secondTitleTv.setText(mQuestionModel.getmQuestion());
        return mBinding.getRoot();
    }

}
