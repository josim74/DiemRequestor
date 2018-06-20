package com.biswajitbanik.Diem;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biswajitbanik.Diem.databinding.FragmentJobberReviewBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class JobberReviewFragment extends Fragment {


    private FragmentJobberReviewBinding mBinding;

    public JobberReviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_jobber_review, container, false);
        mBinding.jobberReviewRecyclerView.setAdapter(new JobberReviewAdapter());
        mBinding.jobberReviewRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return mBinding.getRoot();
    }


    public class JobberReviewViewHolder extends RecyclerView.ViewHolder{

        public JobberReviewViewHolder(View itemView) {
            super(itemView);
        }
    }


    public class JobberReviewAdapter extends RecyclerView.Adapter<JobberReviewViewHolder>{

        @Override
        public JobberReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity())
                    .inflate(R.layout.row_jobber_review,parent,false);
            return new JobberReviewViewHolder(view);
        }

        @Override
        public void onBindViewHolder(JobberReviewViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }

}
