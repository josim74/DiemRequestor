package com.biswajitbanik.Diem;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biswajitbanik.Diem.databinding.FragmentJobberAboutBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class JobberAboutFragment extends Fragment {


    public JobberAboutFragment() {
        // Required empty public constructor
    }

    private FragmentJobberAboutBinding mBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_jobber_about, container, false);
        mBinding.workRecyclerView.setAdapter(new JobberWorkAdapter());
        mBinding.workRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true));
        return mBinding.getRoot();

    }



    public class JobberWorkViewHolder extends RecyclerView.ViewHolder{

        public JobberWorkViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class JobberWorkAdapter extends RecyclerView.Adapter<JobberWorkViewHolder>{

        @Override
        public JobberWorkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(getActivity())
                   .inflate(R.layout.row_jobber_work,parent,false);
            return new JobberWorkViewHolder(view) ;
        }

        @Override
        public void onBindViewHolder(JobberWorkViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }

}
