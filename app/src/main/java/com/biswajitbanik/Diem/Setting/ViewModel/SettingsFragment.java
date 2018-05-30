package com.biswajitbanik.Diem.Setting.ViewModel;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.biswajitbanik.Diem.ContactUsActivity;
import com.biswajitbanik.Diem.LogOutActivity;
import com.biswajitbanik.Diem.MyAboutusActivity;
import com.biswajitbanik.Diem.MyAccountActivity;
import com.biswajitbanik.Diem.PaymentMethodActivity;
import com.biswajitbanik.Diem.Paymeny_HistoryActivity;
import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment{

   private FragmentSettingsBinding mBinding;
   private String[] mSettingsName;
   private int [] mSettingPicId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false);
        mSettingsName = new String[]{
                "Account",
                "Payment Method",
                "Payment History",
                "Notifications Settings",
                "Reviews Pending",
                "FAQ",
                "About Us",
                "Contact Us",
                "Become a Jobber",
                "Log out"
        };


        mSettingPicId = new  int[]{
                R.drawable.setting_account,
                R.drawable.setting_payment_history,
                R.drawable.setting_faq,
                R.drawable.notification_unselected,
                R.drawable.setting_payment_history,
                R.drawable.setting_faq,
                R.drawable.setting_about_us,
                R.drawable.setting_contact_us,
                R.drawable.setting_become_jobber,
                R.drawable.setting_logout
        };


        SettingAdapter adapter = new SettingAdapter();
        mBinding.settingRecyclerView.setAdapter(adapter);
        mBinding.settingRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));





        return mBinding.getRoot();
    }


    public class SettingViewHolder extends RecyclerView.ViewHolder{
        TextView settingTextView;
        ImageView settingImageView;
        public SettingViewHolder(View itemView) {
            super(itemView);
            settingTextView = itemView.findViewById(R.id.setting_name_tv);
            settingImageView = itemView.findViewById(R.id.setting_image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = settingTextView.getText().toString();
                    if (text.equals("Log out")){
                        startActivity(new Intent(getActivity(), LogOutActivity.class));
                    } else if (text.equals("Contact Us")){
                        startActivity(new Intent(getActivity(), ContactUsActivity.class));
                    } else if(text.equals("Payment Method")) {
                        startActivity(new Intent(getActivity(), PaymentMethodActivity.class));
                    } else if(text.equals("Account")) {
                        startActivity(new Intent(getActivity(), MyAccountActivity.class));
                    } else if (text.equals("About Us")){
                        startActivity(new Intent(getActivity(), MyAboutusActivity.class));
                    } else if (text.equals("Payment History")){
                        startActivity(new Intent(getActivity(), Paymeny_HistoryActivity.class));
                    }

                }
            });
        }
    }

    public class SettingAdapter extends RecyclerView.Adapter<SettingViewHolder>{

        @Override
        public SettingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.row_setting,parent,false);
            return new SettingViewHolder(view);
        }

        @Override
        public void onBindViewHolder(SettingViewHolder holder, int position) {
            holder.settingImageView.setImageDrawable(ContextCompat.getDrawable(getActivity(),mSettingPicId[position]));
            holder.settingTextView.setText(mSettingsName[position]);
        }

        @Override
        public int getItemCount() {
            return mSettingPicId.length;
        }
    }



}
