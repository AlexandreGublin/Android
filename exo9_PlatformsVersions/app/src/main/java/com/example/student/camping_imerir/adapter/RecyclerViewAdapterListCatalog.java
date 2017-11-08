package com.example.student.camping_imerir.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.student.camping_imerir.R;
import com.example.student.camping_imerir.models.Emplacement;
import com.example.student.camping_imerir.view_holder.RecyclerViewHolderListCatalog;

import java.util.List;

/**
 * Created by student on 30/10/2017.
 */

public class RecyclerViewAdapterListCatalog extends RecyclerView.Adapter<RecyclerViewHolderListCatalog>{
        private List<Emplacement> emplacements;
    private LayoutInflater inflate;

    public RecyclerViewAdapterListCatalog(List<Emplacement> strings, LayoutInflater layoutInflater){
        super();
        emplacements = strings;
        inflate = layoutInflater;
    }

    @Override
    public RecyclerViewHolderListCatalog onCreateViewHolder(ViewGroup parent, int viewType) {
        View cellView = inflate.inflate(R.layout.list_emplacement, parent, false);
        return new RecyclerViewHolderListCatalog (cellView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderListCatalog holder, int position) {
        try {
            Emplacement emplacement = emplacements.get(position);

            holder.setTextPrice(emplacement.getPrice_emplacement());
            holder.setTextDescription(emplacement.getName_emplacement(), emplacement.getNb_persons_emplacemenent(),
                    emplacement.getNb_rooms_emplacement(), emplacement.getSurface_emplacement());
            holder.setImageButton();
        }catch (Exception e){
            Log.e("ERREUR", e.getLocalizedMessage());
        }

    }

    @Override
    public int getItemCount() {
        return emplacements.size();
    }
}
