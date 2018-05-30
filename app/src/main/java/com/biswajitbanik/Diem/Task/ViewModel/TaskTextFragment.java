package com.biswajitbanik.Diem.Task.ViewModel;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biswajitbanik.Diem.Task.Repository.QuestionModel;
import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.FragmentTextTaskBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskTextFragment extends Fragment {
    private QuestionModel mQuestionModel;
    private FragmentTextTaskBinding mBinding;

    public TaskTextFragment() {
        // Required empty public constructor
    }

    public void initFragment(QuestionModel questionModel){
        mQuestionModel = questionModel;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_text_task, container, false);
        mBinding.taskTitleTv.setText(mQuestionModel.getmTitle());
        mBinding.secondTitleTv.setText(mQuestionModel.getmQuestion());
        mBinding.exampleTv.setText(mQuestionModel.getmExample());
        mBinding.inputCountTv.setText("0/"+mQuestionModel.getmTotalCharInAns());

        mBinding.taskInputEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

               int textCount = s.length();
                if (textCount<=mQuestionModel.getmTotalCharInAns())
                mBinding.inputCountTv.setText(textCount+"/"+mQuestionModel.getmTotalCharInAns());
                else {
                   mBinding.taskInputEt.setText( s.toString().substring(0,s.length()-1));
                   mBinding.taskInputEt.setSelection(s.length()-1);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        return mBinding.getRoot();
    }

}
