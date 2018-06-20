package com.biswajitbanik.Diem.Faq;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.ActivityFaqBinding;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.ArrayList;
import java.util.List;

public class FaqActivity extends AppCompatActivity {
    private ActivityFaqBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mBinding= DataBindingUtil. setContentView(this,R.layout.activity_faq);

       List<ChildModel> demo = new ArrayList<>();
       demo.add(new ChildModel("Lorem ipsum dolor sit amet, consectetur consectetur adipiscing elit, sed do eiusmod tempor incididunt ut ut labore et dolore magna aliqu. Ut enim ad minim"));

       List<FaqGroup> faqGroups = new ArrayList<>();

       FaqGroup group = new FaqGroup("Molestie at elementum eu facilisi sed odio morIsbi?",demo);
       faqGroups.add(group);
        List<ChildModel> demo1 = new ArrayList<>();
       demo1.add(new ChildModel("\"Lorem ipsum dolor sit amet, consectetur consectetur adipiscing elit, sed do eiusmod tempor incididunt ut ut labore et dolore magna aliqu. Ut enim ad minim\""));

       group = new FaqGroup("Molestie at elementum eu facilisi sed odio morIsbi?",demo1);

       faqGroups.add(group);

       mBinding.recyclerView.setAdapter(new FaqAdapter(faqGroups));
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    public class HeaderView extends GroupViewHolder{
        TextView textView;
        public HeaderView(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
        }
    }

    public class ChildView extends ChildViewHolder {
        TextView textView;
        public ChildView(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
        }

    }

    public class  FaqAdapter extends ExpandableRecyclerViewAdapter<HeaderView,ChildView>{

        public FaqAdapter(List<? extends ExpandableGroup> groups) {
            super(groups);
        }

        @Override
        public HeaderView onCreateGroupViewHolder(ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(FaqActivity.this)
                   .inflate(R.layout.row_header_faq,parent,false);

            return new HeaderView(view);
        }

        @Override
        public ChildView onCreateChildViewHolder(ViewGroup parent, int viewType) {


            View view = LayoutInflater.from(FaqActivity.this)
                    .inflate(R.layout.row_child_faq,parent,false);
            return new ChildView(view);
        }

        @Override
        public void onBindChildViewHolder(ChildView holder, int flatPosition, ExpandableGroup group, int childIndex) {
            ChildModel model =  ((FaqGroup) group).getItems().get(childIndex);
            holder.textView.setText(model.getmText());
        }

        @Override
        public void onBindGroupViewHolder(HeaderView holder, int flatPosition, ExpandableGroup group) {
                String text = group.getTitle();
                holder.textView.setText(text);
        }
    }
}
