package com.biswajitbanik.Diem.Popular.ViewModel;

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

import com.biswajitbanik.Diem.Popular.Presenter.PopularPresenter;
import com.biswajitbanik.Diem.Popular.Repository.PopularDBHandler;
import com.codility.introsilder.R;
import com.codility.introsilder.databinding.Fragment1Binding;

public class PopularFragment extends Fragment implements PopularViewModel {

    private Fragment1Binding mBinding;
    private PopularPresenter mPresenter;

    public PopularFragment() {
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
        mPresenter = new PopularPresenter(this, new PopularDBHandler());


        return mBinding.getRoot();
    }

    @Override
    public void showPopularModels() {
        PopularAdapter adapter = new PopularAdapter();
        mBinding.popularRecycler.setAdapter(adapter);
        mBinding.popularRecycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
    }


    public class PopularViewHolder extends RecyclerView.ViewHolder {
        private ImageView popularItemIV;
        private TextView popularItemNameTV;


        public PopularViewHolder(View itemView) {
            super(itemView);
            popularItemIV = itemView.findViewById(R.id.popular_recycler_iv);
            popularItemNameTV= itemView.findViewById(R.id.popular_recycler_item_name_tv);
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


}