package com.biswajitbanik.Diem.Message.ViewModel;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.biswajitbanik.Diem.R;

import com.biswajitbanik.Diem.databinding.FragmentMessageBinding;

public class MessageFragment  extends android.support.v4.app.Fragment{

    private FragmentMessageBinding mBinding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

          mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_message, container, false);

        MessageAdapter adapter = new MessageAdapter();
        mBinding.messageRecyclerView.setAdapter(adapter);
        mBinding.messageRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return mBinding.getRoot();
    }



    public class MessageViewHolder extends RecyclerView.ViewHolder{

        public MessageViewHolder(View itemView) {
            super(itemView);
        }
    }


    public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder>{

        @Override
        public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

           View view = LayoutInflater.from(getActivity())
                   .inflate(R.layout.row_message,parent,false);
            return new MessageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MessageViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }

}
