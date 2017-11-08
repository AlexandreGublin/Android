package com.example.student.exo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Recevoir l'intent et récupérer ses données
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Identifier notre textView et modifier son contenu par les données de l'intent
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(message);
    }

}
