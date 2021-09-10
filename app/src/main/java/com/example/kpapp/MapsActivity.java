package com.example.kpapp;

import android.os.Bundle;

import com.example.kpapp.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private FirebaseDatabase firebase;
    private DatabaseReference databaseReference;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference("divesite");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String lat = child.child("latitude").getValue().toString();
                    String lng = child.child("longtitude").getValue().toString();

                    double latitude = Double.parseDouble(lat);
                    double longitude = Double.parseDouble(lng);
                    LatLng loc = new LatLng(latitude, longitude);
                    googleMap.addMarker(new MarkerOptions().position(loc).title(child.child("namatempat").getValue().toString()));
                    // Move the camera instantly to Sydney with a zoom of 15.
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 15));

// Zoom in, animating the camera.
                    googleMap.animateCamera(CameraUpdateFactory.zoomIn());

// Zoom out to zoom level 10, animating with a duration of 2 seconds.
                    googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

// Construct a CameraPosition focusing on Mountain View and animate the camera to that position.
                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(loc )      // Sets the center of the map to Mountain View
                            .zoom(10)                   // Sets the zoom
                            .build();                   // Creates a CameraPosition from the builder
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}