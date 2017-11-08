package com.example.student.courcamera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toQRCodeActivity(View view){
        Intent intent = new Intent(this, QRCodeActivity.class);
        startActivity(intent);
    }

    public void toCameraActivity(View view){
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }
}
