package com.biswajitbanik.Diem.Task.ViewModel;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.FragmentPicPickerDialogBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PicPickerDialogFragment extends BottomSheetDialogFragment {
    private FragmentPicPickerDialogBinding mBinding;

    public PicPickerDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_pic_picker_dialog, container, false);

        return mBinding.getRoot();
    }

}
