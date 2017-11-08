package com.example.student.camping_imerir.models;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by student on 31/10/2017.
 */

public class Initialize {

    public static final void refreshEmplacement(final Context context){
        final String urlEmplacements = "http://10.0.2.2:8888/Symfony/Au_Camping/web/app_dev.php/api/emplacements";



        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlEmplacements, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(final JSONObject response) {
                try {

                    // Init Realm
                    Realm.init(context);

                    // Start a default instance realm
                    Realm realm = Realm.getDefaultInstance();

                    // all the emplacements
                    final JSONArray emplacementsJson = response.getJSONArray("Emplacements");
                    for (int i = 0; i < emplacementsJson.length(); i++) {


                        // Get 1 emplacement
                        final JSONObject emplacementJson = (JSONObject) emplacementsJson.get(i);

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                try {

                                    // Add the emplacement to Realm only if he doesn't exist
                                    Emplacement emplacement = realm.createOrUpdateObjectFromJson(Emplacement.class, emplacementJson);
                                    /*emplacement.setName_emplacement(emplacementJson.getString("name_emplacement"));
                                    emplacement.setPrice_emplacement(emplacementJson.getString("price_emplacement"));
                                    emplacement.setSurface_emplacement(Integer.parseInt(emplacementJson.getString("surface_emplacement")));
                                    emplacement.setNb_persons_emplacemenent(Integer.parseInt(emplacementJson.getString("nb_max_persons_emplacement")));
                                    emplacement.setNb_rooms_emplacement(Integer.parseInt(emplacementJson.getString("nb_rooms_emplacement")));
                                    emplacement.setLat_emplacement(emplacementJson.getString("lat_emplacement"));
                                    emplacement.setLng_emplacement(emplacementJson.getString("lng_emplacement"));*/


                                }catch (Exception e){
                                    Log.e("IMERIR", "\nErreur : " + e.getLocalizedMessage());
                                }
                            }
                        });

                    }

                }catch (Exception e){
                    Log.e("IMERIR", "Données = " + response + "\nErreur : " + e.getLocalizedMessage());
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("IMERIR", error.getLocalizedMessage());
            }
        });

        requestQueue.add(jsonObjectRequest);

    }
}
