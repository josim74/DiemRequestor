package com.biswajitbanik.Diem.Notification.ViewModel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.FragmentNotificationBinding;


public class NotificationFragment extends Fragment {

    private FragmentNotificationBinding mBinding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false);

        NoticficationAdapter adapter = new NoticficationAdapter();
        mBinding.NotificationRecyclerView.setAdapter(adapter);
        mBinding.NotificationRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return mBinding.getRoot();
    }


    public class NotificationViewHolder extends RecyclerView.ViewHolder{

        public NotificationViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class NoticficationAdapter extends RecyclerView.Adapter<NotificationViewHolder>{

        @Override
        public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.row_notification,parent,false);
            return new NotificationViewHolder(view);
        }

        @Override
        public void onBindViewHolder(NotificationViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }

}
