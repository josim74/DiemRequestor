package com.biswajitbanik.Diem;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.PaymentHistoryBinding;

public class Paymeny_HistoryActivity extends AppCompatActivity {


    private PaymentHistoryBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mBinding=DataBindingUtil.setContentView(this,R.layout.payment_history);

        PaymentHistoryAdapter adapter = new PaymentHistoryAdapter();
        mBinding.paymentHistoryRecyclerView.setAdapter(adapter);
        mBinding.paymentHistoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));




    }


    public class PaymentHistoryViewHolder extends RecyclerView.ViewHolder{

        public PaymentHistoryViewHolder(View itemView) {
            super(itemView);
        }
    }


    public class PaymentHistoryAdapter extends  RecyclerView.Adapter<PaymentHistoryViewHolder>{

        @Override
        public PaymentHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

           View view = LayoutInflater.from(Paymeny_HistoryActivity.this)
                   .inflate(R.layout.row_payment,parent,false);
            return new PaymentHistoryViewHolder(view);
        }

        @Override
        public void onBindViewHolder(PaymentHistoryViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }
}
