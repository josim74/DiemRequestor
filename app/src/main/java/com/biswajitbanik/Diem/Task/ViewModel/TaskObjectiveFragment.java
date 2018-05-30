package com.biswajitbanik.Diem.Task.ViewModel;


import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.biswajitbanik.Diem.Task.Repository.QuestionModel;
import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.FragmentTaskObjectiveBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskObjectiveFragment extends Fragment {
    private FragmentTaskObjectiveBinding mBinding;
    private QuestionModel mQuestionModel;
    public TaskObjectiveFragment() {
        // Required empty public constructor
    }

    public void initFragment(QuestionModel questionModel){
        mQuestionModel = questionModel;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_task_objective, container, false);
        mBinding.taskTitleTv.setText(mQuestionModel.getmTitle());
        mBinding.secondTitleTv.setText(mQuestionModel.getmQuestion());

        RadioGroup.LayoutParams rprms;

        for(int i = 0 ; i<mQuestionModel.getmObjectives().size();i++){
            RadioButton radioButton = new RadioButton(getActivity());
            radioButton.setText(mQuestionModel.getmObjectives().get(i));
           // radioButton.setId("rbtn"+i);
            rprms= new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rprms.gravity = Gravity.LEFT;
            rprms.setMarginStart(44);
            mBinding.radioGroup.addView(radioButton, rprms);
        }

        return mBinding.getRoot();
    }

}
