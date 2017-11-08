package com.example.student.controle_2_maps.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.controle_2_maps.R;
import com.example.student.controle_2_maps.Restaurant;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by student on 03/11/2017.
 */

public class FragmentMapRestaurant extends Fragment {
    private MapView mapView;
    private List<Restaurant> restaurants;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Select the ViewFragment by the onItemClick
        View rootview = inflater.inflate(R.layout.fragment_map_restaurant, container, false);


        restaurants = new ArrayList<Restaurant>();

        // Init Realm
        Realm.init(rootview.getContext());

        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();

        Realm realm = Realm.getInstance(config);

        // Get all the Restaurants
        try {
            RealmResults<Restaurant> restaurantRealmResults = realm.where(Restaurant.class).findAll();

            for (Restaurant emplacementRealm : restaurantRealmResults){
                restaurants.add(emplacementRealm);

            }
        } catch (Exception e){
            Log.e("IMERIR", "Error realm get restaurants " + e.getLocalizedMessage());
        }


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

                for (Restaurant restaurant : restaurants)
                mapboxMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(restaurant.getLat()), Double.parseDouble(restaurant.getLng()))).title(restaurant.getName()).snippet(restaurant.getAddress()));
            }
        });

        return rootview;

    }
}