package com.example.student.exo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if(view == button){
            Intent intent =  new Intent(MainActivity.this, GoogleSearch.class);

            startActivity(intent);
        }

    }
}
