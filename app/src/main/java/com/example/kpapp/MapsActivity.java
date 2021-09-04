package com.example.kpapp;

import android.os.Bundle;

import com.example.kpapp.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import androidx.fragment.app.FragmentActivity;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    ArrayList<LatLng>arrayList = new ArrayList<LatLng>();
    ArrayList<String>namatempat= new ArrayList<String>();
    LatLng MantaPoint = new LatLng(-8.362588839, 116.0343924);
    LatLng Halik = new LatLng(-8.337904488, 116.0354148301);
    LatLng Deepturbo = new LatLng(-8.3383426718, 116.0464424543);
    LatLng ShallowTurbo = new LatLng(-8.3404605598, 116.0429369844);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayList.add(MantaPoint);
        arrayList.add(Halik);
        arrayList.add(Deepturbo);
        arrayList.add(ShallowTurbo);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        for (int i=0;i<arrayList.size();i++){
            mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }
    }
}