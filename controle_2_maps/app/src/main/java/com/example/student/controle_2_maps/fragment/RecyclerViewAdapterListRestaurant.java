package com.example.student.controle_2_maps.fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.controle_2_maps.R;
import com.example.student.controle_2_maps.Restaurant;
import com.example.student.controle_2_maps.viewHolder.RecyclerViewHolderListRestaurant;

import java.util.List;

/**
 * Created by student on 03/11/2017.
 */

public class RecyclerViewAdapterListRestaurant extends RecyclerView.Adapter<RecyclerViewHolderListRestaurant>{
    private List<Restaurant> restaurants;
    private LayoutInflater inflate;

    public RecyclerViewAdapterListRestaurant(List<Restaurant> strings, LayoutInflater layoutInflater){
        super();
        restaurants = strings;
        inflate = layoutInflater;
    }

    @Override
    public RecyclerViewHolderListRestaurant onCreateViewHolder(ViewGroup parent, int viewType) {
        View cellView = inflate.inflate(R.layout.list_restaurants, parent, false);
        return new RecyclerViewHolderListRestaurant (cellView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderListRestaurant holder, int position) {
        try {
            Restaurant restaurant = restaurants.get(position);

            holder.setImageRestaurant(restaurant.getImage_url());
            holder.setTextName(restaurant.getName());
            holder.setTextPrice(restaurant.getPrice());

        }catch (Exception e){
            Log.e("ERREUR", e.getLocalizedMessage());
        }

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }
}