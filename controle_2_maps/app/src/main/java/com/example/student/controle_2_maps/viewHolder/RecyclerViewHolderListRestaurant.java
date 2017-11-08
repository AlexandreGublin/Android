package com.example.student.controle_2_maps.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.student.controle_2_maps.R;
import com.squareup.picasso.Picasso;

/**
 * Created by student on 03/11/2017.
 */

public class RecyclerViewHolderListRestaurant extends RecyclerView.ViewHolder{
    public RecyclerViewHolderListRestaurant (View itemView) {

        super(itemView);
    }


    private ImageView getImageRestaurant(){
        return itemView.findViewById(R.id.img_restaurant);
    }
    public void setImageRestaurant(String url){
        Picasso.with(this.itemView.getContext()).load(url).resize(150,150).centerCrop().into(getImageRestaurant());
        //Picasso.with(this.itemView.getContext()).load(url).into(getImageRestaurant());
    }

    private TextView getTextViewName() {
        return itemView.findViewById(R.id.text_name_restaurant);
    }
    public void setTextName(String str){
        getTextViewName().setText(str);
    }

    private TextView getTextViewPrice() {
        return itemView.findViewById(R.id.text_price_restaurant);
    }
    public void setTextPrice(String str){
        getTextViewPrice().setText(str);
    }

}
