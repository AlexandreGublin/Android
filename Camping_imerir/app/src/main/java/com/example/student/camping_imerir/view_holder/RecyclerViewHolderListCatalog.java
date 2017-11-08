package com.example.student.camping_imerir.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.student.camping_imerir.R;
import com.squareup.picasso.Picasso;

/**
 * Created by student on 30/10/2017.
 */

public class RecyclerViewHolderListCatalog extends RecyclerView.ViewHolder{
    public RecyclerViewHolderListCatalog (View itemView) {

        super(itemView);
    }

    private ImageButton getImageButton(){
        return itemView.findViewById(R.id.imageButton);
    }
    public void setImageButton(){
        String url = "https://image.noelshack.com/fichiers/2017/44/1/1509374343-img-camping.jpg";
        //Picasso.with(this.itemView.getContext()).load(url).resize(280,280).centerCrop().into(getImageButton());
        Picasso.with(this.itemView.getContext()).load(url).into(getImageButton());
    }

    private TextView getTextViewPrice() {
        return itemView.findViewById(R.id.text_price);
    }
    public void setTextPrice(String str){
        getTextViewPrice().setText(str+"€");
    }

    private TextView getTextViewDescription(){
        return itemView.findViewById(R.id.text_description);
    }
    public void setTextDescription(String name, int nb_persons, int nb_rooms, int surface){
        getTextViewDescription().setText(name +  " / " + nb_persons+ "pers" + " / " + nb_rooms + "rooms" + " / " + surface + "m²");
    }

}
