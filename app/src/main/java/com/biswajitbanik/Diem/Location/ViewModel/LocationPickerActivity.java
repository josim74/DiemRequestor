package com.biswajitbanik.Diem.Location.ViewModel;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.biswajitbanik.Diem.Location.Presenter.LocationPresenter;
import com.biswajitbanik.Diem.Location.Repository.LocationDBHandler;
import com.codility.introsilder.R;
import com.codility.introsilder.databinding.ActivityMainBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationPickerActivity extends AppCompatActivity implements LocationViewModel{
    private  ActivityMainBinding mBinding;
    private LocationPresenter mPresenter;
    private LocationAdapter mAdapter;
    private SupportMapFragment mMapFramgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mBinding= DataBindingUtil. setContentView(this,R.layout.activity_main);
       mPresenter=new LocationPresenter(this,new LocationDBHandler(this));
         mMapFramgent = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_container);

       mBinding.locationSearchEt.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.getLocationList(s.toString());
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });

       mBinding.searchBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });

      mBinding.locationSearchEt.setOnTouchListener(new View.OnTouchListener() {
          @Override
          public boolean onTouch(View v, MotionEvent event) {
              mBinding.locationSearchEt.setFocusableInTouchMode(true);
             mPresenter.onTouchSearchET();
              return false;
          }
      });

      mBinding.searchBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              mPresenter.onSearchBtnClick();
          }
      });
       drawMap(43.83,-79.50);

    }

    public void drawMap(final double latitude, final double longitude){

        mMapFramgent.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.clear();
                LatLng merchantLatLng=new LatLng(latitude,longitude);

                MarkerOptions marker = new MarkerOptions().position(merchantLatLng).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("location_picker",500,500)));

                googleMap.addMarker(marker);


                CameraPosition position=CameraPosition.builder().target(merchantLatLng)
                        .zoom(15f)
                        .tilt(0.0f)
                        .bearing(0.0f)
                        .build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(position));

                googleMap.getUiSettings().setZoomControlsEnabled(true);





            }
        });

    }

    @Override
    public String getSearchBtnText() {
        return mBinding.searchBtn.getText().toString();
    }

    @Override
    public void openHomeActivity() {
        finish();
    }

    @Override
    public void hideKeypad() {
        InputMethodManager inputMethodManager =
                (InputMethodManager) getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                mBinding.searchBtn.getWindowToken(), 0);
    }


    public Bitmap resizeMapIcons(String iconName, int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }


    @Override
    public void hideList() {
        mBinding.locationRecycler.setVisibility(View.GONE);
    }

    @Override
    public void refreshList() {
    mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showList() {
        mBinding.locationRecycler.setVisibility(View.VISIBLE);
        if (mAdapter!=null){
            mAdapter.notifyDataSetChanged();
        }else {
            mAdapter=new LocationAdapter();
            mBinding.locationRecycler.setAdapter(mAdapter);
            mBinding.locationRecycler.setLayoutManager(new LinearLayoutManager(LocationPickerActivity.this));
        }
    }

    @Override
    public void setSearchBtnTxt(String text) {
        mBinding.searchBtn.setText(text);
    }

    @Override
    public void setSearchEditText(String text) {
        mBinding.locationSearchEt.setText(text);
    }

    @Override
    public void searchETLostFocus() {
        mBinding.locationSearchEt.setFocusable(false);
    }



    public class LocationViewHolder extends RecyclerView.ViewHolder{
        private TextView primaryTV,secondaryTV;
        public LocationViewHolder(View itemView) {
            super(itemView);
            primaryTV=itemView.findViewById(R.id.location_primary_name_tv);
            secondaryTV=itemView.findViewById(R.id.location_secondary_name_tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.onSearchItemClick(getLayoutPosition());
                }
            });
        }
    }

    public class LocationAdapter extends RecyclerView.Adapter<LocationViewHolder>{

        @Override
        public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(LocationPickerActivity.this)
                    .inflate(R.layout.row_location_name,parent,false);
            return new LocationViewHolder(view);
        }

        @Override
        public void onBindViewHolder(LocationViewHolder holder, int position) {
            holder.primaryTV.setText(mPresenter.getPrimaryLocationText(position));
            holder.secondaryTV.setText(mPresenter.getSecondaryLocationText(position));

        }

        @Override
        public int getItemCount() {
            return mPresenter.getLocationListSize() ;
        }
    }
}
