package com.biswajitbanik.Diem.MyProject.ViewModel;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.biswajitbanik.Diem.MyProject.Presenter.MyProjectPreseneter;
import com.biswajitbanik.Diem.MyProject.Repository.MyProjectDBHandler;
import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.FragmentMyProject2Binding;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProjectFragment extends Fragment implements MyProjectViewModel {
    private FragmentMyProject2Binding mBinding;
    private MyProjectPreseneter mPresenter;
    private int mIndex;

    public MyProjectFragment() {
        // Required empty public constructor
    }

    public void initFragment(int index){
         mIndex = index;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_project2, container, false);
        mPresenter = new MyProjectPreseneter(this,new MyProjectDBHandler(),mIndex);

        return mBinding.getRoot();
    }

    @Override
    public void showList() {
        MyProjectAdapter adapter = new MyProjectAdapter();
        mBinding.myProjectRecycler.setAdapter(adapter);
        mBinding.myProjectRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));


    }


    public class MyProjectOpenViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView titleTv,typeTv,offerTv,priceTv,postedTimeTv,viewDetailTV;
        public MyProjectOpenViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.my_project_iv);
            titleTv = itemView.findViewById(R.id.my_project_title_tv);
            typeTv = itemView.findViewById(R.id.my_project_type_tv);
            offerTv = itemView.findViewById(R.id.offer_tv);
            priceTv = itemView.findViewById(R.id.price_tv);
            postedTimeTv = itemView.findViewById(R.id.postedtime_tv);
            viewDetailTV = itemView.findViewById(R.id.view_detalies_tv);
            viewDetailTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mIndex==0)
                    startActivity(new Intent(getActivity(),OpenDetailActivity.class));
                    else
                        startActivity(new Intent(getActivity(),MyProjectOtherDetailActivity.class));
                }
            });
        }
    }


    public class MyProjectOtherViewHolder extends RecyclerView.ViewHolder{

        TextView titleTv,typeTv,offerTv,priceTv,postedTimeTv,viewDetailTV,subjectTv,dayOfMonthTv,monthTv,dayNameTv;


        public MyProjectOtherViewHolder(View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.my_project_title_tv);
            typeTv = itemView.findViewById(R.id.my_project_type_tv);
            offerTv = itemView.findViewById(R.id.offer_tv);
            priceTv = itemView.findViewById(R.id.price_tv);
            postedTimeTv = itemView.findViewById(R.id.postedtime_tv);
            viewDetailTV = itemView.findViewById(R.id.view_detalies_tv);
            subjectTv = itemView.findViewById(R.id.subject_tv);
            dayOfMonthTv = itemView.findViewById(R.id.day_of_month_tv);
            monthTv = itemView.findViewById(R.id.month_tv);
            dayNameTv = itemView.findViewById(R.id.day_name_tv);
        }
    }

    public class MyProjectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           LayoutInflater inflater = LayoutInflater.from(getActivity());
           View view ;
           if (viewType == 0){
               view = inflater.inflate(R.layout.row_my_project_open,parent,false);
               return new MyProjectOpenViewHolder(view);
           }else {
               view = inflater.inflate(R.layout.row_my_project_other,parent,false);
               return new MyProjectOtherViewHolder(view);
           }


        }

        @Override
        public int getItemViewType(int position) {

            return mPresenter.getItemViewType();
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            switch (holder.getItemViewType()){
                case 0:
                    MyProjectOpenViewHolder openHolder = (MyProjectOpenViewHolder) holder;
                    openHolder.titleTv.setText(mPresenter.getTitle(position));
                    openHolder.typeTv.setText(mPresenter.getTypeTV(position));
                    openHolder.offerTv.setText(mPresenter.getOffer(position));
                    openHolder.priceTv.setText(mPresenter.getPrice(position));
                    openHolder.postedTimeTv.setText(mPresenter.getPostedTime(position));
                    openHolder.imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(),mPresenter.getPicId(position)));

                    break;
                case 1:
                    MyProjectOtherViewHolder otherViewHolder = (MyProjectOtherViewHolder) holder;
                    otherViewHolder.titleTv.setText(mPresenter.getTitle(position));
                    otherViewHolder.typeTv.setText(mPresenter.getTypeTV(position));
                    otherViewHolder.offerTv.setText(mPresenter.getOffer(position));
                    otherViewHolder.priceTv.setText(mPresenter.getPrice(position));
                    otherViewHolder.subjectTv.setText(mPresenter.getSubject(position));
                    otherViewHolder.dayOfMonthTv.setText(mPresenter.getDayOfMonth(position));
                    otherViewHolder.monthTv.setText(mPresenter.getMonth(position));
                    otherViewHolder.dayNameTv.setText(mPresenter.getDayName(position));
            }

        }

        @Override
        public int getItemCount() {
            return mPresenter.getTotalModelList();
        }
    }

}
