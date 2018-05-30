package com.biswajitbanik.Diem.HomeCategory.ViewModel;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.biswajitbanik.Diem.HomeCategory.Presenter.PopularPresenter;
import com.biswajitbanik.Diem.HomeCategory.Repository.PopularDBHandler;
import com.biswajitbanik.Diem.Task.ViewModel.TaskActivity;
import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.Fragment1Binding;

public class CategoryFragment extends Fragment implements PopularViewModel {

    private Fragment1Binding mBinding;
    private PopularPresenter mPresenter;
    private int mCategoryIndex;

    public void initFragment(int categoryIndex){
        mCategoryIndex = categoryIndex;
    }

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_1, container, false);
        mPresenter = new PopularPresenter(this, new PopularDBHandler(),mCategoryIndex);




        return mBinding.getRoot();
    }

    @Override
    public void showPopularModels() {
        PopularAdapter adapter = new PopularAdapter();
        mBinding.popularRecycler.setAdapter(adapter);
        mBinding.popularRecycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
    }

    @Override
    public void showRecentJobs() {
        RecentJobAdapter adapter =new RecentJobAdapter();
        mBinding.recentJobRecycler.setAdapter(adapter);
        mBinding.recentJobRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL,
                true));
    }

    @Override
    public void openTaskActivity() {

        startActivity(new Intent(getActivity(),TaskActivity.class));
    }


    public class PopularViewHolder extends RecyclerView.ViewHolder {
        private ImageView popularItemIV;
        private TextView popularItemNameTV;


        public PopularViewHolder(View itemView) {
            super(itemView);
            popularItemIV = itemView.findViewById(R.id.popular_recycler_iv);
            popularItemNameTV= itemView.findViewById(R.id.popular_recycler_item_name_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.categoryItemClick(getLayoutPosition());
                }
            });
        }


    }


    public class PopularAdapter extends RecyclerView.Adapter<PopularViewHolder> {

        @Override
        public PopularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.row_popular_item, parent, false);

            return new PopularViewHolder(view);
        }

        @Override
        public void onBindViewHolder(PopularViewHolder holder, int position) {
            holder.popularItemIV.setImageDrawable(ContextCompat.getDrawable(getActivity(),
                    mPresenter.getPopularItemIVId(position)));

            holder.popularItemNameTV.setText(mPresenter.getPopularItemName(position));

        }

        @Override
        public int getItemCount() {
            return mPresenter.getPopularModelsListSize();
        }
    }


     public  class  RecentJobViewHolder extends RecyclerView.ViewHolder{
        private TextView titleTV, currencyTV, timeTv;
        private ImageView imageView;
         public RecentJobViewHolder(View itemView) {
             super(itemView);
             titleTV = itemView.findViewById(R.id.title_tv);
             currencyTV =itemView.findViewById(R.id.currency_tv);
             timeTv=itemView.findViewById(R.id.time_tv);

             imageView = itemView.findViewById(R.id.recent_job_image_view);
         }


     }


     public class RecentJobAdapter extends RecyclerView.Adapter<RecentJobViewHolder>{

         @Override
         public RecentJobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(getActivity())
                    .inflate(R.layout.recent_job_row,parent,false);
             return new RecentJobViewHolder(view);
         }

         @Override
         public void onBindViewHolder(RecentJobViewHolder holder, int position) {
            holder.imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(),mPresenter.getRecentJobPicId(position)));
            holder.currencyTV.setText(mPresenter.getRecentJobCurrency(position));
            holder.titleTV.setText(mPresenter.getRecentJobTitle(position));
            holder.timeTv.setText(mPresenter.getRecentJobTime(position));
         }

         @Override
         public int getItemCount() {
             return mPresenter.getTotalRecentJob();
         }
     }


}