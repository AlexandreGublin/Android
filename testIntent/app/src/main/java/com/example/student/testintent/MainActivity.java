package com.example.student.testintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
                                                    // notre package            le message
    public static final String EXTRA_MESSAGE = "com.example.student.testintent.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

                            //appelle notre vue
    public void sendMessage(View view){
        // instancier un edit text          lui donner l'edit text qui est sur notre view, on le récupère par son ID
        EditText editText = (EditText) findViewById(R.id.editText);

                        // Récupère sous forme de chaine de char le contenu de notre editText
        String message = editText.getText().toString();

        //Intent explicite pour démarrer une seconde activité(donc un second controlleur qui renvoie sur une autre vue)
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //

        //putExtra va transférer les information d'une activité(controlleur) à une autre
        intent.putExtra(EXTRA_MESSAGE, message);

        //lancer l'intent
        startActivity(intent);
    }


}
