package com.example.student.gublin_controle_android;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by student on 27/10/2017.
 */

class RecyclerViewHolder extends RecyclerView.ViewHolder{
    public RecyclerViewHolder (View itemView) {

        super(itemView);
    }

    //img
   ImageView getImageArticle(){
        return itemView.findViewById(R.id.img_article);
    }
    public void setImageArticle(String str){
        //getImageArticle().setImageURI(Uri.parse(str));

        Picasso.with(this.itemView.getContext()).load(str).into(getImageArticle());
    }

    // date and author
    TextView getTextDateAndAuthor() {
        return itemView.findViewById(R.id.text_date_and_author);
    }
    public void setTextDateAndAuthor(String date, String author){
        getTextDateAndAuthor().setText(date + " - " + author);
    }

    // title
    TextView getTextTitle() {
        return itemView.findViewById(R.id.text_title);
    }
    public void setTextTitle(String str){
        getTextTitle().setText(str);
    }

    // description
    TextView getTextDescription() {
        return itemView.findViewById(R.id.text_description);
    }
    public void setTextDescription(String str){
        getTextDescription().setText(str);
    }



}