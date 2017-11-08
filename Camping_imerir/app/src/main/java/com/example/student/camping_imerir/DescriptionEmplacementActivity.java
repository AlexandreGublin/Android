package com.example.student.camping_imerir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.student.camping_imerir.models.Emplacement;
import com.example.student.camping_imerir.models.Initialize;
import com.squareup.picasso.Picasso;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.RealmClass;

public class DescriptionEmplacementActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView text_surface, text_persons, text_rooms, text_title_description, text_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_emplacement);

        imageView = (ImageView) findViewById(R.id.img_emplacement);
        text_surface = (TextView) findViewById(R.id.text_price);
        text_persons = (TextView) findViewById(R.id.textView_persons);
        text_rooms = (TextView) findViewById(R.id.textView_rooms);
        text_title_description = (TextView) findViewById(R.id.textView_title_description);
        text_description = (TextView) findViewById(R.id.text_description);

        // get intent
        Intent intent = getIntent();
        String idEmplacement = intent.getStringExtra("idEmplacement");


        // Init Realm
        Realm.init(this);

        Realm realm = Realm.getDefaultInstance();

        // Get the Emplacement
        try {
            Emplacement emplacement = realm.where(Emplacement.class).equalTo("id_emplacement", Integer.parseInt(idEmplacement)).findFirst();
            text_surface.setText(emplacement.getSurface_emplacement() +"m²");
            text_rooms.setText(emplacement.getNb_rooms_emplacement()+ "rooms");
            text_persons.setText(emplacement.getNb_persons_emplacemenent() + "prs");
            text_title_description.setText(emplacement.getName_emplacement());


            String url = "https://image.noelshack.com/fichiers/2017/44/1/1509374343-img-camping.jpg";
            Picasso.with(this).load(url).into(imageView);

        } catch (Exception e){
            Log.e("IMERIR", "Error realm get emplacements " + e.getLocalizedMessage());
        }
    }
}
