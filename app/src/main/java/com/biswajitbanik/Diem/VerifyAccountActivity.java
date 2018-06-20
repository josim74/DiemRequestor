package com.biswajitbanik.Diem;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.biswajitbanik.Diem.databinding.VerifyAccountBinding;

public class VerifyAccountActivity extends AppCompatActivity {
    private VerifyAccountBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.verify_account);

        mBinding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VerifyAccountActivity.this,SignupSuccessfullActivity.class));
                finish();
            }
        });


    }
}
