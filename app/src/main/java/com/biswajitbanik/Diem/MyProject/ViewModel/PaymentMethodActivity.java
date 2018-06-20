package com.biswajitbanik.Diem.MyProject.ViewModel;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.ActivityPaymentMethodBinding;

public class PaymentMethodActivity extends AppCompatActivity {
    private ActivityPaymentMethodBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_payment_method);
        mBinding.feeDetailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentMethodActivity.this,FeeDetailsActivity.class));
            }
        });

        mBinding.confirmPaymetnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentMethodActivity.this,JobSuccessfullyScheduleMessageActivity.class));
            }
        });
    }
}
