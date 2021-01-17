package com.example.polylines;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng delhi=new LatLng(28.7041,77.1025);
        LatLng mumbai=new LatLng(19.0760,72.8777);
        LatLng kolkata=new LatLng(22.5726,88.3639);
        LatLng chennai=new LatLng(13.0827,80.2707);
        googleMap.addMarker(new MarkerOptions()
                    .position(delhi).title("Delhi"));
        googleMap.addMarker(new MarkerOptions()
                .position(mumbai).title("Mumbai"));
        googleMap.addMarker(new MarkerOptions()
                .position(kolkata).title("Kolkata"));
        googleMap.addMarker(new MarkerOptions()
                .position(chennai).title("Chennai"));
        Polyline polyline=googleMap.addPolyline(new PolylineOptions()
                .add(delhi)
                .add(mumbai)
                .add(chennai)
                .add(kolkata)
                .add(delhi)
                .clickable(true)
                .width(10).color(Color.RED));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(20.5937,78.9629),4));
    }
}