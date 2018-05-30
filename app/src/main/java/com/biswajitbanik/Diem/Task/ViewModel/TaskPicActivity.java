package com.biswajitbanik.Diem.Task.ViewModel;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.Task.Presenter.TaskPicPresenter;
import com.biswajitbanik.Diem.Task.Repository.TaskPicDBHandler;
import com.biswajitbanik.Diem.databinding.ActivityTaskPicBinding;
import com.biswajitbanik.Diem.databinding.FragmentPicPickerDialogBinding;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

public class TaskPicActivity extends AppCompatActivity implements TaskPicViewModel {

    private static final int TAKE_PICTURE = 1;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 2;
    private ActivityTaskPicBinding mBinding;
    private TaskPicPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_task_pic);
        mPresenter = new TaskPicPresenter(this, new TaskPicDBHandler());

        mBinding.attachCircleImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PicPickerDialogFragment dialog = new PicPickerDialogFragment();
//                dialog.show(getSupportFragmentManager(),null);
//                BottomSheetBehavior bottomSheetBehavior =BottomSheetBehavior.from((View) dialog.getView().getParent());
//                bottomSheetBehavior.setPeekHeight(150);

                LayoutInflater inflater = LayoutInflater.from(TaskPicActivity.this);

                FragmentPicPickerDialogBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pic_picker_dialog, null, false);
                BottomSheetDialog dialog = new BottomSheetDialog(TaskPicActivity.this);
                dialog.setContentView(binding.getRoot());
                final BottomSheetBehavior behavior = BottomSheetBehavior.from((View) binding.getRoot().getParent());
                behavior.setPeekHeight(320);
                dialog.show();


                binding.cameraBgView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        enableNextButton();
                        behavior.setPeekHeight(0);
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                        File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
//                        intent.putExtra(MediaStore.EXTRA_OUTPUT,
//                                Uri.fromFile(photo));
//                        Uri imageUri = Uri.fromFile(photo);
                        startActivityForResult(intent, TAKE_PICTURE);
                    }
                });

                binding.gallaryBgView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        behavior.setPeekHeight(0);
                        if (ContextCompat.checkSelfPermission(TaskPicActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(TaskPicActivity.this,
                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                        } else
                            mPresenter.onGallaryBtnClick();
                    }
                });

            }
        });


        mBinding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mPresenter.onNextButtonClick();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    mPresenter.onGallaryBtnClick();
                }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void showPicRecyclerview() {
        PicAdapter adapter = new PicAdapter();
        mBinding.latestPicRecycler.setVisibility(View.VISIBLE);
        mBinding.latestPicRecycler.setAdapter(adapter);
        mBinding.latestPicRecycler.setLayoutManager(new GridLayoutManager(this, 3));
    }

    @Override
    public void disableNextButton() {
        mBinding.nextBtn.setEnabled(false);
        mBinding.nextBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.disable_next_button));
        mBinding.nextBtn.setTextColor(ContextCompat.getColor(this,R.color.disable_text_color));

    }

    @Override
    public void enableNextButton() {
        mBinding.nextBtn.setEnabled(true);
        mBinding.nextBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.btn_background));
        mBinding.nextBtn.setTextColor(ContextCompat.getColor(this,R.color.white));
    }

    @Override
    public void exit() {
        finish();
    }


    public class PicViewHolder extends RecyclerView.ViewHolder {
        ImageView gallaryIv;
        TextView picCountTv;

        public PicViewHolder(View itemView) {
            super(itemView);
            gallaryIv = itemView.findViewById(R.id.gallary_iv);
            picCountTv = itemView.findViewById(R.id.pic_count_tv);
        }
    }

    public class DefaultPicViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;

        public DefaultPicViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.attach_circle_imageview);
        }
    }


    public class PicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(TaskPicActivity.this);
            View photoView = inflater
                    .inflate(R.layout.row_photo, parent, false);

            View defaultPhotoView = inflater.inflate(R.layout.row_default_photo,parent,false);

            switch (viewType) {

                case 0:

                    return new DefaultPicViewHolder(defaultPhotoView);
               default:
                   return new PicViewHolder(photoView);

            }


        }

        @Override
        public int getItemViewType(int position) {

           return mPresenter.getPicItemViewType(position);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            switch (holder.getItemViewType()){


                case 1:
                    PicViewHolder picViewHolder = (PicViewHolder) holder;
                    picViewHolder.gallaryIv.setImageBitmap(mPresenter.getPicBitmap(position));
                    picViewHolder.picCountTv.setText(mPresenter.getPicCount(position));
                    break;
            }

        }

        @Override
        public int getItemCount() {
            return mPresenter.countTotalPic();
        }
    }
}
