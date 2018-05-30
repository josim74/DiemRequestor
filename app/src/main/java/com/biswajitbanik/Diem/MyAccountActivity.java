package com.biswajitbanik.Diem;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.FragmentAccountBinding;

public class MyAccountActivity extends AppCompatActivity {

    private FragmentAccountBinding mBinding;
    private String[] mAccountNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this,R.layout.fragment_account);

        mAccountNames = new String[]{
                "Personal Information",
                "Change Password",
                "Change Mobile number"
        };

        MyAccountAdapter adapter =new MyAccountAdapter();
        mBinding.accountRecyclerView.setAdapter(adapter);
        mBinding.accountRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public class MyAccountViewHolder extends RecyclerView.ViewHolder{
        TextView accountTv;
        ImageView accountIv;


        public MyAccountViewHolder(View itemView) {
            super(itemView);
            accountTv = itemView.findViewById(R.id.setting_name_tv);
            accountIv = itemView.findViewById(R.id.setting_image_view);
            accountIv.setVisibility(View.GONE);


            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = accountTv.getText().toString();
                    if (text.equals("Personal Information")){
                        startActivity(new Intent(MyAccountActivity.this,Personal_informationActivity.class));
                    } else if (text.equals("Change Password")){
                        startActivity(new Intent(MyAccountActivity.this,Change_passwordActivity.class));

                    } else if(text.equals("Change Mobile number")) {
                        startActivity(new Intent(MyAccountActivity.this,Change_mobileNumberActivity.class));
                    }}
            });

        }
    }


    public class MyAccountAdapter extends RecyclerView.Adapter<MyAccountViewHolder>{

        @Override
        public MyAccountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(MyAccountActivity.this)
                    .inflate(R.layout.row_setting,parent,false);
            return new MyAccountViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyAccountViewHolder holder, int position) {
            holder.accountTv.setText(mAccountNames[position]);
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}
