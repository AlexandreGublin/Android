package com.example.student.intentimplicite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
                                                    // rajouter avec implements un évenement sur la vue
                                                    // (cliquer sur erreur et générer la méthode onClick)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // déclarer notre btn
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = (Button) findViewById(R.id.button);

        // on enregistre l'activité auprès du bouton pour reçevoir les évênements "clic" provoqué par l'utilisateur
        mBtn.setOnClickListener(this);

    }

    // on override car la methode onClick provient de la class View

    @Override
    public void onClick(View view) {

        if(view == mBtn){
            Intent intent = new Intent(MainActivity.this, GoogleSearch.class);

            startActivity(intent);
        }

    }
}
