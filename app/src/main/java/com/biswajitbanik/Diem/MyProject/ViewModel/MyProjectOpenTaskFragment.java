package com.biswajitbanik.Diem.MyProject.ViewModel;


import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.FragmentMyProjectOpenTaskBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProjectOpenTaskFragment extends Fragment {
    private FragmentMyProjectOpenTaskBinding mBinding;
    private SupportMapFragment mMapFramgent;
    public MyProjectOpenTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_project_open_task, container, false);
        mMapFramgent = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_container);

        drawMap(43.83,-79.50);

        return mBinding.getRoot();
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

    public Bitmap resizeMapIcons(String iconName, int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getActivity().getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }

}
