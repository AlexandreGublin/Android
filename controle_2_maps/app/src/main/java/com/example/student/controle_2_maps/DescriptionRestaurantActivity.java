package com.example.student.controle_2_maps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.squareup.picasso.Picasso;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class DescriptionRestaurantActivity extends AppCompatActivity {
    private MapView mapView;
    private Restaurant restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_restaurant);

        TextView name = (TextView) findViewById(R.id.text_restaurant_name2);
        TextView price = (TextView) findViewById(R.id.text_restaurant_price2);
        ImageView img = (ImageView) findViewById(R.id.img_restaurant2);
        TextView address = (TextView) findViewById(R.id.text_restaurant_address2);


        // get intent
        Intent intent = getIntent();
        long idEmplacement = intent.getLongExtra("idRestaurant", 0);


        // Init Realm
        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();

        Realm realm = Realm.getInstance(config);

        // Get the Restaurant
        try {
            restaurant = realm.where(Restaurant.class).equalTo("id", idEmplacement).findFirst();
            name.setText(restaurant.getName());
            price.setText(restaurant.getPrice());
            Picasso.with(this).load(restaurant.getImage_url()).resize(150,150).centerCrop().into(img);
            address.setText(restaurant.getAddress());


        } catch (Exception e){
            Log.e("IMERIR", "Error realm get restaurants " + e.getLocalizedMessage());
        }






        // Instancié MapBox
        Mapbox.getInstance(this, getString(R.string.map_box_key));

        // Get the MapView of our Layout
        mapView = (MapView) findViewById(R.id.mapView2);
        mapView.onCreate(savedInstanceState);

        // Add markers on the MapView
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                mapboxMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(restaurant.getLat()), Double.parseDouble(restaurant.getLng()))).title(restaurant.getName()).snippet(restaurant.getAddress()));
            }
        });



    }

    public void onClickCall(View view){
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+restaurant.getPhone()));
        startActivity(callIntent);
    }

    public void onClickReserve(View view){
        Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(restaurant.getMobile_reserve_url()));
        startActivity(intent);
    }
}
