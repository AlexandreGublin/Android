package com.example.student.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> names = Arrays.asList("Justin", "Martin", "Juan", "Eddy", "Franc", "Justin", "Martin", "Juan", "Eddy", "Franc");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(new BaseAdapter() { // va générer les méthodes automatique lorsque l'on écrit le "new Base Adapter()"
            @Override
            public int getCount() {
                return names.size();
            }

            @Override
            public Object getItem(int i) {
                return names.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                if(view == null){
                    view = getLayoutInflater().inflate(android.R.layout.simple_list_item_1, viewGroup, false);
                }

                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(names.get(i));
                return view;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Vous avez choisi d'afficher : " + names.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
