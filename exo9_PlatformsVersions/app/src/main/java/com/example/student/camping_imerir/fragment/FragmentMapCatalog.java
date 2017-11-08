package com.example.student.camping_imerir.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.camping_imerir.R;
import com.example.student.camping_imerir.models.Emplacement;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 26/10/2017.
 */

public class FragmentMapCatalog extends Fragment {
    private MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Select the ViewFragment by the onItemClick
        View rootview = inflater.inflate(R.layout.fragment_map_catalog, container, false);





        /* ------------------  MapBox ------------------- */

        // Instancié MapBox
        Mapbox.getInstance(getActivity(), getString(R.string.map_box_key));

        // Get the MapView of our Layout
        mapView = (MapView) rootview.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        // Add markers on the MapView
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                // Add a marker on Perpignan
                mapboxMap.addMarker(new MarkerOptions().position(new LatLng(42.674681, 2.848077)).title("Emplacement 1").snippet("description emplacement 1"));
                mapboxMap.addMarker(new MarkerOptions().position(new LatLng(42.674413, 2.848414)).title("Emplacement 3").snippet("description emplacement 3"));
                mapboxMap.addMarker(new MarkerOptions().position(new LatLng(42.674334, 2.848832)).title("Emplacement 2").snippet("description emplacement 2"));

            }
        });

        return rootview;

    }


  /*  @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
     public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public  void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }*/
}
