package com.biswajitbanik.Diem.Task.ViewModel;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.biswajitbanik.Diem.LoginActivity;
import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.Task.Presenter.RequestSummaryPresenter;
import com.biswajitbanik.Diem.Task.Repository.TaskPicDBHandler;
import com.biswajitbanik.Diem.databinding.ActivityRequestSummaryBinding;

public class RequestSummaryActivity extends AppCompatActivity implements RequestSummaryViewModel {
    private ActivityRequestSummaryBinding mBinding;
    private RequestSummaryPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mBinding= DataBindingUtil.setContentView(this,R.layout.activity_request_summary);
       mPresenter = new RequestSummaryPresenter(this,new TaskPicDBHandler());

       mBinding.requestBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
               startActivity(new Intent(RequestSummaryActivity.this,LoginActivity.class));
           }
       });
    }


    @Override
    public void showPicRecyclerview() {
       PicAdapter adapter = new PicAdapter();
        mBinding.photosRecyclerView.setVisibility(View.VISIBLE);
        mBinding.photosRecyclerView.setAdapter(adapter);
        mBinding.photosRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }


    public class PicViewHolder extends RecyclerView.ViewHolder {
        ImageView gallaryIv;
        TextView picCountTv;
        ImageView backIV;

        public PicViewHolder(View itemView) {
            super(itemView);
            gallaryIv = itemView.findViewById(R.id.gallary_iv);
            picCountTv = itemView.findViewById(R.id.pic_count_tv);
            picCountTv.setVisibility(View.GONE);
            backIV = itemView.findViewById(R.id.white_bg_iv);
            backIV.setVisibility(View.GONE);
        }
    }



    public class PicAdapter extends RecyclerView.Adapter<PicViewHolder> {

        @Override
        public PicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(RequestSummaryActivity.this);
            View photoView = inflater
                    .inflate(R.layout.row_photo, parent, false);

           return new PicViewHolder(photoView);



        }



        @Override
        public void onBindViewHolder(PicViewHolder holder, int position) {






            holder.gallaryIv.setImageBitmap(mPresenter.getPicBitmap(position));



        }

        @Override
        public int getItemCount() {
            return mPresenter.countTotalPic();
        }
    }



}
