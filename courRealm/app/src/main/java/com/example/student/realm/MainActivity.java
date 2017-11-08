
package com.example.student.realm;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student.realm.models.Eleve;
import com.example.student.realm.models.Matiere;
import com.example.student.realm.models.Note;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialiser Realm
        Realm.init(this); //getBaseContext());

        // Ouvrir une instance realm
        Realm realm = Realm.getDefaultInstance();


        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                Eleve eleve1 = realm.createObject(Eleve.class, System.currentTimeMillis());
                eleve1.setNom("Gublin");
                eleve1.setPrenom("Alexandre");
                realm.insert(eleve1);

                Matiere histoire = realm.createObject(Matiere.class, System.currentTimeMillis());
                histoire.setLibelle("Anglais");
                realm.insertOrUpdate(histoire);

                Note note1 = realm.createObject(Note.class, System.currentTimeMillis());
                note1.setEleve(eleve1);
                note1.setMatiere(histoire);
                note1.setNote(16);
                realm.insertOrUpdate(note1);

                //Créer un élève
               /* Eleve eleve = new Eleve("Gublin2", "Alexandre2");

                //Créer une matière
                Matiere math = new Matiere("Géographie");

                //Instancié une nouvelle note à l'élève dans cette matière
                Note note = new Note(math, eleve, 8);*/
            }
        });


        RealmResults<Eleve> eleves = realm.where(Eleve.class)
                .findAll();
               /* .where()
                .equalTo("dogs.color", "Brown")
                .findAll()
                .where()
                .equalTo("dogs.color", "Yellow")
                .findAll();*/

        RealmResults<Matiere> matieres = realm.where(Matiere.class)
                .findAll();



        Log.i("IMERIR", "Les matières sont : "  + matieres);

        afficher();
    }

    public void afficher(){

        RecyclerViewAdapter adapter;
        adapter = new RecyclerViewAdapter(null, getLayoutInflater());


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        /*recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Vous avez choisie d'afficher " +data.get(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Vous avez choisie d'afficher " +data.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        }));*/

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}


class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    private List<String> data;
    private LayoutInflater inflate;

    public RecyclerViewAdapter(List<String> strings, LayoutInflater layoutInflater){
        super();
        data = strings;
        inflate = layoutInflater;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cellView = inflate.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new RecyclerViewHolder (cellView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.setText(data.get(position));
    }

    @Override
    public int getItemCount() {

        return data.size();
    }
}

class RecyclerViewHolder extends RecyclerView.ViewHolder{
    public RecyclerViewHolder (View itemView) {

        super(itemView);
    }

    public void setText(String str){
        getTextView().setText(str);
    }

    TextView getTextView() {
        return itemView.findViewById(android.R.id.text1);
    }
}



