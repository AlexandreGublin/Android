package com.example.student.camping_imerir.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.student.camping_imerir.DescriptionEmplacementActivity;
import com.example.student.camping_imerir.R;
import com.example.student.camping_imerir.RecyclerItemClickListener;
import com.example.student.camping_imerir.adapter.RecyclerViewAdapterListCatalog;
import com.example.student.camping_imerir.models.Emplacement;
import com.example.student.camping_imerir.models.Initialize;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmResults;


/**
 * Created by student on 26/10/2017.
 */

public class FragmentListCatalog extends Fragment {
    private View rootview;
    private List<Emplacement> emplacements;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Select the ViewFragment by the onItemClick
        rootview = inflater.inflate(R.layout.fragment_list_catalog, container, false);

        // Init the array
        emplacements = new ArrayList<Emplacement>();

        // Init Realm
        Realm.init(rootview.getContext());

        Realm realm = Realm.getDefaultInstance();

        Initialize.refreshEmplacement(rootview.getContext());

        // Get all Emplacements
       try {
           RealmResults<Emplacement> emplacementsRealm = realm.where(Emplacement.class).findAll();

           for (Emplacement emplacementRealm : emplacementsRealm){
               Log.d("ERROR", emplacementRealm.getName_emplacement());
               emplacements.add(emplacementRealm);

           }
        } catch (Exception e){
            Log.e("IMERIR", "Error realm get emplacements " + e.getLocalizedMessage());
        }



        RecyclerViewAdapterListCatalog adapter;
        adapter = new RecyclerViewAdapterListCatalog(emplacements, this.getActivity().getLayoutInflater());


        RecyclerView recyclerView = (RecyclerView) rootview.findViewById(R.id.rv);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), DescriptionEmplacementActivity.class);

                intent.putExtra("idEmplacement", emplacements.get(position).getId_emplacement());
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

