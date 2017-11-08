package com.example.student.carnetdenotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mylibrary.CarnetDeNotes;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendNote(View view){
        Intent intent = new Intent();

        // récupérer l'editText
        EditText editText = (EditText) findViewById(R.id.editText);

        // Ajouter le contenu de l'editText au carnet de note
        CarnetDeNotes c = new CarnetDeNotes("monCarnet");
       /* Float note = editText.getText().toString();
        c.ajouter(note);*/


    }




}
