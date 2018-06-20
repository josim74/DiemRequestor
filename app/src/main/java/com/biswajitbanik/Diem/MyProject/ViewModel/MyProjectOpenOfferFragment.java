package com.biswajitbanik.Diem.MyProject.ViewModel;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.FragmentMyProjectOpenOfferBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProjectOpenOfferFragment extends Fragment {
    private FragmentMyProjectOpenOfferBinding mBinding;

    public MyProjectOpenOfferFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_project_open_offer, container, false);
        OpenOfferAdapter adapter = new OpenOfferAdapter();
        mBinding.openOfferRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.openOfferRecycler.setAdapter(adapter);
        return mBinding.getRoot();
    }


    public class OpenOfferViewHolder extends RecyclerView.ViewHolder{

        public OpenOfferViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(),JobberOfferDetailActivity.class));
                }
            });
        }
    }


    public class OpenOfferAdapter extends RecyclerView.Adapter<OpenOfferViewHolder>{

        @Override
        public OpenOfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity())
                    .inflate(R.layout.row_my_project_offer,parent,false);
            return new OpenOfferViewHolder(view);
        }

        @Override
        public void onBindViewHolder(OpenOfferViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }

}
