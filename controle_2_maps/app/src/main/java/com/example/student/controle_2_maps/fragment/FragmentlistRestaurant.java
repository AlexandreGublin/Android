package com.example.student.controle_2_maps.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.student.controle_2_maps.DescriptionRestaurantActivity;
import com.example.student.controle_2_maps.R;
import com.example.student.controle_2_maps.RecyclerItemClickListener;
import com.example.student.controle_2_maps.Restaurant;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by student on 03/11/2017.
 */

public class FragmentlistRestaurant extends Fragment {
    private View rootview;
    private List<Restaurant> restaurants;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Select the ViewFragment by the onItemClick
        rootview = inflater.inflate(R.layout.fragment_list_restaurant, container, false);

        // Init the array
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



        RecyclerViewAdapterListRestaurant adapter;
        adapter = new RecyclerViewAdapterListRestaurant(restaurants, this.getActivity().getLayoutInflater());


        RecyclerView recyclerView = (RecyclerView) rootview.findViewById(R.id.rv_restaurant);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), DescriptionRestaurantActivity.class);

                intent.putExtra("idRestaurant", restaurants.get(position).getId());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return rootview;
    }
}
