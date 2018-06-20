package com.biswajitbanik.Diem.Task.ViewModel;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.biswajitbanik.Diem.R;
import com.biswajitbanik.Diem.databinding.FragmentTaskLocationBinding;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.content.Context.LOCATION_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskLocationFragment extends Fragment {

    public static final int LOCATION_UPDATE_MIN_DISTANCE = 10;
    public static final int LOCATION_UPDATE_MIN_TIME = 5000;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1;

    private FragmentTaskLocationBinding mBinding;
    private LocationManager mLocationManager;
    private SupportMapFragment mMapFramgent;
    private int GOOGLE_API_CLIENT_ID = 0;
    private GoogleApiClient mGoogleApiClient;


    private Place mPlace;
    private String mName, mAddress;

    private SupportMapFragment mMapFragment;

    private LocationFragmentCallback mCallback;

    public TaskLocationFragment() {
        // Required empty public constructor
    }

    /*private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(final Location location) {
            //your code here
            drawMap(location.getLatitude(), location.getLongitude());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_location, container, false);

        mMapFramgent = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_container);




        mLocationManager = (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);

        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(getActivity(), GOOGLE_API_CLIENT_ID, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Log.e("map_testing", "Google Places API connection failed with error code: "
                                + connectionResult.getErrorCode());
                    }
                })
                .build();


        mMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_container);

        mMapFragment.getView().setVisibility(View.GONE);


        mBinding.locationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               getChildFragmentManager().beginTransaction().show(mMapFragment).commit();
                mMapFragment.getView().setVisibility(View.VISIBLE);
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                    Manifest.permission.ACCESS_COARSE_LOCATION},
                            MY_PERMISSIONS_REQUEST_LOCATION);

                } else {
                    callPlaceDetectionApi();
                }

                /*if (mPlace !=null){
                    mBinding.streetAddressOneEt.setText(mName);
                    mBinding.streetAddressTwoEt.setText(mAddress);
                }*/
            }
        });

        mBinding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onSuccessfulComplete();
            }
        });


        return mBinding.getRoot();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    callPlaceDetectionApi();
                }
                break;
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

   /* @SuppressLint("MissingPermission")
    private void getCurrentLocation() {
        mFusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                drawMap(location.getLatitude(), location.getLongitude());
            }
        });
    }*/


    public void drawMap(final double latitude, final double longitude) {

        mMapFramgent.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.clear();
                LatLng merchantLatLng = new LatLng(latitude, longitude);

                MarkerOptions marker = new MarkerOptions().position(merchantLatLng).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("location_picker", 500, 500)));

                googleMap.addMarker(marker);


                CameraPosition position = CameraPosition.builder().target(merchantLatLng)
                        .zoom(17f)
                        .tilt(0.0f)
                        .bearing(0.0f)
                        .build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(position));

                googleMap.getUiSettings().setZoomControlsEnabled(true);


            }
        });

    }

    private void callPlaceDetectionApi() throws SecurityException {
        PendingResult<PlaceLikelihoodBuffer> result = Places.PlaceDetectionApi
                .getCurrentPlace(mGoogleApiClient, null);
        result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
            @Override
            public void onResult(PlaceLikelihoodBuffer likelyPlaces) {
                double maxLikelyhood = 0;
                PlaceLikelihood maxPlaceLikeLihood=null;
                for (PlaceLikelihood placeLikelihood : likelyPlaces) {
                    Log.i("map_testing", String.format("Place '%s' with " +
                                    "likelihood: %g",
                            placeLikelihood.getPlace().getName(),
                            placeLikelihood.getLikelihood()));

                    if (placeLikelihood.getLikelihood() > maxLikelyhood) {
                        maxLikelyhood = placeLikelihood.getLikelihood();
                        maxPlaceLikeLihood = placeLikelihood;
                    }



                }

                mPlace = maxPlaceLikeLihood.getPlace();
                drawMap(maxPlaceLikeLihood.getPlace().getLatLng().latitude, maxPlaceLikeLihood.getPlace().getLatLng().longitude);

//                mName = mPlace.getName().toString();
//                mAddress = mPlace.getAddress().toString();
                mBinding.streetAddressOneEt.setText(mPlace.getName().toString());
                mBinding.streetAddressTwoEt.setText(mPlace.getAddress().toString());

                likelyPlaces.release();
            }
        });
    }

    public Bitmap resizeMapIcons(String iconName, int width, int height) {
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier(iconName, "drawable", getActivity().getPackageName()));
        return Bitmap.createScaledBitmap(imageBitmap, width, height,
                false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (LocationFragmentCallback) context;
    }

    public interface LocationFragmentCallback{
        public void onSuccessfulComplete();
    }


}
