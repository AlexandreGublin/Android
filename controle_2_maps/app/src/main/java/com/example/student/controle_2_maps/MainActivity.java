package com.example.student.controle_2_maps;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.student.controle_2_maps.fragment.FragmentMapRestaurant;
import com.example.student.controle_2_maps.fragment.FragmentlistRestaurant;

import org.json.JSONArray;
import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    private ImageButton imageButton;
    private int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        page = 1;
        imageButton = (ImageButton) findViewById(R.id.img_icon_btn);

        refreshRestaurant();

        getFragmentManager().beginTransaction().replace(R.id.frame_layout, new FragmentlistRestaurant()).commit();
    }

    public void onClickIcon(View view){
        if(page == 1){
            page++;
        }else{
            page--;
        }

        switch (page){
            case 1 :
                imageButton.setImageResource(R.drawable.ic_map);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout, new FragmentlistRestaurant()).commit();
                break;
            case 2:
                imageButton.setImageResource(R.drawable.ic_format_list_bulleted);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout, new FragmentMapRestaurant()).commit();
                break;
            default:
                break;
        }
    }

    public void refreshRestaurant(){
        final String urlEmplacements = "https://opentable.herokuapp.com/api/restaurants?per_page=15&country=US&city=New York";

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlEmplacements, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(final JSONObject response) {
                try {

                    // Init Realm
                    Realm.init(getApplicationContext());

                    RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();

                    Realm realm = Realm.getInstance(config);

                    // all the emplacements
                    final JSONArray restaurantsJson = response.getJSONArray("restaurants");
                    for (int i = 0; i < restaurantsJson.length(); i++) {


                        // Get 1 restaurant
                        final JSONObject restaurantJson = (JSONObject) restaurantsJson.get(i);

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                try {

                                    // Add the emplacement to Realm only if he doesn't exist
                                    Restaurant restaurant = realm.createOrUpdateObjectFromJson(Restaurant.class, restaurantJson);
                                    switch (restaurant.getPrice()){
                                        case "1":
                                            restaurant.setPrice("Peu chère.");
                                            break;
                                        case "2":
                                            restaurant.setPrice("Abordable.");
                                            break;
                                        case "3" :
                                            restaurant.setPrice("Chère.");
                                            break;
                                        case "4" :
                                            restaurant.setPrice("Extravagant");
                                            break;
                                        default:
                                            restaurant.setPrice("Extrèmement chère");


                                    }

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
