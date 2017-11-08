package com.example.student.exo2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class GoogleSearch extends AppCompatActivity implements View.OnClickListener{
    private ImageButton imageButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_search);

        imageButton = (ImageButton) findViewById(R.id.btnSearch);
        editText = (EditText) findViewById(R.id.editSearch);
        imageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // si l'on appuie sur notre image button
        if(view == imageButton){
            final String requete = "http://wwww.google.fr/search?q="+ editText.getText();
            //Uri = définie ce que notre views va ouvrir avec notre url
            Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(requete));
            startActivity(intent);
        }

    }
}
