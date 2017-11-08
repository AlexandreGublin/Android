package com.example.student.exo4;

import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Double> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeNotes();


        ListView listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return notes.size();
            }

            @Override
            public Object getItem(int i) {
                return notes.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {

                if(view == null){
                    // on choisie un modèle toute fait qui va être utilisé dans notre ListView (qui possède des textViews)
                    view = getLayoutInflater().inflate(R.layout.activity_main2, viewGroup, false);
                }

                // on récupère l'input du modèle donc ne pas oublier le view.findViewById
                TextView textView = (TextView) view.findViewById(R.id.textView);
                textView.setText(notes.get(i).toString());

                ImageView imageView = (ImageView) view.findViewById(R.id.img);
                ((ImageView) view.findViewById(R.id.img)).setColorFilter(new LightingColorFilter(Color.BLUE, Color.BLUE));


                // On renvoie notre modèle remplie
                return view;
            }
        });

        // si l'on clic sur l'une des notes (item) afficher la note
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Toast.makeText(MainActivity.this, "Vous avez choisie d'afficher " +notes.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void initializeNotes(){
        notes = new ArrayList<Double>();

        notes.add(2.);
        notes.add(18.50);
        notes.add(5.);
        notes.add(8.50);
        notes.add(2.);
        notes.add(3.);
        notes.add(2.);
        notes.add(18.);
        notes.add(5.50);
        notes.add(8.15);
        notes.add(2.);
        notes.add(3.);
        notes.add(2.25);
        notes.add(18.);
        notes.add(5.);
        notes.add(8.);
        notes.add(2.75);
        notes.add(3.);
    }

    public String GetColorNote(Double note){

       if(note >= 15. ){
           return "#64DD17";
       }else if(note >= 8.){
           return "#FB8C00";
       }else{
           return "#F4511E";
       }


    }
}
