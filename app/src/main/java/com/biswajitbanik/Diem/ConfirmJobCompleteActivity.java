package com.biswajitbanik.Diem;

import android.databinding.DataBindingUtil;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.biswajitbanik.Diem.databinding.ActivityConfirmJobCompleteBinding;
import com.biswajitbanik.Diem.databinding.ActivityJobCompleteBinding;

public class ConfirmJobCompleteActivity extends AppCompatActivity {
    private ActivityConfirmJobCompleteBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_confirm_job_complete);
        mBinding.recycleView1.setAdapter(new RateAdapter() );
        mBinding.recycleView1.setLayoutManager(new LinearLayoutManager(ConfirmJobCompleteActivity.this,LinearLayoutManager.HORIZONTAL,false));




    }


    public class RateViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView ;
        public RateViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.jobber_work_image_view);
        }
    }

    public class RateAdapter extends RecyclerView.Adapter<RateViewHolder>{

        @Override
        public RateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ConfirmJobCompleteActivity.this)
                    .inflate(R.layout.row_jobber_work,parent,false);
            return new RateViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RateViewHolder holder, int position) {
            holder.imageView.setImageDrawable(ContextCompat.getDrawable(ConfirmJobCompleteActivity.this,R.drawable.great_value));
        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }



}
